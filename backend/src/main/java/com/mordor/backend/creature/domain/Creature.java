package com.mordor.backend.creature.domain;

import com.mordor.backend.creature.domain.association.PlayerCreature;
import com.mordor.backend.equipment.weapon.Weapon;
import com.mordor.backend.horde.domain.Horde;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer strength;


    @Column(nullable = false)
    private Double health;
    @Column(nullable = false)
    private Double damage;
    @Column(nullable = false)
    private Double defense;

    @Column(nullable = false)
    private Double currentHealth;
    @Column
    private LocalDateTime lastAttackedAt;
    @Column
    private LocalDateTime lastRecoveryAt;

    @ManyToMany
    @JoinTable(
            name = "creature_weapon",
            joinColumns = @JoinColumn(name = "creature_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    private Set<Weapon> weapons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "horde_id")
    private Horde horde;

   @OneToMany(mappedBy = "creature")
   private List<PlayerCreature> playerCreatures;




}
