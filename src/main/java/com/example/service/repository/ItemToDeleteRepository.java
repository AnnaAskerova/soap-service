package com.example.service.repository;

import com.example.service.model.ItemToDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemToDeleteRepository extends JpaRepository<ItemToDelete, Long> {
}
