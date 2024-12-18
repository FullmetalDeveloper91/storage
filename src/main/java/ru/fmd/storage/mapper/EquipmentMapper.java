package ru.fmd.storage.mapper;

import ru.fmd.storage.dto.EquipmentDTO;
import ru.fmd.storage.dto.EquipmentWithContainsInfoDTO;
import ru.fmd.storage.entities.Category;
import ru.fmd.storage.entities.Equipment;

public class EquipmentMapper {
    public static EquipmentDTO MapToDTO(Equipment equipment){
        return new EquipmentDTO(
            equipment.getEquipment_id(),
            equipment.getName(),
            equipment.getCategory().getName()
        );
    }

    public static EquipmentWithContainsInfoDTO MapToDTOWithContainsInfo(Equipment equipment){
        return new EquipmentWithContainsInfoDTO(
            equipment.getEquipment_id(),
            equipment.getName(),
            equipment.getCategory().getName(),
            equipment.getEquipmentsOnStorage()
                    .stream()
                    .map(EquipmentsOnStorageMapper::MapToDTOStoragesWithEquip)
                    .toList()
        );
    }

    public static Equipment MapToEntity(
            EquipmentDTO equipmentDTO,
            Category category
        ){
        Equipment result = new Equipment();

        result.setEquipment_id(equipmentDTO.id());
        result.setName(equipmentDTO.name());
        result.setCategory(category);

        return result;
    }
}
