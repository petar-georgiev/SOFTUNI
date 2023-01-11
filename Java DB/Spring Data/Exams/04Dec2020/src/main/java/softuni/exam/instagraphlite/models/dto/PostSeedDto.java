package softuni.exam.instagraphlite.models.dto;

import softuni.exam.instagraphlite.models.dto.PicturePathSeedDto;
import softuni.exam.instagraphlite.models.dto.UserUsernameSeedDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {

    @XmlElement
    private String caption;

    @XmlElement(name = "user")
    private UserUsernameSeedDto user;

    @XmlElement(name = "picture")
    private PicturePathSeedDto picture;

    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UserUsernameSeedDto getUser() {
        return user;
    }

    public void setUser(UserUsernameSeedDto user) {
        this.user = user;
    }

    @NotNull
    public PicturePathSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PicturePathSeedDto picture) {
        this.picture = picture;
    }
}
