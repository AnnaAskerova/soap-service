package com.example.service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_to_add")
public class ItemToAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private ItemModel item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemToAdd itemToAdd = (ItemToAdd) o;
        return id == itemToAdd.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemToAdd{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
