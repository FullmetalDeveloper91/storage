package ru.fmd.storage.entities;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "equipment_storage")
public class EquipmentsOnStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID equipmentsOnStorage_id;

    @ManyToOne
    @JoinColumn(name="equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name="storage_id")
    private Storage storage;

    private int count;
}