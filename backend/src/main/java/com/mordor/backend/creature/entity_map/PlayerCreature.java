package com.mordor.backend.creature.entity_map;

import com.mordor.backend.creature.Creature;
import com.mordor.backend.player.domain.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "player_creature", uniqueConstraints = @UniqueConstraint(columnNames = {"player_id", "creature_id"}))
public class PlayerCreature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "creature_id")
    private Creature creature;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        createdAt = LocalDateTime.now();
    }

}