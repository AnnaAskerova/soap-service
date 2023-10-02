package com.example.service.service;

import com.example.service.model.ItemToAdd;
import com.example.service.model.ItemToDelete;
import com.example.service.repository.ItemToAddRepository;
import com.example.service.repository.ItemToDeleteRepository;
import com.example.service.util.ItemMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.stream.Collectors;

@WebService(endpointInterface = "com.example.service.service.UpdateService")
public class UpdateServiceImpl implements UpdateService {
    private final ItemToDeleteRepository toDeleteRepository;
    private final ItemToAddRepository toAddRepository;
    private final ItemMapper mapper;

    public UpdateServiceImpl(ItemToDeleteRepository toDeleteRepository,
                             ItemToAddRepository toAddRepository, ItemMapper mapper) {
        this.toDeleteRepository = toDeleteRepository;
        this.toAddRepository = toAddRepository;
        this.mapper = mapper;
    }

    @Override
    @WebMethod
    @Transactional
    public GetPatchResponse getPatch() {
        GetPatchResponse patch = new GetPatchResponse();
        patch.setToDelete(toDeleteRepository.findAll().stream()
                .map(ItemToDelete::getItemId)
                .collect(Collectors.toList()));
        toDeleteRepository.deleteAll();
        patch.setToAdd(toAddRepository.findAll().stream()
                .map(ItemToAdd::getItem)
                .map(mapper::mapItemModelToItem)
                .collect(Collectors.toList()));
        toAddRepository.deleteAll();
        return patch;
    }
}
