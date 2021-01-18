package management.system.at.an.IT.enterprise.demo.repo;

import management.system.at.an.IT.enterprise.demo.models.Manufacturer;
import org.springframework.data.repository.CrudRepository;


public interface ManufacturerRepo extends CrudRepository<Manufacturer,Long> {
}
