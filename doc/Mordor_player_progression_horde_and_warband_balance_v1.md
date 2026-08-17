# Mordor Player Progression, Horde & Warband Balance – V1

## Purpose

This document records the first stable version of the player-level progression, roster capacity, Warband capacity, Horde capacity, and creature capacity model.

The goal of V1 is to separate three different limits:

1. **Player roster capacity** – how much total creature capacity the player may own.
2. **Warband capacity** – how much combat power can be organized into one Warband.
3. **Horde capacity** – how much combat power can be organized into one Horde.

This separation allows the player to own reserve creatures without forcing every creature into an active Warband or Horde.

---

## 1. Player Level Progression

| Player Level | Max Creature Capacity | Max Warband Capacity | Max Warbands | Max Horde Capacity | Max Hordes |
|---:|---:|---:|---:|---:|---:|
| 1 | 150 | 20 | 5 | 80 | 1 |
| 2 | 220 | 24 | 6 | 96 | 1 |
| 3 | 380 | 28 | 9 | 112 | 2 |
| 4 | 530 | 32 | 11 | 128 | 2 |
| 5 | 760 | 36 | 14 | 144 | 3 |
| 6 | 1080 | 40 | 18 | 160 | 4 |

### Progression Rules

Warband capacity increases by a fixed amount:

```text
+4 capacity per Player Level
```

Horde capacity is based on four full Warbands:

```text
Horde Capacity = Warband Capacity × 4
```

Examples:

```text
Level 1:
20 × 4 = 80 Horde Capacity
```

```text
Level 6:
40 × 4 = 160 Horde Capacity
```

---

## 2. Total Deployable Warband Capacity

The maximum amount of capacity that can be assigned across all available Warbands is:

```text
Max Warbands × Max Warband Capacity
```

| Player Level | Max Warbands | Warband Capacity | Total Warband Capacity | Player Roster Capacity | Reserve Capacity |
|---:|---:|---:|---:|---:|---:|
| 1 | 5 | 20 | 100 | 150 | 50 |
| 2 | 6 | 24 | 144 | 220 | 76 |
| 3 | 9 | 28 | 252 | 380 | 128 |
| 4 | 11 | 32 | 352 | 530 | 178 |
| 5 | 14 | 36 | 504 | 760 | 256 |
| 6 | 18 | 40 | 720 | 1080 | 360 |

The player roster is intentionally larger than the currently deployable Warband capacity.

This allows room for:

- reserve creatures;
- injured creatures;
- alternative equipment builds;
- units waiting for assignment;
- future army reorganization.

The current V1 ratio keeps the player roster at roughly 150% of the maximum active Warband capacity.

---

## 3. Optimized Creature Capacity Costs

The original 1–2 capacity model did not provide enough distinction between low-tier and elite units.

V1 therefore uses the following optimized values:

| Creature | Capacity Cost |
|---|---:|
| Snaga | 1 |
| Uruk | 2 |
| Mountain Orc | 3 |
| Uruk-Hai | 4 |
| Warg | 2 |
| War Warg | 3 |
| Giant Bat | 2 |
| Giant War Bat | 3 |
| Flying War Cerberus | 6 |
| Cave Troll | 4 |
| Mountain Troll | 6 |
| Olog-Hai | 9 |

These values are based on:

- base HP;
- base Damage;
- base Defense;
- movement speed;
- equipment flexibility;
- expected ranged or mobility advantage;
- action economy;
- existing recruitment and upkeep costs.

---

## 4. Capacity Design by Creature Family

### Orcs

```text
Snaga         = 1
Uruk          = 2
Mountain Orc  = 3
Uruk-Hai      = 4
```

The progression is intentionally compact.

Orcs gain strength through equipment flexibility, so capacity should not scale as aggressively as raw stat values.

### Trolls

```text
Cave Troll      = 4
Mountain Troll  = 6
Olog-Hai        = 9
```

Trolls occupy significantly more army capacity because they provide:

- high natural HP;
- strong base damage;
- heavy equipment access;
- strong frontline durability.

Their slower movement and high food upkeep prevent capacity from becoming their only balancing factor.

### Mounts

```text
Warg      = 2
War Warg  = 3
```

Mount capacity is added directly to the rider's capacity.

Example:

```text
Uruk-Hai = 4
War Warg = 3

Mounted Uruk-Hai = 7 Capacity
```

The mounted unit therefore gains mobility and combat flexibility at a meaningful roster cost.

### Flying Creatures

```text
Giant Bat             = 2
Giant War Bat         = 3
Flying War Cerberus   = 6
```

Flying creatures gain tactical value from mobility and engagement control.

Their capacity therefore reflects more than raw HP and Damage.

---

## 5. Warband Composition Examples

### Level 1 Warband

Maximum capacity:

```text
20
```

Possible homogeneous compositions:

| Creature | Capacity Cost | Maximum Count |
|---|---:|---:|
| Snaga | 1 | 20 |
| Uruk | 2 | 10 |
| Mountain Orc | 3 | 6 |
| Uruk-Hai | 4 | 5 |
| Cave Troll | 4 | 5 |
| Mountain Troll | 6 | 3 |
| Olog-Hai | 9 | 2 |

These are maximum theoretical values.

Real Warbands are expected to use mixed compositions.

---

## 6. Level 6 Warband Composition

Maximum capacity:

```text
40
```

Possible homogeneous compositions:

| Creature | Capacity Cost | Maximum Count |
|---|---:|---:|
| Snaga | 1 | 40 |
| Uruk | 2 | 20 |
| Mountain Orc | 3 | 13 |
| Uruk-Hai | 4 | 10 |
| Cave Troll | 4 | 10 |
| Mountain Troll | 6 | 6 |
| Olog-Hai | 9 | 4 |

The increased Warband capacity allows higher-level players to field more elite compositions without removing the strategic value of lower-tier units.

---

## 7. Horde Structure

A Horde is composed of up to four full Warbands.

```text
1 Horde = maximum 4 Warbands
```

Therefore:

| Player Level | Warband Capacity | Horde Capacity |
|---:|---:|---:|
| 1 | 20 | 80 |
| 2 | 24 | 96 |
| 3 | 28 | 112 |
| 4 | 32 | 128 |
| 5 | 36 | 144 |
| 6 | 40 | 160 |

The Horde does not replace Warbands.

Warbands remain the primary tactical grouping, while the Horde represents a larger organized army.

---

## 8. Maximum Horde Count

| Player Level | Max Hordes |
|---:|---:|
| 1 | 1 |
| 2 | 1 |
| 3 | 2 |
| 4 | 2 |
| 5 | 3 |
| 6 | 4 |

Major Horde-slot progression occurs at:

```text
Level 3
Level 5
Level 6
```

This provides larger strategic milestones beyond simple capacity increases.

---

## 9. Independent Warbands

The player may own more Warbands than can be placed into Hordes.

This is intentional.

Example at Level 6:

```text
Max Warbands = 18
Max Hordes = 4
Max Warbands inside Hordes = 16
```

Two Warbands may therefore remain independent.

This supports:

- scouting forces;
- reserve groups;
- specialized tactical units;
- detached raiding parties;
- future map objectives.

---

## 10. Player Roster Capacity

Player roster capacity represents the total amount of creature capacity the player may own.

It is separate from active army organization.

Example at Level 1:

```text
Player Roster Capacity = 150
Maximum active Warband Capacity = 100
```

The player may therefore own 150 capacity worth of creatures while only 100 capacity can be organized into active Warbands at the same time.

This avoids forcing immediate dismissal of creatures when army structure changes.

---

## 11. Maximum Theoretical Creature Counts by Player Level

The following table assumes the player's entire roster contains only one creature type.

| Level | Roster Capacity | Snaga (1) | Uruk (2) | Mountain Orc (3) | Uruk-Hai (4) | Mountain Troll (6) | Olog-Hai (9) |
|---:|---:|---:|---:|---:|---:|---:|---:|
| 1 | 150 | 150 | 75 | 50 | 37 | 25 | 16 |
| 2 | 220 | 220 | 110 | 73 | 55 | 36 | 24 |
| 3 | 380 | 380 | 190 | 126 | 95 | 63 | 42 |
| 4 | 530 | 530 | 265 | 176 | 132 | 88 | 58 |
| 5 | 760 | 760 | 380 | 253 | 190 | 126 | 84 |
| 6 | 1080 | 1080 | 540 | 360 | 270 | 180 | 120 |

These values represent ownership limits only.

Deployable active forces remain restricted by Warband and Horde organization.

---

## 12. Food Upkeep Interaction

Capacity is not the only limiter.

Food upkeep remains an independent economic pressure.

Current examples:

```text
Snaga = 1 Food
Uruk-Hai = 4 Food
Mountain Troll = 7 Food
Flying War Cerberus = 8 Food
Olog-Hai = 10 Food
```

This prevents high-capacity creatures from being balanced only by roster space.

A creature may be affordable in capacity but expensive to maintain economically.

---

## 13. Mount Capacity

Mounted units combine rider and mount capacity directly.

Formula:

```text
Mounted Capacity =
Rider Capacity + Mount Capacity
```

Examples:

```text
Uruk + Warg
2 + 2 = 4
```

```text
Mountain Orc + War Warg
3 + 3 = 6
```

```text
Uruk-Hai + War Warg
4 + 3 = 7
```

Unlike combat stats, capacity is added 1:1.

This reflects the logistical space required by both rider and mount.

---

## 14. Balance Risks

### Action Economy

Multiple low-capacity creatures may generate more separate attacks than one large creature.

Example:

```text
9 Snaga capacity = 9
1 Olog-Hai capacity = 9
```

If every creature performs one full attack per combat round, nine Snaga may gain a major action-economy advantage.

This must be tested in the final battle simulation.

### Elite Equipment

High-tier orcs gain additional value from larger Strength capacity and more flexible loadouts.

Creature capacity therefore cannot be calculated from base stats alone.

### Flying Mobility

Flying creatures may gain significant tactical advantages once distance, targeting, and engagement rules are active.

Their capacity may require later adjustment after full battle testing.

---

## 15. V1 Balance Assessment

### Player Progression

The current player progression provides:

- steady Warband growth;
- meaningful Horde milestones;
- increasing reserve space;
- increasing army-management complexity.

### Warband System

The Warband acts as the primary tactical unit.

Its capacity progression is simple and predictable:

```text
20 → 24 → 28 → 32 → 36 → 40
```

### Horde System

The Horde represents four Warbands and scales automatically with player level.

### Creature Capacity

The optimized creature capacity values provide significantly better differentiation than the original 1–2 model.

They are considered suitable for initial implementation.

---

## 16. V1 Rules Locked

### Player

```text
6 Player Levels
```

### Warband

```text
Warband Capacity:
20 / 24 / 28 / 32 / 36 / 40
```

### Horde

```text
Horde Capacity = Warband Capacity × 4
```

### Max Warbands

```text
5 / 6 / 9 / 11 / 14 / 18
```

### Max Hordes

```text
1 / 1 / 2 / 2 / 3 / 4
```

### Player Roster Capacity

```text
150 / 220 / 380 / 530 / 760 / 1080
```

### Creature Capacity

```text
Snaga                 1
Uruk                  2
Mountain Orc          3
Uruk-Hai              4

Warg                  2
War Warg              3

Giant Bat             2
Giant War Bat         3
Flying War Cerberus   6

Cave Troll            4
Mountain Troll        6
Olog-Hai              9
```

---

## V1 Status

The current progression and capacity model is considered stable enough for implementation.

The next major balance pass should be based on actual Warband-vs-Warband battle simulations, with particular attention to:

- action economy;
- ranged engagement;
- flying mobility;
- mounted units;
- equipment loadouts;
- food economy;
- high-tier creature efficiency.
