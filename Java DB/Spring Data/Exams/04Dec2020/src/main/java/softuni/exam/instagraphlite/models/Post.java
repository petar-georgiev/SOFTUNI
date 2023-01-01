package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "posts")
public class Post extends BaseEntity{
    private String caption;
    private User user;
    private Picture picture;

    public Post() {
    }

    @NotNull
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "picture_id")
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
