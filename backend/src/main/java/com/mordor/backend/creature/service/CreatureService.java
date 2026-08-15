package com.mordor.backend.creature.service;


import com.mordor.backend.creature.dto.mapper.CreatureForgeRequiredDataMapper;
import com.mordor.backend.creature.dto.mapper.CreatureMapper;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.repository.CreatureRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j

@Service
@Transactional
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final CreatureMapper creatureMapper;
    private final CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper;

    public CreatureService(CreatureRepository creatureRepository, CreatureMapper creatureMapper, CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper) {
        this.creatureRepository = creatureRepository;
        this.creatureMapper = creatureMapper;
        this.creatureForgeRequiredDataMapper = creatureForgeRequiredDataMapper;
    }


    public CreatureForgeRequiredDataResponse getForgeRequestData() {
        return creatureForgeRequiredDataMapper.toResponse();
    }
}
