package app.application_book.repository;

import app.application_book.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IOderRepository extends JpaRepository<Oder, Integer> {
    @Query(value = " select * from oder where code =:code", nativeQuery = true)
    Oder findByCode(@Param("code") long code);
}
