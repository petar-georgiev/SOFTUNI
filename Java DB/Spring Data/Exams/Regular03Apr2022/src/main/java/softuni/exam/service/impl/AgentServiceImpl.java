package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Agent;
import softuni.exam.models.Town;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    public static final String AGENT_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readAgentsFromFile(), AgentSeedDto[].class))
                .forEach(agentSeedDto -> {
                    if(validationUtil.isValid(agentSeedDto) &&
                            agentRepository.findAgentByFirstName(agentSeedDto.getFirstName()) == null){
                        Agent agent = modelMapper.map(agentSeedDto, Agent.class);
                        agent.setTown(townService.findByName(agentSeedDto.getTown()));
                        agentRepository.save(agent);
                        sb.append(String.format("Successfully imported agent - %s %s"
                            ,agentSeedDto.getFirstName()
                            ,agentSeedDto.getLastName()));
                        sb.append(System.lineSeparator());
                    }else {
                        sb.append("Invalid agent");
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();

    }

    @Override
    public Agent findByName(String name) {
        return agentRepository.findAgentByFirstName(name);
    }
}
