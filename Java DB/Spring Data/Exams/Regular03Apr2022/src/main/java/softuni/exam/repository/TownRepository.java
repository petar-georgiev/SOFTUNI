package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Town;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

   Town findTownByTownName(String townName);

}
