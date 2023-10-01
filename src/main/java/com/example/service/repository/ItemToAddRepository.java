package com.example.service.repository;

import com.example.service.model.ItemToAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemToAddRepository extends JpaRepository<ItemToAdd, Long> {
    Optional<ItemToAdd> findByItemId(long id);
}
