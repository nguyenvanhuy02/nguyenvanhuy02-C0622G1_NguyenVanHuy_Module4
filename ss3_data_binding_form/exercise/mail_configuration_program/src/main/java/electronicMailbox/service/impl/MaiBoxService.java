package electronicMailbox.service.impl;

import electronicMailbox.repository.IMaiBoxRepository;
import electronicMailbox.service.IMaiBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MaiBoxService implements IMaiBoxService {
    @Autowired
    IMaiBoxRepository maiBoxRepository;

    @Override
    public List<String> languages() {
        return maiBoxRepository.languages();
    }

    @Override
    public List<String> pageSize() {
        return maiBoxRepository.pageSize();
    }

    @Override
    public List<String> spamsFilter() {
        return maiBoxRepository.spamsFilter();
    }
}
