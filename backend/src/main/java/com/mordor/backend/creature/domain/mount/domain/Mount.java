package com.mordor.backend.creature.domain.mount.domain;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.domain.mount.enums.MountRaceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Mount extends Creature {


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MountRaceType raceType;

    @Override
    public String getraceTypeValue() {
        return raceType.name();
    }

    @Override
    public String getraceTypeDisplayName() {
        return raceType.getDisplayName();
    }

    @Override
    public String getRoleDisplayName() {
        return raceType.getRoleDisplayName();
    }

    @Override
    public String getCreatureTypeDisplayName() {
        return raceType.getCreatureTypeDisplayName();
    }

    @Override
    public String getImgUrl() {
        return raceType.getImgUrl();
    }

}
