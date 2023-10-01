package com.example.service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_to_delete")
public class ItemToDelete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long itemId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemToDelete that = (ItemToDelete) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
