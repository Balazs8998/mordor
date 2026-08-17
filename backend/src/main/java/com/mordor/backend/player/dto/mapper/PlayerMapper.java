package com.mordor.backend.player.dto.mapper;

import com.mordor.backend.player.dto.response.PlayerRequiredData;
import com.mordor.backend.player.enums.PlayerLevelType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class PlayerMapper {

    public List<PlayerRequiredData> requiredDataToResponse(){

        return Stream.of(PlayerLevelType.values())
                .map(playerLevelType -> new PlayerRequiredData(
                        playerLevelType.name(),
                        playerLevelType.getLevelUpExperience(),
                        playerLevelType.getMaxCreatureCapacity(),
                        playerLevelType.getMaxWarbandCapacity(),
                        playerLevelType.getMaxHordeCapacity(),
                        playerLevelType.getMaxWarbandCount(),
                        playerLevelType.getMaxHordeCount()
                )).toList();
    }


}
