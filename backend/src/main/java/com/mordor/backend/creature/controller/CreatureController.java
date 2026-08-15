package com.mordor.backend.creature.controller;

import com.mordor.backend.creature.dto.response.CreatureForgeRequiredDataResponse;
import com.mordor.backend.creature.service.CreatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creature")
public class CreatureController {

    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/forge-required-data")
    public ResponseEntity<CreatureForgeRequiredDataResponse> getForgeRequestData(){

        CreatureForgeRequiredDataResponse creatureForgeRequiredDataResponse =
                creatureService.getForgeRequestData();

        return ResponseEntity.ok(creatureForgeRequiredDataResponse);
    }

}
