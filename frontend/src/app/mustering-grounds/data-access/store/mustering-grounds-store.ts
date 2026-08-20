import {DestroyRef, inject, Service, signal} from '@angular/core';
import {MusteringGroundsApi} from '../api/mustering-grounds-api';
import {CreatureForgeRequiredDataResponse} from '../../models/response/creature/creature-forge-required-data-response';
import {parseHttpError} from '../../../core/shared/models/http-error-util';
import {HttpErrorResponse} from '@angular/common/http';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {PlayerRequiredDataResponse} from '../../models/response/player/player-required-data-response';
import {CreatureItemResponse} from '../../models/response/creature/creature-item-response';

@Service()
export class MusteringGroundsStore {

  private readonly musteringGroundsApi = inject(MusteringGroundsApi);
  private readonly destroyRef = inject(DestroyRef);

  readonly apiError = signal<string | null>(null);

  private readonly _creatureForgeRequiredData =
    signal<CreatureForgeRequiredDataResponse | null>(null);

  private readonly _playerRequiredData =
    signal<PlayerRequiredDataResponse | null>(null);

  private readonly _Creatures =
    signal<CreatureItemResponse[]>([]);

  readonly creatureForgeRequiredData =
    this._creatureForgeRequiredData.asReadonly();

  readonly playerRequiredData =
    this._playerRequiredData.asReadonly();

  readonly creatures =
    this._Creatures.asReadonly();

  private readonly _selectedCreatureId = signal<number | null>(null);

  readonly selectedCreatureId =
    this._selectedCreatureId.asReadonly();


  selectCreature(id:number) {
    this._selectedCreatureId.set(id);
  }

  public getCreatureForgeRequiredData() : void {
    this.musteringGroundsApi.getCreatureForgeRequiredData().pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: (response) => {
        this.apiError.set(null);
        this._creatureForgeRequiredData.set(response)
        console.log(response)
      },
      error: (error: HttpErrorResponse) => {
        const parsedError = parseHttpError(error)
        this.apiError.set(parsedError.apiError)
      },
    });
  }

  public getAllCreatures() : void {
    this.musteringGroundsApi.getAllCreatures().pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: (response) => {
        this.apiError.set(null);
        this._Creatures.set(response)
        console.log(response)
      },
      error: (error: HttpErrorResponse) => {
        const parsedError = parseHttpError(error)
        this.apiError.set(parsedError.apiError)
      }
    })
  }

  public getPlayerRequiredData() : void{
    this.musteringGroundsApi.getPlayerRequiredData()
      .pipe(takeUntilDestroyed(this.destroyRef)
      ).subscribe({
      next: (response) => {
        this.apiError.set(null);
        this._playerRequiredData.set(response)
        console.log(response)
      },
      error: (error: HttpErrorResponse) => {
        const parsedError = parseHttpError(error)
        this.apiError.set(parsedError.apiError)
      },
    })
  }


}
