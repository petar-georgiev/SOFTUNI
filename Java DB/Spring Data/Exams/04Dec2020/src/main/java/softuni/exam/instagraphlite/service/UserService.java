package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.User;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

public interface UserService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;

    boolean isEntityExistsUsername(String path);

    String exportUsersWithTheirPosts();

    User findByUsername(String username);
}
