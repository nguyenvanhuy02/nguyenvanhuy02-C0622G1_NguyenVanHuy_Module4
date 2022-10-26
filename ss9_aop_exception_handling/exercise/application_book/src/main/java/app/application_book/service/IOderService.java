package app.application_book.service;

import app.application_book.model.Book;
import app.application_book.model.Oder;

import java.util.List;

public interface IOderService {
    List<Oder> findAll();

    Oder findById(Integer id);

    void save(Oder oder);

    Oder findByCode(long code);
}
