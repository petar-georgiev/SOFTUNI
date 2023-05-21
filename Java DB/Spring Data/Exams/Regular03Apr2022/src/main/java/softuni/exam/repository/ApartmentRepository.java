package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {


    @Query("select a from apartments a where a.area = ?1 and a.town.townName = ?2")
    Apartment findApartmentByAreaAndTown_TownName(Double area, String townName);

    @Query("select a from apartments a where a.id = ?1")
    Apartment findApartmentById(Long id);
}
