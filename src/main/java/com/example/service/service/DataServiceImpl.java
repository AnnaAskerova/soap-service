package com.example.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DataServiceImpl implements DataService {

    public DataServiceImpl() {

    }

    @Override
    public void addEntry(Long id, String name) {

    }

    @Override
    public void removeEntry(Long name) {

    }

    @Override
    public void updateEntry(Long id, String name) {
        addEntry(id, name);
    }
}
