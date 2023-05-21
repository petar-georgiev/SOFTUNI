package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
  @Query("select (count(c) > 0) from cities c where c.cityName = ?1")
  boolean existsByCityName(String city);


  @Query("select c from cities c where c.id = ?1")
  Optional<City> findById(Long id);


}
