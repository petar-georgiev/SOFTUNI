package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Agent;
import softuni.exam.models.Apartment;
import softuni.exam.models.Offer;
import softuni.exam.models.enums.ApartmentType;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

@Query("select o from offers as o " +
        "where o.apartment.apartmentType = ?1 " +
        "order by o.apartment.area desc, o.price asc")
List<Offer> findAllByApartmentType(ApartmentType apartmentType);

}
