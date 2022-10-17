package electronicMailbox.service;

import electronicMailbox.model.Email;

import java.util.List;

public interface IMaiBoxService {
    List<String> languages();
    List<String> pageSize();
    List<String> spamsFilter();
}
