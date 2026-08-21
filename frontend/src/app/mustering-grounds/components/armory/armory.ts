import {Component, computed, HostListener, inject, signal} from '@angular/core';
import {MusteringGroundsStore} from '../../data-access/store/mustering-grounds-store';

@Component({
  selector: 'app-armory',
  imports: [],
  templateUrl: './armory.html',
  styleUrls: ['./armory.css'],
})
export class Armory {

  private readonly musteringGroundsStore =
    inject(MusteringGroundsStore);

  readonly creatures =
    this.musteringGroundsStore.creatures;

  readonly selectedCreature =
    this.musteringGroundsStore.CreatureById;

  readonly equipment = computed(() => {
    const creature = this.selectedCreature();

    if (!creature) {
      return null;
    }
    return creature.equipments;
  });

  readonly races =
    computed(() => {
      const data =
        this.musteringGroundsStore.creatureForgeRequiredData();

      if (!data) {
        return [];
      }

      return [
        ...data.orcRaceTypes,
        ...data.trollRaceTypes,
        ...data.flyingRaceTypes,
        ...data.mountRaceTypes
      ];
    });

  readonly selectedRace = computed(() => {
    const creature = this.selectedCreature();

    if (!creature) {
      return null;
    }

    return this.races().find(race =>
      race.raceTypeValue === creature.raceTypeValue) ?? null;
  });

  readonly weapons =
    computed(() => {
      const data =
        this.musteringGroundsStore.creatureForgeRequiredData();

      if (!data) {
        return [];
      }

      return data.weaponTypes;

    });

  readonly selectedSlot =
    signal<'left-hand' | 'right-hand' | null>(null);

  readonly selectedWeaponValue =
    signal<string>('');

  readonly selectedWeapon =
    computed(() => {
    const value = this.selectedWeaponValue();

    return this.weapons().find(weapon => weapon.value === value);
  })

  readonly newCreatureStats = computed(() => {
    const creature = this.selectedCreature();
    const weapon = this.selectedWeapon();

    if (!creature) {
      return null;
    }

    if (!weapon) {

      const stats = {
        damage: creature.damage,
        defense: creature.defense
      };
      return stats;
    }

    const stats = {
      damage: creature.damage + weapon.damageBonus,
      defense: creature.defense + weapon.defenseBonus
    }
    return stats;
  });

  ngOnInit() {
    this.musteringGroundsStore.getCreatureForgeRequiredData();
    this.musteringGroundsStore.getCreature(this.musteringGroundsStore.selectedCreatureId()!);
  }

  setSelectedSlot(slot: 'left-hand' | 'right-hand' | null) {
    this.selectedSlot.set(slot);
  }


  @HostListener('document:click')
  clearSelections() {
    this.selectedSlot.set(null);
    this.selectedWeaponValue.set('');
  }

}
