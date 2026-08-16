package com.mordor.backend.creature.service;


import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.mapper.CreatureForgeRequiredDataMapper;
import com.mordor.backend.creature.dto.mapper.CreatureMapper;
import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.enums.CreatureType;
import com.mordor.backend.creature.factory.FactoryRouter;
import com.mordor.backend.creature.repository.CreatureRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j

@Service
@Transactional
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final CreatureMapper creatureMapper;
    private final CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper;
    private final FactoryRouter factoryRouter;

    public CreatureService(CreatureRepository creatureRepository, CreatureMapper creatureMapper, CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper, FactoryRouter factoryRouter) {
        this.creatureRepository = creatureRepository;
        this.creatureMapper = creatureMapper;
        this.creatureForgeRequiredDataMapper = creatureForgeRequiredDataMapper;
        this.factoryRouter = factoryRouter;
    }


    public CreatureForgeRequiredDataResponse getForgeRequestData() {
        return creatureForgeRequiredDataMapper.toResponse();
    }

    public void saveCreature( CreatureCreateRequest request) {
       Creature creature = factoryRouter.route(request);
       log.info("Saving creature: {}", creature);

        creatureRepository.save(creature);

    }
}
