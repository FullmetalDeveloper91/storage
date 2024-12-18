package ru.fmd.storage.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.*;
import ru.fmd.storage.dto.EquipmentWithContainsInfoDTO;
import ru.fmd.storage.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID>, JpaSpecificationExecutor<Equipment> {

}