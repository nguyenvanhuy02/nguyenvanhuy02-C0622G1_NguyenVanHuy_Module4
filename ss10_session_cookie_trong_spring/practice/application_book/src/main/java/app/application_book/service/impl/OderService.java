package app.application_book.service.impl;

import app.application_book.model.Oder;
import app.application_book.repository.IOderRepository;
import app.application_book.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepository oderRepository;

    @Override
    public List<Oder> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Oder findById(Integer id) {
        return oderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public Oder findByCode(long code) {
        return oderRepository.findByCode(code);
    }


}
