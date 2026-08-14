package com.mordor.backend.horde.controller;


import com.mordor.backend.horde.dto.request.HordeCreateRequest;
import com.mordor.backend.horde.service.HordeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/horde")
public class HordeController {

    private final HordeService hordeService;

    public HordeController(HordeService hordeService) {
        this.hordeService = hordeService;
    }


    @PostMapping
    public ResponseEntity<Void> createHorde(@RequestBody @Valid HordeCreateRequest request) {
        hordeService.createHorde(request);
        return ResponseEntity.ok().build();
    }
}
