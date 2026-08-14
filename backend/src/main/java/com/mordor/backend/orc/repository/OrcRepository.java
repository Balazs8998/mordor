package com.mordor.backend.orc.repository;


import com.mordor.backend.orc.domain.Orc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcRepository extends JpaRepository<Orc, Long> {
}
