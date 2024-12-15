package ru.fmd.storage.entities;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor

//JPA annotations
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID categoryID;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Equipment> equipments;   
}
