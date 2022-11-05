package blog.app_blog.repository;

import blog.app_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String name);
}
