package com.mordor.backend.creature.equipment.domain;

import com.mordor.backend.creature.domain.Creature;
import com.mordor.backend.creature.equipment.enums.EquipmentSlots;
import com.mordor.backend.creature.equipment.enums.WeaponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne
    @JoinColumn(
            name = "creature_id",
            nullable = false,
            unique = true
    )
    private Creature creature;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<WeaponType> weapons = new ArrayList<>();

    public abstract void equip (EquipmentSlots slot,  WeaponType weaponType);
    public abstract void unequip (EquipmentSlots slot);


}
