package com.mordor.backend.horde.domain;


import com.mordor.backend.horde.domain.entity_map.PlayerHorde;
import com.mordor.backend.orc.domain.Orc;
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
public class Horde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "horde")
    private List<Orc> orcs;

    @OneToMany(mappedBy = "horde")
    private List<PlayerHorde> playerHordes;
}
