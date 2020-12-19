package management.system.at.an.IT.enterprise.demo.repo;

import management.system.at.an.IT.enterprise.demo.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Users,Long> {
}
