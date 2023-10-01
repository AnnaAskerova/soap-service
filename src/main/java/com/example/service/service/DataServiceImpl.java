package com.example.service.service;

import com.example.service.model.ItemModel;
import com.example.service.model.ItemToAdd;
import com.example.service.model.ItemToDelete;
import com.example.service.repository.ItemRepository;
import com.example.service.repository.ItemToAddRepository;
import com.example.service.repository.ItemToDeleteRepository;
import com.example.service.util.ItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;


@Service
public class DataServiceImpl implements DataService {
    private final ItemRepository itemRepository;
    private final ItemToDeleteRepository toDeleteRepository;
    private final ItemToAddRepository toAddRepository;
    private final ItemMapper mapper;

    public DataServiceImpl(ItemRepository itemRepository, ItemToDeleteRepository toDeleteRepository,
                           ItemToAddRepository toAddRepository, ItemMapper mapper) {
        this.itemRepository = itemRepository;
        this.toDeleteRepository = toDeleteRepository;
        this.toAddRepository = toAddRepository;
        this.mapper = mapper;
    }

    //метод имитирует какие-то изменения, происходящие в бд сервиса
    @PostConstruct
    public void emulate() {
        addItem(new ItemModel("aaa"));
        addItem(new ItemModel("lll"));
        addItem(new ItemModel("ccc"));
        updateItem(new ItemModel(1, "kii"));
        updateItem(new ItemModel(1, "ффф"));
        removeItem(2L);
    }

    @Override
    public void addItem(ItemModel itemModel) {
        itemRepository.save(itemModel);
        toAddRepository.save(mapper.mapItemModelToItemToAdd(itemModel));
    }

    @Override
    public void removeItem(Long id) {
        if (itemRepository.existsById(id)) {
            Optional<ItemToAdd> itemToAdd = toAddRepository.findByItemId(id);
            itemToAdd.ifPresent(toAdd -> toAddRepository.deleteById(toAdd.getId()));
            itemRepository.deleteById(id);
            ItemToDelete toDelete = new ItemToDelete();
            toDelete.setItemId(id);
            toDeleteRepository.save(toDelete);
        }
    }

    @Override
    public void updateItem(ItemModel itemModel) {
        itemRepository.save(itemModel);
    }
}
