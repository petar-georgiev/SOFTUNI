package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Apartment;
import softuni.exam.models.dto.ApartmentRootSeedDto;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    public static final String APARTMENT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService) {
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(APARTMENT_FILE_PATH, ApartmentRootSeedDto.class)
                .getApartments()
                .forEach(apartmentSeedDto -> {
                    if (validationUtil.isValid(apartmentSeedDto) &&
                            apartmentRepository.findApartmentByAreaAndTown_TownName((apartmentSeedDto.getArea()),
                                    apartmentSeedDto.getTown()) == null) {

                        Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);
                        apartment.setTown(townService.findByName(apartmentSeedDto.getTown()));
                        apartmentRepository.save(apartment);

                        sb.append(String.format("Successfully imported apartment %s - %.2f",
                                apartmentSeedDto.getApartmentType(),
                                apartmentSeedDto.getArea()));
                        sb.append(System.lineSeparator());

                    } else {
                        sb.append("Invalid apartment");
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();

    }

    @Override
    public Apartment findById(Long id) {
        return apartmentRepository.findById(id).orElse(null);
    }
}
