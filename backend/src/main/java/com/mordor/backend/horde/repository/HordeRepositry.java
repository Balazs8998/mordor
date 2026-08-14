package com.mordor.backend.horde.repository;

import com.mordor.backend.horde.domain.Horde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HordeRepositry extends JpaRepository<Horde, Long> {

}
