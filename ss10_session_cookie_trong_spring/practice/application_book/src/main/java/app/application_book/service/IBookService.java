package app.application_book.service;

import app.application_book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    Book findByCode(long code);

}
