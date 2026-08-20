package com.mordor.backend.creature.domain;

import com.mordor.backend.creature.domain.association.PlayerCreature;
import com.mordor.backend.creature.equipment.domain.Equipment;
import com.mordor.backend.horde.domain.Horde;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private Double strength;

    @Column(nullable = false)
    private Double agility;

    @Column(nullable = false)
    private Double intelligence;


    @Column(nullable = false)
    private Double health;
    @Column(nullable = false)
    private Double damage;
    @Column(nullable = false)
    private Double defense;

    @Column(nullable = false)
    private Double morale;

    @Column(nullable = false)
    private Double movementSpeed;

    @Column(nullable = false)
    private Double strengthLoad;

    @Column(nullable = false)
    private Double currentHealth;
    @Column
    private LocalDateTime lastAttackedAt;
    @Column
    private LocalDateTime lastRecoveryAt;



    @Column(nullable = false)
    private Integer foodUpkeep;

    @Column(nullable = false)
    private Integer capacityCost;



    @OneToOne(
            mappedBy = "creature",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "horde_id")
    private Horde horde;

   @OneToMany(mappedBy = "creature")
   private List<PlayerCreature> playerCreatures;


   @PrePersist
    public void initializeCurrentValues() {
       if(currentHealth == null) {
           currentHealth = health;
       }
       if(strengthLoad == null) {
           strengthLoad = 0.0;
       }
    }


    public abstract String getraceTypeValue();

   public abstract String getraceTypeDisplayName();

   public abstract String getRoleDisplayName();

   public abstract String getCreatureTypeDisplayName();

   public  Integer getWeaponCount(){
       return equipment.getWeapons().size();
   }

   public abstract String getImgUrl();


}
