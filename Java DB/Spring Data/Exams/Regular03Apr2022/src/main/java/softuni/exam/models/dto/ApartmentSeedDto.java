package softuni.exam.models.dto;

import jdk.jfr.Name;
import softuni.exam.models.enums.ApartmentType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Name("apartment")
public class ApartmentSeedDto {
    @XmlElement(name = "apartmentType")
    private ApartmentType apartmentType;
    @XmlElement
    private Double area;
    @XmlElement
    private String town;

    public ApartmentSeedDto() {
    }
    @Enumerated(EnumType.STRING)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @DecimalMin(value = "40.00")
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
