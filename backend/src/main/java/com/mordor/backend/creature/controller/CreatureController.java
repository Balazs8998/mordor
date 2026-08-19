package com.mordor.backend.creature.controller;

import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.dto.request.EquipmentItemRequest;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
import com.mordor.backend.creature.dto.response.EquipmentItemResponse;
import com.mordor.backend.creature.service.CreatureService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

@RestController
@RequestMapping("/creature")
public class CreatureController {

    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/forge-required-data")
    public ResponseEntity<CreatureForgeRequiredDataResponse> getForgeRequestData(){
        log.info("Received request to get forge required data");

        CreatureForgeRequiredDataResponse creatureForgeRequiredDataResponse =
                creatureService.getForgeRequestData();

        return ResponseEntity.ok(creatureForgeRequiredDataResponse);
    }

    @GetMapping
    public ResponseEntity<List<CreatureItemResponse>> getAllCreatures(){
        log.info("Received request to get all creatures");

        return ResponseEntity.ok(creatureService.getAllCreatures());
    }

    @GetMapping("{id}")
    public ResponseEntity<CreatureItemResponse> getCreatureById(@PathVariable Long id){
        log.info("Received request to get creature with id: {}", id);

        return ResponseEntity.ok(creatureService.getCreatureById(id));
    }

//    @GetMapping("/{id}/equipment")
//    public ResponseEntity<EquipmentItemResponse> getCreatureEquipment(@PathVariable Long id){
//        log.info("Received request to get equipment for creature with id: {}", id);
//
//        return ResponseEntity.ok(creatureService.getCreatureEquipment(id));
//    }

    @PostMapping("/forge")
    public ResponseEntity<Void> forgeCreature(@RequestBody @Valid CreatureCreateRequest request){
        log.info("Received request to forge creature: {}", request);

        creatureService.saveCreature(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/equipment")
    public ResponseEntity<EquipmentItemRequest> addEquipmentToCreature(@PathVariable Long id, @RequestBody @Valid EquipmentItemRequest request){
        log.info("Received request to add equipment to creature with id: {}", id);

        creatureService.saveCreatureEquipment(id, request);

        return ResponseEntity.ok(request);
    }



}
