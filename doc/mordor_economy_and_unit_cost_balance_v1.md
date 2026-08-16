# Mordor Economy & Unit Cost Balance – V1

## Purpose

This document records the first stable version of the unit recruitment cost, upkeep, roster capacity, and weapon pricing model.

The goal of V1 is to support the existing combat balance system without turning the project into a full economy or resource-management game.

The economy is intentionally limited to a small number of resources so that unit composition, equipment choices, and army capacity remain the main strategic decisions.

---

## 1. Core Economy Model

V1 uses three economic values:

- `GOLD`
- `MORDOR_STEEL`
- `FOOD`

In addition, the army uses a non-currency roster limit:

- `CAPACITY`

### Gold

Gold is the general recruitment and purchasing resource.

It is used for:

- recruiting creatures;
- purchasing weapons;
- purchasing mounts or elite units.

Gold is the most universal resource in the system.

### Mordor Steel

Mordor Steel represents military-grade metal used for:

- armor;
- weaponry;
- war-beast equipment;
- elite military preparation.

It is intentionally used as a secondary limiter for stronger units and equipment.

Not every creature requires Mordor Steel.

This allows low-tech units and natural beasts to remain accessible even when steel is scarce.

### Food

Food is primarily an upkeep resource.

It represents the ongoing cost of maintaining living creatures.

V1 direction:

```text
Gold + Mordor Steel = acquisition cost
Food = ongoing upkeep
```

Food is not intended to be a major one-time recruitment cost.

### Capacity

Capacity represents how much army space a creature occupies.

It is not a currency.

Capacity exists to prevent the strongest unit from automatically becoming the best army composition.

Example:

```text
Snaga capacity = 1
Olog-Hai capacity = 2
```

A stronger creature can therefore consume more roster space even when the player can afford it.

---

## 2. Unit Recruitment and Upkeep Costs

| Unit | Gold | Mordor Steel | Food Upkeep | Capacity |
|---|---:|---:|---:|---:|
| Snaga | 30 | 0 | 1 | 1 |
| Uruk | 55 | 1 | 2 | 1 |
| Mountain Orc | 85 | 2 | 3 | 1 |
| Uruk-Hai | 125 | 3 | 4 | 1 |
| Cave Troll | 95 | 0 | 5 | 2 |
| Mountain Troll | 150 | 1 | 7 | 2 |
| Olog-Hai | 230 | 3 | 10 | 2 |
| Warg | 45 | 0 | 3 | 1 |
| War Warg | 80 | 1 | 4 | 1 |
| Giant Bat | 55 | 0 | 2 | 1 |
| Giant War Bat | 100 | 2 | 4 | 1 |
| Flying War Cerberus | 190 | 4 | 8 | 2 |

---

## 3. Unit Cost Design Goals

The cost model is not intended to make every unit equal.

Instead, it reinforces different unit identities.

### Snaga

```text
Low Gold
No Mordor Steel
Low Food
Low Capacity
```

The Snaga is cheap, expendable, and easy to field in large numbers.

### Uruk

```text
Moderate Gold
Low Steel
Moderate Food
Low Capacity
```

The Uruk is a reliable standard combat unit with access to useful equipment combinations.

### Mountain Orc

```text
Higher Gold
Moderate Steel
Moderate Food
Low Capacity
```

The Mountain Orc acts as a heavier infantry option without consuming additional roster capacity.

### Uruk-Hai

```text
High Gold
High Steel
Higher Food
Low Capacity
```

The Uruk-Hai is expensive but extremely capacity-efficient.

Its high strength capacity allows advanced equipment combinations while still consuming one standard roster slot.

---

## 4. Troll Cost Identity

Trolls use a different balance profile from orcs.

They are not necessarily the most expensive units in every recruitment resource.

Instead, their disadvantages are concentrated in:

- higher food consumption;
- larger roster capacity;
- slower movement.

### Cave Troll

The Cave Troll has strong base combat power while requiring no Mordor Steel.

```text
95 Gold
0 Steel
5 Food
2 Capacity
```

This makes it a useful heavy unit when steel is limited.

### Mountain Troll

The Mountain Troll is stronger than elite orc infantry in direct combat, but requires significantly more upkeep and roster space.

```text
150 Gold
1 Steel
7 Food
2 Capacity
```

### Olog-Hai

The Olog-Hai is a premium heavy unit.

```text
230 Gold
3 Steel
10 Food
2 Capacity
```

Its high combat power is balanced by:

- expensive recruitment;
- very high food upkeep;
- double standard roster capacity;
- low movement speed.

The purpose is to keep the Olog-Hai powerful without making an all-Olog army automatically optimal.

---

## 5. Mount Cost Identity

| Mount | Gold | Mordor Steel | Food | Capacity |
|---|---:|---:|---:|---:|
| Warg | 45 | 0 | 3 | 1 |
| War Warg | 80 | 1 | 4 | 1 |

Mounts create additional combat value through mobility and rider interaction.

Mounted unit stats are not calculated by direct 1:1 addition.

Because the rider and mount are separate acquired units, mounted armies naturally become more expensive.

---

## 6. Flying Unit Cost Identity

| Flying Unit | Gold | Mordor Steel | Food | Capacity |
|---|---:|---:|---:|---:|
| Giant Bat | 55 | 0 | 2 | 1 |
| Giant War Bat | 100 | 2 | 4 | 1 |
| Flying War Cerberus | 190 | 4 | 8 | 2 |

Flying units receive strategic value from mobility and engagement control.

Their cost therefore includes value that is not fully visible in raw HP, Damage, and Defense.

This is especially important once distance-based combat and target selection are fully implemented.

---

## 7. Weapon Costs – V1

| Weapon | Damage Bonus | Defense Bonus | Range | Strength Cost | Gold | Mordor Steel |
|---|---:|---:|---:|---:|---:|---:|
| Knife | +1 | 0 | 0 | 1 | 8 | 0 |
| One Hand Sword | +2 | +1 | 0 | 2 | 18 | 1 |
| Mace | +3 | 0 | 0 | 3 | 20 | 1 |
| Shield | 0 | +3 | 0 | 3 | 24 | 2 |
| Spear | +2 | 0 | 1 | 3 | 18 | 1 |
| Bow | +2 | 0 | 3 | 3 | 26 | 1 |
| Long Sword | +3 | +1 | 0 | 5 | 34 | 2 |
| Long Spear | +3 | 0 | 2 | 5 | 30 | 2 |
| Heavy Mace | +5 | 0 | 0 | 6 | 36 | 3 |

---

## 8. Weapon Pricing Logic

Weapon cost is not calculated only from raw damage.

The following factors influence price:

- damage bonus;
- defense bonus;
- range;
- strength efficiency;
- hand requirement;
- tactical role.

### Knife

```text
8 Gold
0 Steel
```

Low-cost backup equipment.

### One Hand Sword

```text
18 Gold
1 Steel
```

Balanced low-cost melee weapon.

### Mace

```text
20 Gold
1 Steel
```

More offensive than a sword but provides no defense bonus.

### Shield

```text
24 Gold
2 Steel
```

The Shield uses more steel because it is a dedicated defensive item.

### Spear

```text
18 Gold
1 Steel
```

Its long-term value depends on the reach system rather than raw stats alone.

### Bow

```text
26 Gold
1 Steel
```

The Bow is intentionally more expensive than its raw `+2 Damage` suggests.

Its `range = 3` is expected to become a major tactical advantage.

### Long Sword

```text
34 Gold
2 Steel
```

A strong one-handed weapon with both offensive and defensive value.

### Long Spear

```text
30 Gold
2 Steel
```

Its price accounts for higher reach and future distance-phase value.

### Heavy Mace

```text
36 Gold
3 Steel
```

The Heavy Mace provides the highest direct weapon damage and is intended as a two-handed weapon.

Its high steel cost prevents it from becoming the default choice for every strong creature.

---

## 9. Dual-Wield Cost Interaction

The combat system currently uses reduced secondary-weapon scaling:

```text
primary weapon bonus = 100%
secondary offensive weapon bonus = 50%
```

This prevents two low-cost weapons from doubling full attack power.

Example:

```text
Mace bonus = +3
Second Mace bonus = +1.5

Total weapon bonus = +4.5
```

Compare this with:

```text
Heavy Mace bonus = +5
```

### Cost Comparison

Two Maces:

```text
40 Gold
2 Mordor Steel
Damage bonus = +4.5
```

Heavy Mace:

```text
36 Gold
3 Mordor Steel
Damage bonus = +5
```

The Heavy Mace is slightly more efficient in raw damage and Gold cost, but consumes more Mordor Steel and both active hands.

This creates a meaningful trade-off instead of a single objectively superior loadout.

---

## 10. Example Full Build Costs

| Build | Gold | Steel | Food | Capacity | HP | Approx. Damage | Approx. Defense |
|---|---:|---:|---:|---:|---:|---:|---:|
| Snaga + 2 Swords | 66 | 2 | 1 | 1 | 30 | 6.0 | 2.5 |
| Uruk + 2 Maces | 95 | 3 | 2 | 1 | 40 | 8.5 | 2 |
| Uruk + Heavy Mace | 91 | 4 | 2 | 1 | 40 | 9.0 | 2 |
| Mountain Orc + Long Sword + Shield | 143 | 6 | 3 | 1 | 50 | 8.0 | 7 |
| Uruk-Hai + Heavy Mace | 161 | 6 | 4 | 1 | 60 | 11.0 | 4 |
| Cave Troll + Heavy Mace | 131 | 3 | 5 | 2 | 65 | 11.0 | 2 |
| Mountain Troll + Heavy Mace | 186 | 4 | 7 | 2 | 80 | 12.0 | 3 |
| Olog-Hai + Heavy Mace | 266 | 6 | 10 | 2 | 100 | 14.0 | 4 |

---

## 11. Balance Comparison – Cave Troll vs Uruk-Hai

### Cave Troll + Heavy Mace

```text
131 Gold
3 Mordor Steel
5 Food
2 Capacity
```

### Uruk-Hai + Heavy Mace

```text
161 Gold
6 Mordor Steel
4 Food
1 Capacity
```

Current combat testing gives the Uruk-Hai a slight direct-combat advantage.

The Cave Troll remains economically relevant because it:

- costs less Gold;
- requires significantly less Mordor Steel;
- has more raw health.

Its disadvantages are:

- higher food consumption;
- double roster capacity;
- lower movement speed.

This gives the Cave Troll a distinct economic role instead of making it a weaker version of the Uruk-Hai.

---

## 12. Balance Comparison – Mountain Troll vs Uruk-Hai

### Mountain Troll + Heavy Mace

```text
186 Gold
4 Steel
7 Food
2 Capacity
```

### Uruk-Hai + Heavy Mace

```text
161 Gold
6 Steel
4 Food
1 Capacity
```

The Mountain Troll is stronger in direct combat.

The Uruk-Hai remains more efficient in:

- roster space;
- food consumption;
- mobility.

This prevents the Mountain Troll from replacing elite orc infantry in every army.

---

## 13. Balance Comparison – Olog-Hai

### Olog-Hai + Heavy Mace

```text
266 Gold
6 Steel
10 Food
2 Capacity
100 HP
~14 Damage
4 Defense
```

The Olog-Hai is intentionally expensive.

Its high raw combat value is balanced by:

- very high upkeep;
- large roster requirement;
- slow movement;
- high total acquisition cost.

A player can field an Olog-Hai as a heavy centerpiece without making lower-tier units irrelevant.

---

## 14. Mounted Elite Example

Example:

```text
Uruk-Hai + War Warg + Long Spear
```

Base acquisition:

```text
Uruk-Hai = 125 Gold / 3 Steel
War Warg = 80 Gold / 1 Steel
Long Spear = 30 Gold / 2 Steel
```

Total:

```text
235 Gold
6 Mordor Steel
8 Food
2 Capacity
```

This creates an elite mobile unit with strong reach and movement.

Compare with:

```text
Olog-Hai + Heavy Mace
266 Gold
6 Mordor Steel
10 Food
2 Capacity
```

Both occupy a similar economic tier while serving very different battlefield roles.

### Mounted Uruk-Hai

Primary identity:

- mobility;
- reach;
- fast engagement;
- equipment flexibility.

### Olog-Hai

Primary identity:

- durability;
- direct damage;
- frontline pressure;
- high raw combat power.

This is the intended V1 balance direction.

---

## 15. V1 Economy Rules Locked

### Recruitment

```text
Creature recruitment:
Gold + Mordor Steel
```

### Equipment

```text
Weapon purchase:
Gold + Mordor Steel
```

### Upkeep

```text
Food = ongoing creature upkeep
```

Weapons do not currently require upkeep.

### Army Size

```text
Capacity = roster limit
```

Capacity is not consumed as a currency.

### Resource Count

V1 intentionally uses only:

```text
Gold
Mordor Steel
Food
```

Additional resources such as iron, sulfur, wood, or stone are not part of the current economy.

This avoids unnecessary resource-management complexity.

---

## 16. Future Balance Variables

The current economy is a first-pass balance layer.

Later versions may adjust costs based on:

- battle simulation results;
- recruitment time;
- unit level;
- weapon rarity;
- player progression;
- horde capacity progression;
- mounted combat performance;
- flying-unit tactical advantage;
- recovery time;
- casualty replacement;
- resource production rates.

The current values should therefore be treated as a stable V1 baseline rather than final production balance.

---

## V1 Status

The current economic model is considered suitable for initial implementation.

It supports:

- differentiated unit identities;
- meaningful equipment decisions;
- elite-unit scarcity;
- troll upkeep pressure;
- mount and flying-unit specialization;
- army-capacity trade-offs.

The next major balance pass should be performed after the complete battle system and resource-income rates are implemented.


