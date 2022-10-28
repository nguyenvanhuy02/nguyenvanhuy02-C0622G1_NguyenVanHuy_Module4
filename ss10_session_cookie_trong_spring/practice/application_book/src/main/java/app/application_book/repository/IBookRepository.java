package app.application_book.repository;

import app.application_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = " select * from book join oder_book on book.id = oder_book.book_id join oder on oder_book.oder_id = oder.id where oder.code =:code", nativeQuery = true)
    Book findByCode(@Param("code") long code);
}
