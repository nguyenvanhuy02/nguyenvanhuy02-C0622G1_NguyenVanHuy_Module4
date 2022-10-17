package electronicMailbox.repository.impl;

import electronicMailbox.repository.IMaiBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaiBoxRepository implements IMaiBoxRepository {
    private static List<String> languageList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    private static List<String> pageSizeList = new ArrayList<>();

    static {
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("25");
        pageSizeList.add("50");
        pageSizeList.add("100");
    }

    private static List<String> spamsFilterList = new ArrayList<>();

    static {
        spamsFilterList.add("Enable spams filter");
    }

    @Override
    public List<String> languages() {
        return languageList;
    }

    @Override
    public List<String> pageSize() {
        return pageSizeList;
    }

    @Override
    public List<String> spamsFilter() {
        return spamsFilterList;
    }
}
