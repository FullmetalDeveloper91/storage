package ru.fmd.storage.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

//Lombok annotations
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

//JPA annotations
@Entity
@Table(name = "equipment_storage")
public class EquipmentsOnStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID equipmentsOnStorage_id;

    @ManyToOne
    @JoinColumn(name="equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name="storage_id")
    private Storage storage;

    private int count;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        EquipmentsOnStorage that = (EquipmentsOnStorage) o;
        return getEquipmentsOnStorage_id() != null && Objects.equals(getEquipmentsOnStorage_id(), that.getEquipmentsOnStorage_id());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}