package softuni.exam.instagraphlite.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
@SuppressWarnings("unchecked")
public class XmlParserImpl implements XmlParser {
    @Override
    public <E> E fromFile(String filePath, Class<E> eClass) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(eClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new FileReader(filePath));
    }
}
