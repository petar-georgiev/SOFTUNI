package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {
    public static final String CITY_PATH_FILE = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
    }


    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_PATH_FILE));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent(), CitySeedDto[].class))
                .filter(citySeedDto -> {
                    boolean isValid = validationUtil.isValid(citySeedDto)
                            && !cityRepository.existsByCityName(citySeedDto.getCityName());
                    sb.append(isValid ? String.format("Successfully imported city %s - %d",
                            citySeedDto.getCityName(), citySeedDto.getPopulation())
                            : "Invalid city").append(System.lineSeparator());

                    return isValid;
                })
                .forEach(c -> {
                    City city = modelMapper.map(c, City.class);
                    city.setCountry(countryService.findByCountryId(c.getCountry()));
                    cityRepository.save(city);
                });
        return sb.toString();
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }


}
