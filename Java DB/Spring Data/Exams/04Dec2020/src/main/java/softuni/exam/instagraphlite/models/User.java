package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private Picture profilePicture;
    private Set<Post> posts;

    public User() {
    }

    @OneToMany(mappedBy = "user")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }


    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToOne
    @JoinColumn(name = "profile_picture_id")
    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }
}
