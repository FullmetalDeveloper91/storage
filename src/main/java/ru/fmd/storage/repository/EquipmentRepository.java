package ru.fmd.storage.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import ru.fmd.storage.entities.Equipment;

//Объявляем интерфейс репозитория для работы с оборудованием и Spring сам создаст реализацию
// со всеми основнми операциями выборки, выборки по id, вставке, удалению и апдейту
public interface EquipmentRepository extends JpaRepository<Equipment, UUID>{

    //если стандартных круд операций не хватает, объявляю абстрактный метод. Spring посмотрит на сигнатуру функции
    //и по ней сам напишет функцию. Тут вернётся список оборудования по заданой категории.
    public List<Equipment> findByCategory_categoryID(UUID category_id);

    //А тут то же самое, но Spring применет нативный запрос, описанный в аннотации.
    // Тут я верну список оборудования, хранящегося в конкретном хранилище. Без количества пока
    @NativeQuery("SELECT e.* FROM equipment_storage es JOIN equipment e ON e.equipment_id = es.equipment_id WHERE es.storage_id = ?1")
    public List<Equipment> findByStorageID(UUID storage_id);
}