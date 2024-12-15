package ru.fmd.storage.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.fmd.storage.dto.EquipmentDTO;
import ru.fmd.storage.entities.Equipment;
import ru.fmd.storage.mapper.EquipmentMapper;
import ru.fmd.storage.repository.EquipmentRepository;


@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentRepository repo;

    public EquipmentController(EquipmentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipments(
            @RequestParam Optional<UUID> storage, 
            @RequestParam(required = false) Optional<UUID> category
        ) {           
        List<EquipmentDTO> result = new ArrayList<EquipmentDTO>();
        List<Equipment> dbResult;

        //dbResult = repo.findByCategory_categoryID(category.orElse(null));
        dbResult=repo.findByStorageID(storage.orElse(null));

        dbResult.forEach(equip -> 
            result.add(EquipmentMapper.MapToDTO(equip))
        );
        
        return result;
    }

    @GetMapping("/{id}")
    public EquipmentDTO getMethodName(@PathVariable UUID id) {
        Optional<Equipment> equipFromDB = repo.findById(id);
        if(equipFromDB.isPresent())
            return EquipmentMapper.MapToDTO(equipFromDB.get());
        return null;
    }    
}