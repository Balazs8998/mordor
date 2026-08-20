# Armory – Central Rendering and Image Generation Rules

## 1. Purpose of the central renderer

The creature shown in the center of the Armory is not rendered as one finished image.

The final visual is assembled from multiple PNG layers placed on top of each other:

```text
background
↓
base creature
↓
legs
↓
chest
↓
left hand
↓
right hand
↓
head
```

Not every layer is required.

If the creature has no equipment:

```text
background
base creature
```

If it only has a sword in its right hand:

```text
background
base creature
right hand weapon
```

If it is fully equipped:

```text
background
base creature
legs
chest
left hand
right hand
head
```

Angular only renders an image if the corresponding equipment slot actually contains an item.

Example:

```html
@if (equipment()?.rightHand) {
  <img
    [src]="equipment()?.rightHand?.layerImgUrl"
    class="creature-layer right-hand-layer"
  >
}
```

If there is no item in the right hand, the related `<img>` element is not added to the DOM at all.

---

## 2. Mandatory image size

Every layer placed on the creature must use **exactly the same canvas dimensions**.

### Recommended standard

```text
1024 × 1536 px
```

This should be the standard size for the complete character render.

This includes:

- base creature
- helmet / head
- chest armor
- legs
- left-hand weapon
- right-hand weapon
- shield
- future shoulder armor
- cloak
- accessory
- every other graphical layer rendered on the creature

### Important

If we decide to use another final asset size, then that size must be used consistently for all related layers.

**Do not mix different canvas dimensions.**

Bad:

```text
orc.png             1024 × 1536
iron_chest.png       768 × 1024
sword.png            512 × 512
helmet.png          1024 × 1024
```

Good:

```text
orc.png             1024 × 1536
iron_chest.png      1024 × 1536
sword.png           1024 × 1536
helmet.png          1024 × 1536
```

---

## 3. Transparent canvas rule

An equipment layer is NOT a tightly cropped image of the item.

For example, the sword PNG should not look like this:

```text
┌───────────┐
│   sword   │
└───────────┘
```

Instead, it must use the full transparent character canvas:

```text
1024 × 1536

┌───────────────────────────────┐
│ transparent                   │
│                               │
│                               │
│                     sword     │
│                       ╲       │
│                        ╲      │
│                               │
│ transparent                   │
│                               │
└───────────────────────────────┘
```

The sword must already be placed exactly where it belongs in the creature's hand.

The same rule applies to:

- helmets
- chest armor
- trousers
- boots
- shields
- bows
- spears
- maces
- every other equipment item

---

## 4. Do not position individual items with CSS

We do not want CSS like this:

```css
.one-hand-sword {
  left: 284px;
  top: 392px;
  rotate: 31deg;
}

.heavy-mace {
  left: 251px;
  top: 376px;
  rotate: 18deg;
}
```

That would become unmaintainable very quickly.

All layers use the same canvas, so CSS should only need something like:

```css
.creature-layer {
  position: absolute;
  inset: 0;

  width: 100%;
  height: 100%;

  object-fit: contain;
  object-position: center bottom;
}
```

The exact position of the item is defined by the PNG itself, not by CSS.

---

## 5. Base creature rule

The base creature image should contain the core creature only.

Ideally it should not include equipment that may later be replaced.

For example:

```text
base_orc.png
```

may contain:

- body
- face
- hair
- base skin
- permanent character features

It should not contain:

- helmet
- replaceable chest armor
- sword
- shield
- replaceable trousers
- replaceable boots

If something is gameplay equipment, it should preferably be a separate layer.

---

## 6. Creature position must never change between generated layers

This is one of the most important rules.

Every generated equipment layer must match the exact same base creature position.

The following must not change:

- head position
- hand position
- shoulder position
- body scale
- leg position
- camera angle
- camera distance
- perspective

If one generated asset shifts the creature even slightly, the equipment layer may no longer align correctly.

---

## 7. Use the same reference image

Every equipment asset should be generated from the same locked base creature reference.

Recommended process:

```text
1. Create the final base creature.
2. Lock it as the reference image.
3. Create all armor and weapon layers against that reference.
4. Never change the character position afterwards.
```

If a new creature family is added later, it may need its own equipment layer set.

Example:

```text
orc/
troll/
uruk-hai/
human/
```

---

## 8. Background

The background is a separate layer.

Recommended size:

```text
1024 × 1536 px
```

The background does not need transparency.

Example:

```text
/img/armory/backgrounds/mordor-camp.png
```

Creature and equipment layers should use transparent backgrounds.

---

## 9. Layer order

Initial layer order:

```text
z-index: 1    background
z-index: 10   base creature

z-index: 20   legs
z-index: 30   chest
z-index: 40   left hand
z-index: 50   right hand
z-index: 60   head

z-index: 100  vignette / render effect
```

This is not necessarily final.

Later we may need:

```text
back weapon
cloak back
creature
legs
chest
cloak front
left hand
right hand
head
effects
```

For that reason, layers should always be handled with separate CSS classes.

---

## 10. Occlusion problems

For some items, a simple z-index may not be enough.

Example:

- part of a shield is in front of the body
- another part is behind the arm
- part of a cloak is behind the creature
- another part is in front

In those cases, one equipment item may use multiple layers.

Example:

```text
cloak_back.png
base_creature.png
chest.png
cloak_front.png
```

Or:

```text
shield_back.png
creature.png
shield_front.png
```

Only introduce this complexity when it is actually needed.

---

## 11. Weapons

Left-hand and right-hand variants may need separate assets.

Example:

```text
one_hand_sword_right.png
one_hand_sword_left.png
```

This may be necessary because the two hands:

- are positioned differently
- use different angles
- may require different perspective

Do not rely on CSS `scaleX(-1)` mirroring if it makes the asset look unnatural.

---

## 12. Two-handed weapons

For a two-handed weapon, do not render the same weapon twice.

Use a single complete layer:

```text
great_sword_two_handed.png
```

It should already be generated so that the creature is holding it with both hands.

Gameplay-wise, the weapon may still occupy:

```text
LEFT_HAND
RIGHT_HAND
```

but visually, a single PNG layer may be enough.

---

## 13. Equipment image types

Each equipment item needs two separate visual assets.

### Icon

Used for UI buttons and lists.

Example:

```text
iconImgUrl
```

Recommended size:

```text
256 × 256 px
```

or

```text
512 × 512 px
```

Transparent PNG.

### Layer

Used on the creature render.

Example:

```text
layerImgUrl
```

Size:

```text
1024 × 1536 px
```

Transparent PNG.

Example model:

```ts
{
  displayName: 'One-Handed Sword',

  iconImgUrl:
    '/img/weapons/icons/one-hand-sword.png',

  layerImgUrl:
    '/img/weapons/layers/orc/one-hand-sword-right.png'
}
```

---

## 14. Selected Item large image

The large image in the Selected Item panel may use a separate asset:

```text
imgUrl
```

This is not the same as:

```text
iconImgUrl
```

and not the same as:

```text
layerImgUrl
```

Recommended structure:

```text
iconImgUrl   → small UI icon
imgUrl       → large Selected Item image
layerImgUrl  → transparent layer rendered on the creature
```

---

## 15. File formats

### Creature and equipment layers

Required:

```text
PNG
```

with transparent alpha channel.

Recommended:

```text
RGBA
```

### Background

Can be:

```text
PNG
WEBP
JPG
```

The background does not require transparency.

### UI icon

Recommended:

```text
PNG
WEBP
```

If transparency is required, use PNG or alpha-enabled WEBP.

---

## 16. File naming convention

Use lowercase file names consistently and separate words with either hyphens or underscores.

Example:

```text
one-hand-sword-right.png
iron-helmet.png
heavy-chest-armor.png
orc-base.png
```

Avoid:

```text
One Hand Sword FINAL 2.png
helmet_new_final.png
sword_final_final_really.png
```

---

## 17. Suggested folder structure

```text
assets/
└── img/
    └── armory/

        backgrounds/
            mordor-camp.png

        creatures/
            orc/
                base/
                    orc-warrior.png

                head/
                    iron-helmet.png
                    horned-helmet.png

                chest/
                    iron-chest.png
                    heavy-chest.png

                legs/
                    iron-legs.png
                    heavy-legs.png

                weapons/
                    right/
                        one-hand-sword.png
                        mace.png
                        axe.png

                    left/
                        one-hand-sword.png
                        shield.png

                    two-handed/
                        great-sword.png
                        long-spear.png

        icons/
            weapons/
            armor/
            resources/

        items/
            weapons/
            armor/
```

---

## 18. Angular render behavior

Angular equipment state determines which layers are visible.

Example:

```ts
equipment = {
  head: null,
  chest: ironChest,
  legs: null,
  leftHand: shield,
  rightHand: sword
};
```

The render result:

```text
background        YES
base creature     YES

legs              NO
chest             YES
left hand         YES
right hand        YES
head              NO
```

Only the necessary images are present.

---

## 19. Responsibility of CSS

CSS is responsible for:

- stacking layers
- layer order
- scaling
- centering
- vignette
- UI layout

CSS is NOT responsible for:

- calculating the exact weapon position
- aligning helmets to the head
- aligning chest armor to the torso
- item-specific rotation
- item-specific scaling

Those must already be correct in the generated asset.

---

## 20. Mandatory prompt requirements for image generation

When generating an equipment layer, the prompt should always include at least:

```text
- transparent background
- exact same canvas size
- exact same character position
- exact same camera
- exact same perspective
- do not move or resize the character
- render only the requested equipment layer
- equipment must align exactly with the provided base creature
```

For image editing:

```text
Do not alter the base character.
Do not change pose.
Do not change camera.
Do not change proportions.
Do not change canvas size.
Add only the requested equipment.
```

---

## 21. Asset validation rule

Every new layer should be tested immediately with at least:

```text
background + creature + new layer
```

Check:

- correct position
- correct scale
- no unwanted shift
- no clipping
- correct perspective
- weapon is held in the correct position
- armor does not float above the body
- no accidental background
- transparency is correct
- no unintended character parts were rendered into the layer

---

## 22. Equipment layers should contain only the item whenever possible

For example, a sword layer should ideally contain:

```text
transparent + sword
```

It should not contain a regenerated copy of:

```text
orc arm
orc body
orc head
background
```

Otherwise visual artifacts may appear when layers are stacked.

Exception: a special front or back layer may be necessary for correct occlusion.

---

## 23. Initial equipment slots

First version:

```text
HEAD
CHEST
LEGS
LEFT_HAND
RIGHT_HAND
```

Possible future additions:

```text
SHOULDER
CLOAK
BELT
BOOTS
GLOVES
ACCESSORY
BACK
```

Because of the layer system, these can later be added as new slots and new image layers.

---

## 24. Most important rules in short

1. Every character layer uses the same canvas size.
2. Current recommended standard: `1024 × 1536 px`.
3. Equipment layers use transparent PNG.
4. The item must already be positioned correctly inside the PNG.
5. Do not position individual weapons with CSS.
6. Do not move the base creature after it has been locked.
7. Use the same reference creature for every related generation.
8. Render only equipment that is actually equipped.
9. `iconImgUrl` and `layerImgUrl` serve different purposes.
10. A two-handed weapon may use one shared visual layer.
11. Special occlusion may require multiple layers for one item.
12. Test every new asset immediately in the full stack.

---

## 25. Core principle

The frontend should not need to know:

> “Where is the orc's hand?”

The frontend only needs to know:

> “The orc has a sword in its right hand.”

The sword PNG already knows where it belongs.

This keeps the renderer simple:

```text
STATE
  ↓
Which equipment is currently equipped?
  ↓
Select required PNG layers
  ↓
Stack the layers
  ↓
Final character render
```

This is the core rendering rule for the Armory.
