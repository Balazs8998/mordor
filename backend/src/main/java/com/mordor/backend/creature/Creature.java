package com.mordor.backend.creature;

import com.mordor.backend.creature.entity_map.PlayerCreature;
import com.mordor.backend.equipment.weapon.Weapon;
import com.mordor.backend.horde.domain.Horde;
import com.mordor.backend.player.domain.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer health;
    @Column(nullable = false)
    private Integer damage;
    @Column(nullable = false)
    private Integer defense;

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
