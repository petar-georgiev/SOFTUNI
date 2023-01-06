package softuni.exam.instagraphlite.models.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PictureSeedDto {
    @Expose
    private String path;
    @Expose
    private Double size;

    public PictureSeedDto() {
    }

    @NotBlank
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Min(500)
    @Max(60000)
    @NotNull
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
