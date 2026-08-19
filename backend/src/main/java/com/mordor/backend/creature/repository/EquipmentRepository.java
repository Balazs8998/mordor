package com.mordor.backend.creature.repository;

import com.mordor.backend.creature.equipment.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Equipment findByCreatureId(Long creatureId);
}
