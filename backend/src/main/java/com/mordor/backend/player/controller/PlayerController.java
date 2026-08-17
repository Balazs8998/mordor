package com.mordor.backend.player.controller;


import com.mordor.backend.player.dto.response.PlayerRequiredData;
import com.mordor.backend.player.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/required-data")
    public ResponseEntity<List<PlayerRequiredData>> getRequiredData() {
        return ResponseEntity.ok(playerService.getRequiredData());
    }
}
