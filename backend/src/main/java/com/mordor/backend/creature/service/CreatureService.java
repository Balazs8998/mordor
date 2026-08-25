package com.mordor.backend.creature.service;


import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.dto.mapper.CreatureForgeRequiredDataMapper;
import com.mordor.backend.creature.dto.mapper.CreatureMapper;
import com.mordor.backend.creature.dto.mapper.EquipmentMapper;
import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import com.mordor.backend.creature.factory.FactoryRouter;
import com.mordor.backend.creature.repository.CreatureRepository;
import com.mordor.backend.creature.repository.EquipmentRepository;
import com.mordor.backend.game.equipment.ArmoryEquipmentHandsRules;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    private final ArmoryEquipmentHandsRules armoryEquipmentHandsRules;

    public CreatureService(CreatureRepository creatureRepository, EquipmentRepository equipmentRepository, CreatureMapper creatureMapper, EquipmentMapper equipmentMapper, CreatureForgeRequiredDataMapper creatureForgeRequiredDataMapper, FactoryRouter factoryRouter, ArmoryEquipmentHandsRules armoryEquipmentHandsRules) {
        this.creatureRepository = creatureRepository;
        this.equipmentRepository = equipmentRepository;
        this.creatureMapper = creatureMapper;
        this.equipmentMapper = equipmentMapper;
        this.creatureForgeRequiredDataMapper = creatureForgeRequiredDataMapper;
        this.factoryRouter = factoryRouter;
        this.armoryEquipmentHandsRules = armoryEquipmentHandsRules;
    }


    public CreatureForgeRequiredDataResponse getForgeRequestData() {
        return creatureForgeRequiredDataMapper.toResponse();
    }

    public void saveCreature(CreatureCreateRequest request) {
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

    public void saveCreatureEquipment(Long id, EquipmentItemRequest request) {
        Equipment equipment = equipmentRepository.findByCreatureId(id);
        Creature creature = creatureRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Creature not found with id: " + id));

        if (equipment == null) {
            throw new IllegalArgumentException("Equipment not found for creature with id: " + id);
        }
        armoryEquipmentHandsRules.validateWeaponEnums(request);
        armoryEquipmentHandsRules.validateEquipmentSlots(request);
        creature.setStrengthLoad(armoryEquipmentHandsRules.creatureHaveEnoughStrenght(creature, request));
        List<WeaponType> newWeapons = armoryEquipmentHandsRules.findNewWeapons(creature, request);
        armoryEquipmentHandsRules.applyWeaponEquipment(newWeapons,creature, request);

        // TODO: purchase newWeapons when treasury/player is implemented

        equipmentRepository.save(equipment);

    }

    public CreatureItemResponse getCreatureById(Long id) {
        Creature creature = creatureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Creature not found with id: " + id));

        return creatureMapper.getCreatureItemResponse(creature);
    }
}
