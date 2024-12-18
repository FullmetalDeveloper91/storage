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
import ru.fmd.storage.dto.EquipmentWithContainsInfoDTO;
import ru.fmd.storage.entities.Equipment;
import ru.fmd.storage.mapper.EquipmentMapper;
import ru.fmd.storage.repository.EquipmentRepository;
import ru.fmd.storage.service.EquipmentService;


@RestController
@RequestMapping("api/v1/equipments")
public class EquipmentController {

    private final EquipmentRepository repo;
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentRepository repo, EquipmentService equipmentService) {
        this.repo = repo;
        this.equipmentService = equipmentService;
    }



//    @GetMapping
//    public List<EquipmentDTO> getAllEquipments(
//            @RequestParam Optional<UUID> storage,
//            @RequestParam Optional<UUID> category
//        ) {
//        List<EquipmentDTO> result = new ArrayList<EquipmentDTO>();
//        List<Equipment> dbResult;
//
//        //dbResult = repo.findByCategory_categoryID(category.orElse(null));
//        //dbResult=repo.findByStorageID(storage.orElse(null));
//
//        dbResult = repo.findByEquipmentsOnStorage_Storage_StorageID(storage.orElse(null));
//
//        dbResult.forEach(equip ->
//            result.add(EquipmentMapper.MapToDTO(equip))
//        );
//
//        return result;
//    }

    @GetMapping
    public List<EquipmentWithContainsInfoDTO> getByFilterPaginated(
            //@RequestParam(required = false) UUID category,
            //@RequestParam int page,
            //@RequestParam int size
    ){
        //return equipmentService.findAllPaginated(category, page,size);
        return equipmentService.getAllEquipmentWithContainsInfo();
    }



    @GetMapping("/{id}")
    public EquipmentDTO getMethodName(@PathVariable UUID id) {
        Optional<Equipment> equipFromDB = repo.findById(id);
        return equipFromDB.map(EquipmentMapper::MapToDTO).orElse(null);
    }
}