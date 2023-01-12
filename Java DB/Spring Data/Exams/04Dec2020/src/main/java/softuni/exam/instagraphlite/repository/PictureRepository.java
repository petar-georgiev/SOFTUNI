package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Query("select (count(p) > 0) from pictures p where p.path = ?1")
    boolean existsByPath(String path);
    @Query("select p from pictures p where p.path = ?1")
    Optional<Picture> findByPath(String path);

    @Query("select p from pictures p where p.size>?1")
    List<Picture> findALLBySizeBiggerThan(Double i);

    //Optional for not null objects return
}
