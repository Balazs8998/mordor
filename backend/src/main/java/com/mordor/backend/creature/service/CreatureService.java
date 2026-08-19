package com.mordor.backend.creature.service;


import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.mapper.CreatureForgeRequiredDataMapper;
import com.mordor.backend.creature.dto.mapper.CreatureMapper;
import com.mordor.backend.creature.dto.mapper.EquipmentMapper;
import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
import com.mordor.backend.creature.dto.response.EquipmentItemResponse;
import com.mordor.backend.creature.enums.CreatureType;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.factory.FactoryRouter;
import com.mordor.backend.creature.repository.CreatureRepository;
import com.mordor.backend.creature.repository.EquipmentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Service
@Transactional
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final EquipmentRepository equipmentRepository;
    private final CreatureMapper creatureMapper;
    private final EquipmentMapper equipmentMapper;
    private final CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper;
    private final FactoryRouter factoryRouter;

    public CreatureService(CreatureRepository creatureRepository, EquipmentRepository equipmentRepository, CreatureMapper creatureMapper, EquipmentMapper equipmentMapper, CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper, FactoryRouter factoryRouter) {
        this.creatureRepository = creatureRepository;
        this.equipmentRepository = equipmentRepository;
        this.creatureMapper = creatureMapper;
        this.equipmentMapper = equipmentMapper;
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

    public List<CreatureItemResponse> getAllCreatures() {
        List<Creature> creatures = creatureRepository.findAll();

        return creatures.stream()
                .map(creatureMapper::getCreatureItemResponse)
                .toList();
    }

    public EquipmentItemResponse getCreatureEquipment(Long id) {
        Equipment equipment = equipmentRepository.findByCreatureId(id);

        if (equipment == null) {
            throw new IllegalArgumentException("Equipment not found for creature with id: " + id);
        }
        return equipmentMapper.equipmentToEquipmentItemResponse(equipment);
    }

    public void saveCreatureEquipment(Long id, EquipmentItemRequest request) {
        Equipment equipment = equipmentRepository.findByCreatureId(id);

        if (equipment == null) {
            throw new IllegalArgumentException("Equipment not found for creature with id: " + id);
        }

        equipment.clearEquippedWeapons();
        equipment.getWeapons().clear();

        equipmentMapper.updateEquipmentFromRequest(request, equipment);
        equipmentRepository.save(equipment);
    }
}
