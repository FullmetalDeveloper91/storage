package ru.fmd.storage.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
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
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "storage_id")
    private UUID storageID;

    private String name;

    @OneToMany(mappedBy = "storage")
    @ToString.Exclude
    List<EquipmentsOnStorage> equipmentsOnStorage;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Storage storage = (Storage) o;
        return getStorageID() != null && Objects.equals(getStorageID(), storage.getStorageID());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
