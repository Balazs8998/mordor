package com.mordor.backend.orc.domain;


import com.mordor.backend.horde.domain.Horde;
import com.mordor.backend.orc.domain.enums.RaceType;
import com.mordor.backend.orc.domain.enums.WeaponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Orc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RaceType raceType;

// number of victims

    @Column(nullable = false)
    private Integer kills;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<WeaponType> weaponTypes;

    @ManyToOne
    @JoinColumn(name = "horde_id")
    private Horde horde;


    @PrePersist
    public void prePersist() {
        if (kills == null) {
            kills = 0;
        }
    }
}
