package com.mordor.backend.player.service;

import com.mordor.backend.player.dto.response.PlayerRequiredData;
import com.mordor.backend.player.dto.mapper.PlayerMapper;
import com.mordor.backend.player.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
@Transactional
public class PlayerService {


    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerRequiredData> getRequiredData() {
        return playerMapper.requiredDataToResponse();
    }

}
