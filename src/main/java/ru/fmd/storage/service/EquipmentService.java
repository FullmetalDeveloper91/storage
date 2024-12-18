package ru.fmd.storage.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.fmd.storage.dto.EquipmentDTO;
import ru.fmd.storage.dto.EquipmentWithContainsInfoDTO;
import ru.fmd.storage.mapper.EquipmentMapper;
import ru.fmd.storage.repository.EquipmentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentService {
    private final EquipmentRepository repo;

    public EquipmentService(EquipmentRepository repo) {
        this.repo = repo;
    }

    public List<EquipmentDTO> findAllPaginated(@Nullable UUID category_id, int page, int size){
        return repo.findAll(
            ((root, query, criteriaBuilder) -> category_id == null
                ?null
                :criteriaBuilder.equal(root.get("category").get("categoryID"), category_id)),
            PageRequest.of(page, size))
                .stream().map(EquipmentMapper::MapToDTO).toList();
    }

    @EntityGraph(value = "equipment")
    public List<EquipmentWithContainsInfoDTO> getAllEquipmentWithContainsInfo(){
        return repo.findAll().stream().map(EquipmentMapper::MapToDTOWithContainsInfo).toList();
    }
}