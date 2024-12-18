package ru.fmd.storage.dto;

import java.util.List;
import java.util.UUID;

public record EquipmentWithContainsInfoDTO(UUID id,
                                           String name,
                                           String category,
                                           List<StoragesContainsEquipmentDTO> containsOn){
}