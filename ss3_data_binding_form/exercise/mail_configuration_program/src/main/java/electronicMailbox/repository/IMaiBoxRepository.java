package electronicMailbox.repository;

import java.util.List;

public interface IMaiBoxRepository {
    List<String> languages();
    List<String> pageSize();
    List<String> spamsFilter();
}
