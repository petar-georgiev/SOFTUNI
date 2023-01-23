package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.dto.PostRootSeedDto;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private static final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserService userService;
    private final PictureService pictureService;
    private final StringBuilder sb;

    public PostServiceImpl(PostRepository postRepository, UserService userService, PictureService pictureService, StringBuilder sb, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.pictureService = pictureService;
        this.sb = sb;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;


    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        xmlParser.fromFile(POST_FILE_PATH, PostRootSeedDto.class)
                .getPosts().forEach(postSeedDto -> {
                            if (validationUtil.isValid(postSeedDto)
                                    && pictureService.isEntityExist(postSeedDto.getPicture().getPath())
                                    && userService.isEntityExistsUsername(postSeedDto.getUser().getUsername())) {
                            sb.append("Successfully imported Post, made by "
                                    + postSeedDto.getUser().getUsername()
                                    + System.lineSeparator());
                                Post post = modelMapper.map(postSeedDto, Post.class);
                                post.setUser(userService.findByUsername(postSeedDto.getUser().getUsername()));
                                post.setPicture(pictureService.findByPath(postSeedDto.getPicture().getPath()));
                                postRepository.save(post);
                            }else {
                                sb.append("Invalid Post" + System.lineSeparator());
                            }
                        }
                );
        return sb.toString();
    }

}
