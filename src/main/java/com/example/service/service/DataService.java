package com.example.service.service;

import com.example.service.model.ItemModel;

public interface DataService {
    void addItem(ItemModel itemModel);

    void removeItem(Long id);

    void updateItem(ItemModel itemModel);
}
