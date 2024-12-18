package ru.fmd.storage.mapper;

import ru.fmd.storage.dto.StoragesContainsEquipmentDTO;
import ru.fmd.storage.entities.EquipmentsOnStorage;

public class EquipmentsOnStorageMapper {
    public static StoragesContainsEquipmentDTO MapToDTOStoragesWithEquip(EquipmentsOnStorage equipmentsOnStorage){
        return new StoragesContainsEquipmentDTO(
            StorageMapper.MapToDTO(equipmentsOnStorage.getStorage()),
            equipmentsOnStorage.getCount()
        );
    }
}
