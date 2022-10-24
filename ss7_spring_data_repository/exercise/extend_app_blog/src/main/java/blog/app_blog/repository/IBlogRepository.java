package blog.app_blog.repository;

import blog.app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog , Integer> {

    @Query(value = "SELECT * FROM app_blog.blog where author like %:name% and category like %:category " , nativeQuery = true)
    Page<Blog> findByNameAndByCategory(@Param("name") String name , @Param("category") String category , Pageable pageable);
}
