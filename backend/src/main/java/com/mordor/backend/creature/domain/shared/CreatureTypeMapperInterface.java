package com.mordor.backend.creature.domain.shared;


public interface CreatureTypeMapperInterface extends CreatureRaceDefinition {

    String getTypeValue();

    String getTypeDisplayName();

    String getRoleValue();

    String getRoleDisplayName();

    String getImgUrl();

    Integer getRecruitmentGoldCost();

    Integer getRecruitmentMordorSteelCost();

    String getCreatureTypeValue();

    String getCreatureTypeDisplayName();

    String getMovementTypeValue();

    String getMovementTypeDisplayName();
}
