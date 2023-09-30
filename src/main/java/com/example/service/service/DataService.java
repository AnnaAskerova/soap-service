package com.example.service.service;

public interface DataService {

    void addEntry(Long key, String value);


    void removeEntry(Long key);


    void updateEntry(Long key, String value);
}
