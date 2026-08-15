import {DestroyRef, inject, Service, signal} from '@angular/core';
import {MusteringGroundsApi} from '../api/mustering-grounds-api';
import {CreatureForgeRequiredDataResponse} from '../../models/response/creature/creature-forge-required-data-response';
import {parseHttpError} from '../../../core/shared/models/http-error-util';
import {HttpErrorResponse} from '@angular/common/http';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';

@Service()
export class MusteringGroundsStore {

  private readonly musteringGroundsApi = inject(MusteringGroundsApi);
  private readonly destroyRef = inject(DestroyRef);

  readonly apiError = signal<string | null>(null);

  private readonly _creatureForgeRequiredData =
    signal<CreatureForgeRequiredDataResponse | null>(null);

  readonly creatureForgeRequiredData = this._creatureForgeRequiredData.asReadonly();


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


}
