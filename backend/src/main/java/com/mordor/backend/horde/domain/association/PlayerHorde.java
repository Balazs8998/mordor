package com.mordor.backend.horde.domain.association;


import com.mordor.backend.horde.domain.Horde;
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
@Table(name = "player_horde", uniqueConstraints = @UniqueConstraint(columnNames = {"player_id", "horde_id"}))
public class PlayerHorde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "horde_id")
    private Horde horde;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        createdAt = LocalDateTime.now();
    }

}
