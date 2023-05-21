package softuni.exam.models;

import softuni.exam.models.enums.ApartmentType;

import javax.persistence.*;

@Entity(name = "apartments")
public class Apartment extends BaseEntity {
    private ApartmentType apartmentType;
    private Double area;
    private Town town;

    public Apartment(){
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Column(name = "apartment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column(nullable = false)
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
