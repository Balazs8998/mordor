package com.mordor.backend.equipment.weapon;

import com.mordor.backend.creature.Creature;
import com.mordor.backend.equipment.enums.WeaponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double damage;
    @Column(nullable = false)
    private Integer requiredStrength;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeaponType weaponType;

    @ManyToMany(mappedBy = "weapons")
    private Set<Creature> users = new HashSet<>();


}
