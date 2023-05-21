package softuni.exam.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "towns")
public class Town extends BaseEntity{
    private String townName;
    private Integer population;


    public Town() {
    }

    @Column(name = "town_name", nullable = false)
    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Column(nullable = false)
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
