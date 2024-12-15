package ru.fmd.storage.entities;

import java.util.List;
import java.util.UUID;

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
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID storage_id;

    private String name;

    @OneToMany(mappedBy = "storage")
    List<EquipmentsOnStorage> equipmentsOnStorage;
}
