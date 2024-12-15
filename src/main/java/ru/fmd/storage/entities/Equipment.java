package ru.fmd.storage.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID equipment_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentsOnStorage> equipmentsOnStorage;
}