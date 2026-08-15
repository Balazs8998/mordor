import {Component, DestroyRef, inject, signal} from '@angular/core';
import {OrcApi} from '../../../../service/api/orc-api';
import {NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {Router} from '@angular/router';
import {parseHttpError} from '../../../../../core/shared/models/http-error-util';

@Component({
  selector: 'app-horde-create',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './horde-create.html',
  styleUrl: './horde-create.css',
})
export class HordeCreate {

  private readonly orcApi = inject(OrcApi);

  private readonly router = inject(Router);
  private readonly destroyRef = inject(DestroyRef);
  private readonly formBuilder = inject(NonNullableFormBuilder);

  readonly apiError = signal<string | null>(null);
  readonly validationErrors = signal<Record<string,string>>({})


  hordeForm = this.formBuilder.group({
    name: ['', Validators.required],
  });

  onSubmit(){
    if(this.hordeForm.invalid){
      return;
    }
    const request = this.hordeForm.getRawValue();

    this.orcApi.createHorde(request).pipe(takeUntilDestroyed(this.destroyRef)).subscribe({
      next: () => {
        console.log(this.hordeForm.getRawValue());
      },
      error: (error) => {
        const parsedError = parseHttpError(error);
        this.apiError.set(parsedError.apiError);
        this.validationErrors.set(parsedError.validationErrors);
      }
    });
  }
}
