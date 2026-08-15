package com.mordor.backend.creature.repository;

import com.mordor.backend.creature.domain.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
