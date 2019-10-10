package softuni.carsoffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.carsoffer.domain.entities.Cars;

@Repository
public interface CarRepository extends JpaRepository<Cars, String> {
}
