package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    @Query("select u from users u where u.username = ?1")
    Optional<User> findAllByUsername(String username);

    @Query("select distinct u from users u join fetch u.posts p order by size(p) desc, u.id")
    List<User> findAllByPostOrderByPostDescIdAsc();
}
