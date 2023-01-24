package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final String PATH_OF_USERS = "src/main/resources/files/users.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;


    public UserServiceImpl(ModelMapper modelMapper, Gson gson, UserRepository userRepository, PictureRepository pictureRepository, ValidationUtil validationUtil, StringBuilder sb, PictureService pictureService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_USERS));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readFromFileContent(), UserSeedDto[].class))
                .forEach(userSeedDto -> {
                    if (validationUtil.isValid(userSeedDto)
                            && isEntityExists(userSeedDto.getProfilePicture())
                            && !isEntityExistsUsername(userSeedDto.getUsername())) {
                        sb.append(String.format("Successfully imported User: %s"
                                , userSeedDto.getUsername()));
                        sb.append(System.lineSeparator());
                        User user = modelMapper.map(userSeedDto, User.class);
                        user.setProfilePicture(pictureService
                                .findByPath(userSeedDto.getProfilePicture()));
                        userRepository.save(user);
                    } else {
                        sb.append("Invalid User");
                        sb.append(System.lineSeparator());
                    }
                });
        return sb.toString();
    }


    private boolean isEntityExists(String path) {
        return pictureRepository.existsByPath(path);
    }

    @Override
    public boolean isEntityExistsUsername(String path) {
        return userRepository.existsByUsername(path);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder outSb = new StringBuilder();
        List<User> users = userRepository.findAllByPostOrderByPostDescIdAsc();

        users.forEach(user -> {
            outSb.append(String.format("User: %s%n" +
                            "Post count: %d%n",
                    user.getUsername(),
                    user.getPosts().size()));

            user.getPosts().stream()
                    .sorted(Comparator.comparing(s -> s.getPicture().getSize()))
                    .forEach(post -> {
                        outSb.append(
                       String.format("==Post Details:%n" +
                               "----Caption: %s%n" +
                               "----Picture Size: %.2f%n",
                               post.getCaption(),
                               post.getPicture().getSize()));
                    });
        });

        return outSb.toString();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findAllByUsername(username).orElse(null);
    }
}
