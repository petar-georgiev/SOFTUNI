package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {



    @Query("select (count(f) > 0) from forecast f where f.daysOfWeek = ?1 and f.city.id = ?2")
    boolean existsByDaysOfWeekAndCity_Id(DaysOfWeek day, Long id);
}
