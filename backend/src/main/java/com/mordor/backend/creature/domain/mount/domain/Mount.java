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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MountRaceType raceType;


}
