package ru.fmd.storage.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public record EquipmentDTO (UUID id,
                            String name,
                            String category){
}