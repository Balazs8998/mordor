import {Component, computed, DestroyRef, effect, HostListener, inject, linkedSignal, signal} from '@angular/core';
import {MusteringGroundsStore} from '../../data-access/store/mustering-grounds-store';
import {CreatureEquipmentSave} from '../../models/request/creature-equipment-save';
import {CreatureStats} from '../../models/use-models/creature-stats';
import {MusteringGroundsApi} from '../../data-access/api/mustering-grounds-api';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {Router} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-armory',
  imports: [],
  templateUrl: './armory.html',
  styleUrls: ['./armory.css'],
})
export class Armory {

  private readonly musteringGroundsStore =
    inject(MusteringGroundsStore);

  private readonly musteringGroundsApi =
    inject(MusteringGroundsApi);

  private readonly destroyRef =
    inject(DestroyRef);

  private readonly router =
    inject(Router);

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
    });

  readonly equipmentDraft =
    linkedSignal<CreatureEquipmentSave | null>(() => {
      const creature = this.selectedCreature();
      const equipment = this.equipment();

      if (!creature || !equipment) {
        return null;
      }

      return {
        creatureId: creature.id,
        leftHand: equipment.leftHand ?? null,
        rightHand: equipment.rightHand ?? null,
        weapons: [...equipment.weapons]
      };
    });


  readonly preViewCreatureStat = computed(() => {
    const selectedRaceData = this.selectedRace();
    const draftEquiped = this.equipmentDraft();
    const selectedWeaponValuePre = this.selectedWeaponValue

    const slot = this.selectedSlot();
    const slotMap = slot === 'left-hand' ? 'leftHand' : 'rightHand';
    const oppositeSlotMap = slotMap === 'leftHand' ? 'rightHand' : 'leftHand';


    if (!selectedRaceData) {
      return {damage: 0, defense: 0};
    }

    let stats: CreatureStats = {
      damage: selectedRaceData.baseDamage,
      defense: selectedRaceData.baseDefense
    }

    const selectedWeaponData =
      this.getWeaponByValue(selectedWeaponValuePre());

    const oppositeSlotWeaponData =
      selectedWeaponData?.handsRequired === 1
        ?
        this.getWeaponByValue(this.equipmentDraft()?.[oppositeSlotMap] ?? '')
        :
        undefined;


    if (slot !== null && selectedWeaponValuePre() !== '') {

      if (oppositeSlotWeaponData?.handsRequired === 2) {
        stats = {
          damage: stats.damage + (selectedWeaponData?.damageBonus ?? 0),
          defense: stats.defense + (selectedWeaponData?.defenseBonus ?? 0)
        }

        return stats;
      }

      stats = {
        damage: stats.damage + (selectedWeaponData?.damageBonus ?? 0) + (oppositeSlotWeaponData?.damageBonus ?? 0),
        defense: stats.defense + (selectedWeaponData?.defenseBonus ?? 0) + (oppositeSlotWeaponData?.defenseBonus ?? 0)
      }

      return stats;
    }

    if (draftEquiped && selectedWeaponValuePre() === '') {
      const leftHandWeapon = this.getWeaponByValue(draftEquiped.leftHand);
      const rightHandWeapon = this.getWeaponByValue(draftEquiped.rightHand);
      stats = {
        damage: stats.damage + (leftHandWeapon?.damageBonus ?? 0) + (rightHandWeapon?.damageBonus ?? 0),
        defense: stats.defense + (leftHandWeapon?.defenseBonus ?? 0) + (rightHandWeapon?.defenseBonus ?? 0)
      }
    }

    return stats;
  })


  ngOnInit() {
    this.musteringGroundsStore.getCreatureForgeRequiredData();
    this.musteringGroundsStore.getCreature(this.musteringGroundsStore.selectedCreatureId()!);

  }

  setSelectedSlot(slot: 'left-hand' | 'right-hand' | null) {
    this.selectedSlot.set(slot);
  }

  equipWeapon() {
    const weapon = this.selectedWeapon();
    const slot = this.selectedSlot();

    if (!weapon || !slot) {
      return;
    }

    const slotMapper: 'leftHand' | 'rightHand' =
      slot === 'left-hand'
        ? 'leftHand'
        : 'rightHand';

    const oppositeSlot: 'leftHand' | 'rightHand' =
      slotMapper === 'leftHand'
        ? 'rightHand'
        : 'leftHand';

    this.equipmentDraft.update(value => {
      if (!value) {
        return null;
      }

      if (weapon.handsRequired === 2) {
        if (value[slotMapper] != null) {
          value.weapons.push(value[slotMapper])
          const index = value.weapons.findIndex(
            weapon => weapon === this.selectedWeaponValue()
          );

          if (index !== -1) {
            value.weapons.splice(index, 1);
          }
        }
        if (value[oppositeSlot] != null) {
          value.weapons.push(value[oppositeSlot])
          const index = value.weapons.findIndex(
            weapon => weapon === this.selectedWeaponValue()
          );

          if (index !== -1) {
            value.weapons.splice(index, 1);
          }

        }
        return {
          ...value,
          [slotMapper]: weapon.value,
          [oppositeSlot]: null
        };
      }

      const oppositeWeapon =
        this.getWeaponByValue(value[oppositeSlot]);

      if (oppositeWeapon?.handsRequired === 2) {
        if (value[slotMapper] != null) {
          value.weapons.push(value[slotMapper])
          const index = value.weapons.findIndex(
            weapon => weapon === this.selectedWeaponValue()
          );

          if (index !== -1) {
            value.weapons.splice(index, 1);
          }
        }
        if (value[oppositeSlot] != null) {
          value.weapons.push(value[oppositeSlot])
          const index = value.weapons.findIndex(
            weapon => weapon === this.selectedWeaponValue()
          );

          if (index !== -1) {
            value.weapons.splice(index, 1);
          }

        }
        return {
          ...value,
          [slotMapper]: weapon.value,
          [oppositeSlot]: null
        };
      }

      const index = value.weapons.findIndex(
        weapon => weapon === this.selectedWeaponValue()
      );

      if (index !== -1) {
        value.weapons.splice(index, 1);
      }

      if (value[slotMapper] != null) {

        value.weapons.push(value[slotMapper])
      }

      return {
        ...value,
        [slotMapper]: weapon.value
      };
    });
  }

  public save() {
    if (!this.musteringGroundsStore.selectedCreatureId() || !this.equipmentDraft()) {
      return;
    }

    this.musteringGroundsApi.saveEquipment(
      this.musteringGroundsStore.selectedCreatureId()!,
      this.equipmentDraft()!
    ).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: () => {
        this.musteringGroundsStore.getCreature(this.musteringGroundsStore.selectedCreatureId()!);
      },
      error: (error: HttpErrorResponse) => {
        // const parsedError = parseHttpError(error);
        // this.apiError.set(parsedError.apiError);
      }
    });
  }

  private getWeaponByValue(value: string | null) {
    if (!value) {
      return undefined;
    }

    return this.weapons().find(weapon => weapon.value === value);
  }


  @HostListener('document:click')
  clearSelections() {
    this.selectedSlot.set(null);
    this.selectedWeaponValue.set('');
  }

}
