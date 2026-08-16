# Mordor Combat & Equipment Balance – V1

## Purpose

This document records the first stable version of the creature stat, equipment capacity, dual-wield, and base combat balance system.

The goal of V1 is not final balance. The purpose is to establish a consistent baseline that can later be tested against recruitment cost, unit capacity, battle phases, ranged combat, mounts, and progression.

---

## 1. Core Creature Stats

Every creature has the following base combat-related values:

- `strength`
- `currentStrength`
- `movementSpeed`
- `health`
- `currentHealth`
- `damage`
- `defense`

### Strength

`strength` represents the creature's total equipment capacity.

It is **not** a direct damage modifier.

Each weapon has a `strengthCost`. The total strength cost of carried equipment may not exceed the creature's available strength.

```text
sum(weapon.strengthCost) <= creature.strength
```

### Current Strength

`currentStrength` represents the remaining equipment capacity.

At creature creation:

```text
currentStrength = strength
```

Example:

```text
Uruk strength = 6

Mace strengthCost = 3
Knife strengthCost = 1

After equipping Mace:
currentStrength = 3

After equipping Knife:
currentStrength = 2
```

### Equipment Count

A creature may carry a maximum of three weapons/items.

Both restrictions apply:

```text
weaponCount <= 3
```

and

```text
totalStrengthCost <= strength
```

---

## 2. Orc Base Stats

| Race | Strength | Movement Speed | Health | Damage | Defense |
|---|---:|---:|---:|---:|---:|
| Snaga | 4 | 2.0 | 30 | 3 | 1 |
| Uruk | 6 | 2.0 | 40 | 4 | 2 |
| Mountain Orc | 8 | 2.0 | 50 | 5 | 3 |
| Uruk-Hai | 10 | 2.0 | 60 | 6 | 4 |

The intended progression is based partly on better base stats and partly on access to stronger or more flexible equipment combinations.

---

## 3. Troll Base Stats

| Race | Strength | Movement Speed | Health | Damage | Defense |
|---|---:|---:|---:|---:|---:|
| Cave Troll | 8 | 1.0 | 65 | 6 | 2 |
| Mountain Troll | 10 | 1.0 | 80 | 7 | 3 |
| Olog-Hai | 12 | 1.0 | 100 | 9 | 4 |

Trolls have:

- significantly more health than orcs;
- stronger natural damage;
- slower movement;
- access to heavy equipment through higher strength capacity.

The intended balance is that a strong equipped orc can defeat a weaker troll, while stronger trolls remain a separate weight class.

---

## 4. Flying Creature Base Stats

| Race | Strength | Movement Speed | Health | Damage | Defense |
|---|---:|---:|---:|---:|---:|
| Giant Bat | 3 | 4.0 | 25 | 4 | 1 |
| Giant War Bat | 5 | 4.0 | 40 | 5 | 2 |
| Flying War Cerberus | 7 | 3.0 | 60 | 7 | 3 |

Flying creatures intentionally have lower raw durability than the strongest ground units.

Their value is expected to increase later through:

- movement advantage;
- engagement control;
- target selection;
- distance management;
- ranged/melee interaction.

For this reason, their raw stats should not be balanced as if they were ordinary ground units.

---

## 5. Mount Base Stats

| Race | Strength | Movement Speed | Health | Damage | Defense |
|---|---:|---:|---:|---:|---:|
| Warg | 3 | 3.0 | 35 | 4 | 1 |
| War Warg | 5 | 4.0 | 50 | 5 | 2 |

Mounted combat does not use simple 1:1 stat addition between mount and rider.

The current V1 direction is to calculate mounted unit stats from weighted values.

Initial formula:

```text
Mounted HP =
mountHealth + riderHealth * 0.40
```

```text
Mounted Damage =
mountDamage + riderFinalDamage * 0.65
```

```text
Mounted Defense =
mountDefense + riderFinalDefense * 0.50
```

Movement speed is inherited from the mount:

```text
mountedMovementSpeed = mountMovementSpeed
```

The rider's movement speed is not added to the mount.

---

## 6. Weapon Stats – V1

| Weapon | Damage Bonus | Defense Bonus | Range | Strength Cost |
|---|---:|---:|---:|---:|
| Knife | +1 | 0 | 0 | 1 |
| One Hand Sword | +2 | +1 | 0 | 2 |
| Mace | +3 | 0 | 0 | 3 |
| Shield | 0 | +3 | 0 | 3 |
| Spear | +2 | 0 | 1 | 3 |
| Bow | +2 | 0 | 3 | 3 |
| Long Sword | +3 | +1 | 0 | 5 |
| Long Spear | +3 | 0 | 2 | 5 |
| Heavy Mace | +5 | 0 | 0 | 6 |

### Intended Weapon Roles

- **Knife** – very low-cost backup weapon.
- **One Hand Sword** – balanced low-cost melee weapon.
- **Mace** – stronger offensive one-handed weapon.
- **Shield** – dedicated defensive equipment.
- **Spear** – melee weapon with reach advantage.
- **Bow** – ranged weapon.
- **Long Sword** – strong one-handed weapon with defensive value.
- **Long Spear** – higher reach, intended as a two-handed weapon.
- **Heavy Mace** – highest direct weapon damage, intended as a two-handed weapon.

---

## 7. Example Equipment Capacity

### Snaga – Strength 4

Valid examples:

```text
Sword + Sword
2 + 2 = 4
```

```text
Sword + Knife
2 + 1 = 3
```

```text
Bow + Knife
3 + 1 = 4
```

```text
Mace + Knife
3 + 1 = 4
```

Invalid example:

```text
Long Sword
5 > 4
```

---

### Uruk – Strength 6

Valid examples:

```text
Mace + Mace
3 + 3 = 6
```

```text
Sword + Shield
2 + 3 = 5
```

```text
Bow + Sword
3 + 2 = 5
```

```text
Bow + Mace
3 + 3 = 6
```

```text
Long Sword + Knife
5 + 1 = 6
```

```text
Heavy Mace
6 = 6
```

---

### Mountain Orc – Strength 8

Valid examples:

```text
Long Sword + Shield
5 + 3 = 8
```

```text
Heavy Mace + Sword
6 + 2 = 8
```

```text
Bow + Mace + Sword
3 + 3 + 2 = 8
```

---

### Uruk-Hai – Strength 10

Valid examples:

```text
Long Sword + Shield + Knife
5 + 3 + 1 = 9
```

```text
Heavy Mace + Shield
6 + 3 = 9
```

```text
Long Sword + Mace + Sword
5 + 3 + 2 = 10
```

```text
Bow + Long Sword + Sword
3 + 5 + 2 = 10
```

The higher strength value therefore increases loadout flexibility rather than directly increasing combat damage.

---

## 8. Carried Equipment vs Active Equipment

Carried equipment and active equipment are separate concepts.

A creature may carry up to three items, but only currently active weapons contribute combat bonuses.

Example:

```text
Uruk-Hai equipment:
- Long Sword
- Shield
- Knife
```

Possible active setup:

```text
Long Sword + Shield
```

The Knife is carried but does not contribute stats while inactive.

Another example:

```text
Bow + Sword + Knife
```

At range:

```text
Active: Bow
```

At melee distance:

```text
Active: Sword + Knife
```

This allows equipment switching based on battle distance without stacking every carried item's stats.

---

## 9. One-Handed and Two-Handed Weapons

V1 assumes two active hand slots.

Planned two-handed weapons:

- `BOW`
- `LONG_SPEAR`
- `HEAVY_MACE`

These weapons occupy both active hands.

One-handed weapons may be combined if strength capacity allows it.

Examples:

```text
Sword + Sword
```

```text
Mace + Mace
```

```text
Long Sword + Shield
```

A separate `handsRequired` or equivalent weapon property should be introduced before the active equipment system is finalized.

---

## 10. Dual-Wield Scaling

Two offensive weapons do not contribute their damage bonus at full value.

V1 rule:

```text
primary weapon bonus = 100%
secondary weapon bonus = 50%
```

Final weapon-enhanced damage:

```text
finalDamage =
baseDamage
+ primaryWeapon.damageBonus
+ secondaryWeapon.damageBonus * 0.50
```

### Example – Snaga with one sword

```text
Base Damage = 3
Sword Bonus = 2

Final Damage = 3 + 2
             = 5
```

### Example – Snaga with two swords

```text
Base Damage = 3
Primary Sword = 2
Secondary Sword = 2 * 0.50

Final Damage = 3 + 2 + 1
             = 6
```

The second weapon therefore improves damage without doubling the complete attack value.

---

## 11. Shield Scaling

Shield defense is applied at full value.

```text
shieldDefenseBonus = 100%
```

Example:

```text
Uruk-Hai baseDefense = 4
Shield defenseBonus = 3

Final Defense = 7
```

A shield uses an active hand, so the defensive gain is balanced by reduced offensive flexibility.

---

## 12. Sample Offensive Loadouts

| Unit | Loadout | HP | Approx. Damage | Approx. Defense |
|---|---|---:|---:|---:|
| Snaga | Sword + Sword | 30 | 6.0 | 2.5 |
| Snaga | Mace + Knife | 30 | 6.5 | 1 |
| Uruk | Mace + Mace | 40 | 8.5 | 2 |
| Uruk | Heavy Mace | 40 | 9.0 | 2 |
| Uruk | Sword + Shield | 40 | 6.0 | 6 |
| Mountain Orc | Heavy Mace | 50 | 10.0 | 3 |
| Mountain Orc | Long Sword + Shield | 50 | 8.0 | 7 |
| Uruk-Hai | Heavy Mace | 60 | 11.0 | 4 |
| Uruk-Hai | Long Sword + Shield | 60 | 9.0 | 8 |
| Cave Troll | Heavy Mace | 65 | 11.0 | 2 |
| Mountain Troll | Heavy Mace | 80 | 12.0 | 3 |
| Olog-Hai | Heavy Mace | 100 | 14.0 | 4 |
| Olog-Hai | Long Sword + Shield | 100 | 12.0 | 8 |

Values involving two active weapons are provisional until the active-hand system is implemented directly in code.

---

## 13. Initial Matchup Evaluation

Using the current base stats and offensive equipment combinations, the progression remains within the intended hierarchy:

```text
Snaga < Uruk < Mountain Orc < Uruk-Hai
```

Troll comparison:

```text
Uruk-Hai > Cave Troll
Mountain Troll > Uruk-Hai
Olog-Hai >> Uruk-Hai
```

This is intentional.

A high-tier equipped orc should be capable of defeating a lower-tier troll, while stronger trolls should remain substantially more durable and dangerous.

The current system avoids the rule:

```text
Troll = automatic win against every Orc
```

while preserving a meaningful distinction between the two creature families.

---

## 14. Defense Calculation

Direct subtraction is not suitable for the final combat system.

The following model should be avoided:

```text
receivedDamage = incomingDamage - defense
```

At higher defense values this can create zero-damage situations and effectively immortal units.

The current V1 candidate uses diminishing returns:

```text
receivedDamage =
incomingDamage * 100 / (100 + defense * 12)
```

Example:

Higher defense continuously reduces incoming damage, but never creates complete immunity.

The exact multiplier (`12`) remains subject to battle testing.

---

## 15. Movement and Distance

`movementSpeed` represents how many distance units a creature can change during one movement phase.

Example:

```text
distance = 6
movementSpeed = 2

After moving toward target:
distance = 4
```

This gives unit types different tactical identities.

Current movement profile:

```text
Troll       -> slow
Orc         -> standard
Warg        -> fast
Flying      -> very fast
```

Movement is expected to become especially important against ranged units.

A slow troll may take multiple ranged attacks before reaching melee distance, while a mounted unit may close the same distance much faster.

---

## 16. Weapon Range

Weapon `range` must have an actual battle-system effect.

Without a range mechanic:

```text
Long Sword > Long Spear
```

would often be true because the Long Sword provides similar damage plus defense.

Planned direction:

- spear receives an engagement/reach advantage;
- long spear receives a larger reach advantage;
- bow attacks from ranged distance;
- bow cannot be used at `distance = 0`;
- movement speed determines how quickly melee units can close distance.

The exact phase logic remains outside the V1 balance lock.

---

## 17. V1 Rules Locked

The following rules define the current V1 baseline:

### Creature

```text
strength = maximum equipment capacity
currentStrength = remaining equipment capacity
movementSpeed = distance units moved per movement phase
```

### Equipment

```text
maximum carried items = 3
total strengthCost <= creature strength
```

### Combat Equipment

```text
only active equipment contributes stats
primary weapon bonus = 100%
secondary offensive weapon bonus = 50%
shield defense bonus = 100%
two-handed weapon = no active secondary item
```

### Mount

```text
mount + rider stats are weighted
stats are not added 1:1
movement speed comes from mount
```

### Defense

```text
defense should use diminishing returns
direct damage-minus-defense subtraction is not the target model
```

### Troll Equipment

Troll weapon bonuses currently use the same base weapon values as orcs.

No additional troll-specific equipment efficiency modifier is part of V1.

---

## 18. Known Future Balance Variables

The current combat values cannot define the complete unit balance alone.

Later versions must also consider:

- recruitment cost;
- recruitment time;
- horde/unit capacity cost;
- weapon cost;
- level progression;
- buffs and debuffs;
- target priority;
- battle distance;
- ranged phases;
- mount/rider interaction;
- flying engagement rules;
- weapon switching;
- casualties and recovery.

An Olog-Hai and a Snaga therefore do not need comparable raw combat power if their acquisition and army-capacity costs are significantly different.

---

## V1 Status

The current values are considered a **first playable balance baseline**.

They are stable enough for implementation and frontend display, but remain intentionally open to adjustment after the first complete battle simulation is available.
