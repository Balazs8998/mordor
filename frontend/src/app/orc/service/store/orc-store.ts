import {DestroyRef, inject, Service, signal} from '@angular/core';
import {OrcApi} from '../api/orc-api';
import {OrcListResponse} from '../../page/orc-list/models/response/orc-list-response';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {HttpErrorResponse} from '@angular/common/http';
import {parseHttpError} from '../../../core/shared/models/http-error-util';

@Service()
export class OrcStore {

  private readonly orcApi = inject(OrcApi);
  private readonly destroyRef = inject(DestroyRef);

  private readonly _orcs = signal<OrcListResponse[]>([]);
  readonly orcs = this._orcs.asReadonly();

  isReforged = signal(false);
  isExecuted = signal(false);
  isCreated = signal(false);

  reforgedOrc = signal<number | null>(null);

  readonly apiError = signal<string | null>(null);

  deleteOrc(id:number){
    this.orcApi.deleteOrc(id).pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: () => {
        this.isExecuted.set(true);
        this.getAllOrcs();
      },
      error: (err: HttpErrorResponse) => {
        const parsedError = parseHttpError(err);

        this.apiError.set(parsedError.apiError);
      }
    });
  }

  getAllOrcs() {
    this.orcApi.getAllOrcs().pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: (orcs) => this._orcs.set(orcs),
      error: (err: HttpErrorResponse) => {
        const parsedError = parseHttpError(err);

        this.apiError.set(parsedError.apiError);
      }
    });
  }


}
