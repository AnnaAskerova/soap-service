package com.example.service.util;

import com.example.service.model.ItemModel;
import com.example.service.model.ItemToAdd;
import com.example.service.service.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemToAdd mapItemModelToItemToAdd(ItemModel itemModel) {
        ItemToAdd toAdd = new ItemToAdd();
        toAdd.setItem(itemModel);
        return toAdd;
    }

    public Item mapItemModelToItem(ItemModel itemModel) {
        Item item = new Item();
        item.setId(itemModel.getId());
        item.setName(itemModel.getName());
        return item;
    }
}
