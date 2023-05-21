package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastRootSeedDto;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final CityService cityService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityService cityService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.forecastRepository = forecastRepository;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(FORECAST_FILE_PATH, ForecastRootSeedDto.class)
                .getForecasts()
                .stream().filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto)
                            && !findEntityWithSameDayAndCity(forecastSeedDto.getDayOfWeek(), forecastSeedDto.getCity());

                    sb.append(isValid ?
                            String.format("Successfully import forecast %s - %.2f",
                                    forecastSeedDto.getDayOfWeek(), forecastSeedDto.getMaxTemperature())
                            : "Invalid forecast").append(System.lineSeparator());
                    return isValid;
                })
                .forEach(c -> {
                    Forecast forecast = modelMapper.map(c, Forecast.class);
                    forecast.setCity(cityService.findCityById(c.getCity()));
                    forecastRepository.save(forecast);
                });
        return sb.toString();
    }


    private boolean findEntityWithSameDayAndCity(DaysOfWeek dayOfWeek, Long id) {
        return forecastRepository.existsByDaysOfWeekAndCity_Id(dayOfWeek, id);
    }

    @Override
    public String exportForecasts() {
        //Not enough time :(
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("City: {cityName}:\n" +
//                "-min temperature: {minTemperature}\n",
//                cityService))
        return null;
    }
}
