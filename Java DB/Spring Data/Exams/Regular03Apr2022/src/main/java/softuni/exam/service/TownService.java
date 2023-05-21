package softuni.exam.service;

import softuni.exam.models.Town;

import java.io.IOException;
import java.util.List;


public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    Town findByName(String townName);
}
