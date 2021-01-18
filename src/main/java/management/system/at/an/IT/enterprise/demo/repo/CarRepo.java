package management.system.at.an.IT.enterprise.demo.repo;

import management.system.at.an.IT.enterprise.demo.models.Car;
import org.springframework.data.repository.CrudRepository;


public interface CarRepo extends CrudRepository<Car,Long> {
}
