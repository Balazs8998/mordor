package com.mordor.backend.creature.controller;

import com.mordor.backend.creature.dto.request.CreatureCreateRequest;
import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.dto.response.CreatureItemResponse;
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

    @PostMapping("/forge")
    public ResponseEntity<Void> forgeCreature(@RequestBody @Valid CreatureCreateRequest request){
        log.info("Received request to forge creature: {}", request);

        creatureService.saveCreature(request);

        return ResponseEntity.ok().build();
    }



}
