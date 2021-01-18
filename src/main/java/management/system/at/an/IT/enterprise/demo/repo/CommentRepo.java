
package management.system.at.an.IT.enterprise.demo.repo;


        import management.system.at.an.IT.enterprise.demo.models.Comment;
        import org.springframework.data.repository.CrudRepository;


public interface CommentRepo extends CrudRepository<Comment,Long> {
}
