package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Agent;
import softuni.exam.models.Offer;
import softuni.exam.models.dto.OfferRootSeedDto;
import softuni.exam.models.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    public static final String OFFER_PATH_FILE = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, AgentService agentService, ApartmentService apartmentService, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_PATH_FILE));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(OFFER_PATH_FILE, OfferRootSeedDto.class)
                .getOffers()
                .forEach(offerSeedDto -> {

                    if (validationUtil.isValid(offerSeedDto)
                            && agentRepository.findAgentByFirstName(offerSeedDto.getAgent().getName()) != null
                            && apartmentRepository.findApartmentById(offerSeedDto.getApartment().getId()) != null
                    ) {
                        Offer offer = modelMapper.map(offerSeedDto, Offer.class);
                        offer.setAgent(agentService.findByName(offerSeedDto.getAgent().getName()));
                        offer.setApartment(apartmentService.findById(offerSeedDto.getApartment().getId()));
                        offerRepository.save(offer);
                        sb.append(String.format("Successfully imported offer %.2f", offerSeedDto.getPrice()));
                        sb.append(System.lineSeparator());
                    } else {
                        sb.append("Invalid offer");
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();
        ApartmentType apartmentType = ApartmentType.three_rooms;
        offerRepository.findAllByApartmentType(apartmentType)
                .forEach(offer -> sb.append(String.format("Agent %s %s with offer №%d%n " +
                        "\t\t-Apartment area: %s%n" +
                        "\t\t--Town: %s%n" +
                        "\t\t---Price: %.2f%n",
                        offer.getAgent().getFirstName(), offer.getAgent().getLastName()
                ,offer.getId(), offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice())));
        return sb.toString();
    }
}
