package ru.fmd.storage.mapper;

import ru.fmd.storage.dto.EquipmentDTO;
import ru.fmd.storage.entities.Category;
import ru.fmd.storage.entities.Equipment;

public class EquipmentMapper {
    public static EquipmentDTO MapToDTO(Equipment equipment){
        EquipmentDTO result = new EquipmentDTO();
        result.setId(equipment.getEquipment_id());
        result.setName(equipment.getName());
        result.setCategory(equipment.getCategory().getName());

        return result;
    }

    public static Equipment MapToEntity(
            EquipmentDTO equipmentDTO, 
            Category category
        ){
        Equipment result = new Equipment();

        result.setEquipment_id(equipmentDTO.getId());
        result.setName(equipmentDTO.getName());
        result.setCategory(category);

        return result;
    }
}
