package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select (count(c) > 0) from countries c where c.countryName = ?1")
    boolean existsByCountryName(String country);

    @Query("select c from countries c where c.id = ?1")
    Country findAllById(Long id);
}
