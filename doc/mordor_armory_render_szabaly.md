# Armory – középső render és képgenerálási szabályok

## 1. A középső render célja

Az Armory középső részén a lény nem egyetlen kész képként jelenik meg.

A végső látvány több, egymásra helyezett PNG layerből áll össze:

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

Nem minden layer kötelező.

Ha a lényen nincs felszerelés:

```text
background
base creature
```

Ha például csak kard van a jobb kezében:

```text
background
base creature
right hand weapon
```

Ha teljesen fel van szerelve:

```text
background
base creature
legs
chest
left hand
right hand
head
```

Az Angular csak akkor rendereli az adott képet, ha az equipment slot ténylegesen tartalmaz tárgyat.

Példa:

```html
@if (equipment()?.rightHand) {
  <img
    [src]="equipment()?.rightHand?.layerImgUrl"
    class="creature-layer right-hand-layer"
  >
}
```

Ha nincs jobb kézben tárgy, a hozzá tartozó `<img>` elem sem kerül bele a DOM-ba.

---

## 2. Kötelező képméret

A karakterre kerülő összes layernek **pontosan ugyanakkora canvasméretűnek kell lennie**.

### Javasolt szabvány

```text
1024 × 1536 px
```

Ez legyen a teljes karakter-render szabványos mérete.

Ide tartozik:

- base creature
- helmet / head
- chest armor
- legs
- left-hand weapon
- right-hand weapon
- shield
- későbbi vállvért
- cloak
- accessory
- minden más, karakterre kerülő grafikai layer

### Fontos

Ha más mérettel kezdjük el a tényleges assetgyártást, akkor azt kell végig használni.

**Különböző layer canvasméreteket tilos keverni.**

Például ez rossz:

```text
orc.png             1024 × 1536
iron_chest.png       768 × 1024
sword.png            512 × 512
helmet.png          1024 × 1024
```

Ez jó:

```text
orc.png             1024 × 1536
iron_chest.png      1024 × 1536
sword.png           1024 × 1536
helmet.png          1024 × 1536
```

---

## 3. Transparent canvas szabály

Az equipment layer NEM egy szorosan kivágott tárgykép.

Például a kard PNG-je nem ilyen:

```text
┌───────────┐
│   sword   │
└───────────┘
```

Hanem egy teljes, transparent karakter-canvas:

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

A kardnak már a PNG-ben pontosan ott kell lennie, ahol a karakter kezében meg kell jelennie.

Ugyanez igaz:

- sisakra
- mellvértre
- nadrágra
- csizmára
- pajzsra
- íjra
- lándzsára
- buzogányra
- minden egyéb felszerelésre

---

## 4. Tilos CSS-ben tárgyanként pozicionálni

Nem akarunk ilyen CSS-t:

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

Ez hosszú távon kezelhetetlen lenne.

Az összes layer ugyanarra a canvasra készül, ezért a CSS csak ezt csinálja:

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

A tárgy helyét tehát **maga a PNG határozza meg**, nem a CSS.

---

## 5. A base creature szabálya

A base creature képnek az alaplényt kell tartalmaznia.

Lehetőleg ne legyen rajta olyan felszerelés, amelyet később cserélni akarunk.

Például:

```text
base_orc.png
```

tartalmazhat:

- test
- arc
- haj
- alap bőr
- fix karakterjegyek

Ne tartalmazzon:

- sisakot
- cserélhető mellvértet
- kardot
- pajzsot
- cserélhető nadrágot
- cserélhető csizmát

Ha valami gameplay szempontból equipment, lehetőleg külön layer legyen.

---

## 6. Képgenerálásnál a karakter helyzete nem változhat

Ez az egyik legfontosabb szabály.

Minden generált equipment layer ugyanahhoz a base creature pozícióhoz készüljön.

Nem változhat:

- a fej helye
- a kezek helye
- a vállak helye
- a test mérete
- a lábak helye
- a kamera szöge
- a kamera távolsága
- a perspektíva

Ha az egyik generálásnál az ork 15 px-lel balrább kerül, az equipment már nem fog pontosan illeszkedni.

---

## 7. Referenciakép használata

Az equipment képek generálásakor mindig ugyanazt a base creature referenciát kell használni.

Ajánlott folyamat:

```text
1. Elkészül a végleges base creature.
2. Ezt lezárjuk referenciaként.
3. Minden armor és weapon ehhez készül.
4. A karakter pozícióját többé nem változtatjuk.
```

Ha később új karaktertípus készül, annak saját equipment-layer készlete lehet.

Például:

```text
orc/
troll/
uruk-hai/
human/
```

---

## 8. Háttér

A háttér külön layer.

Ajánlott:

```text
1024 × 1536 px
```

A háttér természetesen nem transparent.

Példa:

```text
/img/armory/backgrounds/mordor-camp.png
```

A karakter és az equipment PNG-k transparent hátterűek legyenek.

---

## 9. Layer sorrend

Kezdeti rétegsorrend:

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

Ez nem feltétlenül végleges.

Például később szükség lehet:

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

Ezért a layereket külön CSS classokkal kezeljük.

---

## 10. Takarási problémák

Bizonyos tárgyaknál egyszerű z-index nem biztos, hogy elegendő.

Példa:

- pajzs egy része a test előtt van
- a másik része a kar mögött
- köpeny egyik része hátul
- másik része elöl

Ilyenkor ugyanaz az equipment több layerből állhat.

Példa:

```text
cloak_back.png
base_creature.png
chest.png
cloak_front.png
```

Vagy:

```text
shield_back.png
creature.png
shield_front.png
```

Csak akkor vezessünk be ilyen rendszert, ha ténylegesen szükséges.

---

## 11. Fegyverek

A jobb és bal kéz külön asset lehet.

Például:

```text
one_hand_sword_right.png
one_hand_sword_left.png
```

Erre azért lehet szükség, mert a két kéz:

- más helyen van
- más szögben áll
- más perspektívát igényel

Ne próbáljuk automatikusan CSS `scaleX(-1)` tükrözéssel megoldani, ha a grafika természetellenes lesz.

---

## 12. Kétkezes fegyver

Kétkezes fegyvernél ne legyen két külön azonos weapon layer.

Legyen egyetlen, teljes karakter-canvasra készített layer:

```text
great_sword_two_handed.png
```

Ez már úgy legyen generálva, hogy mindkét kézzel fogja a karakter.

Gameplay oldalon továbbra is lefoglalhatja:

```text
LEFT_HAND
RIGHT_HAND
```

de vizuálisan egyetlen PNG layer is elegendő lehet.

---

## 13. Equipment item képtípusok

Egy felszereléshez két külön grafikai kép szükséges.

### Icon

UI gombokhoz és listákhoz.

Példa:

```text
iconImgUrl
```

Javasolt méret:

```text
256 × 256 px
```

vagy

```text
512 × 512 px
```

Transparent PNG.

### Layer

A karakterre kerülő grafika.

Példa:

```text
layerImgUrl
```

Méret:

```text
1024 × 1536 px
```

Transparent PNG.

Példa modell:

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

## 14. Selected Item nagy képe

A Selected Item panel nagy tárgyképe külön asset is lehet:

```text
imgUrl
```

Ez nem ugyanaz, mint:

```text
iconImgUrl
```

és nem ugyanaz, mint:

```text
layerImgUrl
```

Ajánlott struktúra:

```text
iconImgUrl   → kis UI ikon
imgUrl       → Selected Item nagy tárgykép
layerImgUrl  → karakterre kerülő transparent layer
```

---

## 15. Fájlformátum

### Character és equipment layer

Kötelező:

```text
PNG
```

Transparent alpha csatornával.

Ajánlott:

```text
RGBA
```

### Background

Lehet:

```text
PNG
WEBP
JPG
```

A háttérhez nincs szükség transparent alpha csatornára.

### UI icon

Ajánlott:

```text
PNG
WEBP
```

Ha transparent háttér kell, PNG vagy alpha-képes WEBP.

---

## 16. Fájlelnevezési szabály

Használjunk kisbetűt és kötőjelet vagy underscore-t következetesen.

Példa:

```text
one-hand-sword-right.png
iron-helmet.png
heavy-chest-armor.png
orc-base.png
```

Kerüljük:

```text
One Hand Sword FINAL 2.png
sisakujjooo.png
kard_mostmarjo_final_final.png
```

---

## 17. Javasolt könyvtárstruktúra

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

## 18. Angular render működés

Az Angular Equipment state határozza meg, mely layer jelenik meg.

Példa:

```ts
equipment = {
  head: null,
  chest: ironChest,
  legs: null,
  leftHand: shield,
  rightHand: sword
};
```

A render:

```text
background        YES
base creature     YES

legs              NO
chest             YES
left hand         YES
right hand        YES
head              NO
```

Tehát csak a ténylegesen szükséges képek vannak jelen.

---

## 19. CSS feladata

A CSS feladata:

- layerek egymásra helyezése
- layer sorrend
- méretezés
- középre igazítás
- vignette
- UI layout

A CSS feladata NEM:

- fegyver pontos pozíciójának kiszámítása
- sisak fejre igazítása
- mellvért testre igazítása
- tárgyanként eltérő forgatás
- tárgyanként eltérő scale

Ezeket a generált assetnek kell helyesen tartalmaznia.

---

## 20. Képgenerálási prompt kötelező tartalma

Equipment layer generálásakor a promptban mindig szerepeljen legalább:

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

Ha képszerkesztéssel készítjük:

```text
Do not alter the base character.
Do not change pose.
Do not change camera.
Do not change proportions.
Do not change canvas size.
Add only the requested equipment.
```

---

## 21. Asset ellenőrzési szabály

Minden új layer elkészítése után tesztelni kell legalább:

```text
background + creature + new layer
```

Ellenőrizni:

- helyes pozíció
- helyes méret
- nincs elcsúszás
- nincs levágva
- jó a perspektíva
- jó helyen fogja a fegyvert
- armor nem úszik a test felett
- nincs felesleges háttér
- valóban transparent
- nincs karakterrész véletlenül belerenderelve

---

## 22. Fontos: equipment layer lehetőleg csak a tárgyat tartalmazza

Például egy kard layer:

```text
transparent + sword
```

Ne legyen benne újragenerálva:

```text
orc arm
orc body
orc head
background
```

különben a layerek egymásra helyezésekor vizuális hibák jelenhetnek meg.

Kivétel lehet, ha egy adott felszerelésnél a helyes takaráshoz szükség van egy speciális előtér-layerre.

---

## 23. Kezdeti equipment slotok

Az első verzióban:

```text
HEAD
CHEST
LEGS
LEFT_HAND
RIGHT_HAND
```

Később bővíthető:

```text
SHOULDER
CLOAK
BELT
BOOTS
GLOVES
ACCESSORY
BACK
```

A render rendszer miatt ezek hozzáadása már csak új layer és új slot kérdése.

---

## 24. Legfontosabb szabályok röviden

1. Minden karakter-layer ugyanakkora canvas.
2. Jelenlegi ajánlott szabvány: `1024 × 1536 px`.
3. Equipment layer transparent PNG.
4. A tárgy már a PNG-ben a megfelelő helyen legyen.
5. CSS-ben ne pozicionáljunk külön fegyvereket.
6. Base creature pozícióját lezárás után ne változtassuk.
7. Ugyanazt a referenciakaraktert használjuk minden generáláshoz.
8. Csak a ténylegesen felszerelt item layer renderelődik.
9. `iconImgUrl` és `layerImgUrl` két külön cél.
10. Kétkezes fegyver lehet egyetlen közös render layer.
11. Speciális takarásnál egy item több layerből is állhat.
12. Minden új assetet azonnal összeillesztve tesztelni kell.

---

## 25. Alapelv

A render rendszer célja, hogy a frontendnek ne kelljen tudnia:

> „Hol van az ork keze?”

A frontend csak ezt tudja:

> „Az ork jobb kezében kard van.”

A kard PNG-je már eleve tudja, hol kell megjelennie.

Így a renderelő egyszerű marad:

```text
STATE
  ↓
melyik equipment van felszerelve?
  ↓
szükséges layer PNG-k kiválasztása
  ↓
egymásra renderelés
  ↓
kész karakter
```

Ez legyen az Armory karakter-render alapelve.
