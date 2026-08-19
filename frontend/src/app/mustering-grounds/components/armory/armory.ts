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


  ngOnInit() {
    this.musteringGroundsStore.getCreatureForgeRequiredData();
    this.musteringGroundsApi.getAllCreatures();
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
