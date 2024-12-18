package ru.fmd.storage.mapper;

import ru.fmd.storage.dto.StorageDTO;
import ru.fmd.storage.entities.Storage;

public class StorageMapper {
    public static StorageDTO MapToDTO(Storage storage){
        return new StorageDTO(
                storage.getStorageID(),
                storage.getName()
        );
    }

    public static Storage MapToEntity(StorageDTO dto){
        var storage = new Storage();
        storage.setStorageID(dto.storageID());
        storage.setName(dto.name());
        return storage;
    }
}
