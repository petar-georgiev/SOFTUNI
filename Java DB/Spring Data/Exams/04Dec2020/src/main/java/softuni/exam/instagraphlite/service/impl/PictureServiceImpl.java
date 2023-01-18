package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";

    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final StringBuilder sb;

    public PictureServiceImpl(ModelMapper modelMapper, PictureRepository pictureRepository, Gson gson, ValidationUtil validationUtil, StringBuilder sb) {
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.sb = sb;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    boolean valid = validationUtil.isValid(pictureSeedDto) &&
                            !isEntityExist(pictureSeedDto.getPath());
                    sb.append(valid ? String.format("Successfully imported Picture, with size %.2f", pictureSeedDto.getSize())
                            : "Invalid Picture");
                    sb.append(System.lineSeparator());

                    return valid;
                })
                .map(pictureSeedDto ->
                        modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }


    @Override
    public String exportPictures() {
        StringBuilder out = new StringBuilder();
        List<Picture> pictures = pictureRepository.findALLBySizeBiggerThan(Double.valueOf(30000));
        pictures.stream()
                .sorted(Comparator.comparing(Picture::getSize))
                .forEach(picture -> {
                    out.append(String.format("%.2f - %s%n",
                            picture.getSize(), picture.getPath()));
                });
        return out.toString();
    }

    @Override
    public Picture findByPath(String path) {
        return pictureRepository.findByPath(path).orElse(null);
    }

    @Override
    public boolean isEntityExist(String path) {
        return pictureRepository.existsByPath(path);
    }


}
