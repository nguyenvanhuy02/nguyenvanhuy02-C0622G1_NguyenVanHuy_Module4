package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DictionaryService implements IDictionaryService {

    private static Map<String,String> dictionary = new TreeMap<>();
    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }

    @Override
    public String search(String keyword) {
        if (dictionary.get(keyword) == null){
            return "Từ này không có trong từ điển";
        }else {
            return dictionary.get(keyword);
        }

    }
}
