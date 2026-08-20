import {Component, computed, inject, output, signal} from '@angular/core';
import {MusteringGroundsStore} from '../../data-access/store/mustering-grounds-store';

const PLAYER_LEVEL = 0; //PlaceHolder

@Component({
  selector: 'app-creature-roster',
  imports: [],
  templateUrl: './creature-roster.html',
  styleUrl: './creature-roster.css',
})
export class CreatureRoster {

  private readonly musteringGroundsStore = inject(MusteringGroundsStore);

  readonly creatures = this.musteringGroundsStore.creatures;

  readonly apiError = this.musteringGroundsStore.apiError;

  readonly rosterMode =
    signal<'ARMORY' | 'DETAILS'>('ARMORY');

  readonly rosterModeOutput =
    output<'armory' | 'details'>();

  readonly playerRequiredData =
    computed(() => {
     const data = this.musteringGroundsStore.playerRequiredData()

      if (!data) {
        return null;
      }

        return data.playerRequiredData[PLAYER_LEVEL] ?? null;

    });

  readonly capacityCost = computed(() => {
   return  this.creatures()
      .reduce((sum, creature) =>
        sum + creature.capacityCost, 0)

  });

  readonly totalFoodUpkeep = computed(() => {
    const data = this.creatures()
    let foodUpkeep = 0


    for (const creature of data) {
      foodUpkeep += creature.foodUpkeep
    }
    return foodUpkeep
  });

  toggleRosterMode(): void {
    this.rosterMode.update(mode =>
      mode === 'ARMORY'
        ? 'DETAILS'
        : 'ARMORY'
    );
  }

  openCreature(creatureId: number) {

    const route =
      this.rosterMode() === 'ARMORY'
        ? 'armory'
        : 'details';

    this.musteringGroundsStore.selectCreature(creatureId);
    this.rosterModeOutput.emit(route);


  }

  ngOnInit() {
    this.musteringGroundsStore.getPlayerRequiredData();
    this.musteringGroundsStore.getAllCreatures();
  }

}
