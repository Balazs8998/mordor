import {Component, computed, DestroyRef, inject, signal} from '@angular/core';
import {MusteringGroundsApi} from '../../data-access/api/mustering-grounds-api';
import {MusteringGroundsStore} from '../../data-access/store/mustering-grounds-store';
import {NonNullableFormBuilder} from '@angular/forms';

@Component({
  selector: 'app-armory',
  imports: [],
  templateUrl: './armory.html',
  styleUrls: ['./armory.css'],
})
export class Armory {

  private readonly musteringGroundsStore = inject(MusteringGroundsStore);
  private readonly musteringGroundsApi = inject(MusteringGroundsApi);

  private readonly formBuilder = inject(NonNullableFormBuilder);
  private readonly destroyRef = inject(DestroyRef);

  readonly selectedWeaponValue = signal<string>('');
  readonly selectedCreature = this.musteringGroundsStore.CreatureById;

  races = computed(() => {
    const data = this.musteringGroundsStore.creatureForgeRequiredData();

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

    return this.races().find(race => race.raceTypeValue === creature.raceTypeValue) ?? null;
  })

  readonly equipment = computed(() => {
    const creature = this.selectedCreature();

    if(!creature) {
      return null;
    }
    return creature.equipments;
  })

  readonly newCreatureStats = computed(() => {
    const creature = this.selectedCreature();
    const weapon = this.selectedWeapon();

    if (!creature) {
      return null;
    }

    if (!weapon){

      const stats = {
        damage: creature?.damage!,
        defense: creature?.defense!
      }

      return stats

    }

    const stats = {
      damage: creature?.damage! + weapon?.damageBonus!,
      defense: creature?.defense! + weapon?.defenseBonus!
    }



    return stats;

  })

  ngOnInit() {
    this.musteringGroundsStore.getCreatureForgeRequiredData();
    this.musteringGroundsStore.getCreature(this.musteringGroundsStore.selectedCreatureId()!);
  }

  readonly weapons = computed(() => {
    const data = this.musteringGroundsStore.creatureForgeRequiredData();

    if (!data) {
      return [];
    }

    return data.weaponTypes;

  })

  readonly creatures = this.musteringGroundsStore.creatures

  readonly selectedWeapon = computed(() => {
    const value = this.selectedWeaponValue();

    return this.weapons().find(weapon => weapon.value === value);
  })



}
