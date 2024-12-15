package ru.fmd.storage.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private UUID id;
    private String name;
    private String category;
}
