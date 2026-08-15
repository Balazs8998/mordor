import {Component, computed, DestroyRef, inject, signal} from '@angular/core';
import {NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MusteringGroundsStore} from '../../data-access/store/mustering-grounds-store';
import {MusteringGroundsApi} from '../../data-access/api/mustering-grounds-api';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {HttpErrorResponse} from '@angular/common/http';
import {parseHttpError} from '../../../core/shared/models/http-error-util';
import {KeyValuePipe} from '@angular/common';

@Component({
  selector: 'app-forge-servant',
  imports: [
    ReactiveFormsModule,
  ],
  templateUrl: './forge-servant.html',
  styleUrls: ['./forge-servant.css'],
})
export class ForgeServant {

  private readonly formBuilder = inject(NonNullableFormBuilder);
  private readonly destroyRef = inject(DestroyRef);

  private readonly musteringGroundsStore = inject(MusteringGroundsStore);
  private readonly musteringGroundsApi = inject(MusteringGroundsApi);

  readonly apiError = signal<string | null>(null);
  readonly validationErrors = signal<Record<string, string>>({});

  readonly hasValidationErrors = computed(
    () => Object.keys(this.validationErrors()).length > 0
  );

  readonly validationErrorEntries = computed(() =>
    Object.entries(this.validationErrors())
  );

  ngOnInit() {
    this.musteringGroundsStore.getCreatureForgeRequiredData();
  }

  readonly selectedRaceValue = signal<string>('');

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
    const value = this.selectedRaceValue();

    return this.races().find(race => race.value === value) ?? null;
  });

  creatureForm = this.formBuilder.group({
    name : ['', Validators.required],
    race: ['', Validators.required]
  });

  onSubmit() {
    if (this.creatureForm.invalid) {
      return
    }
    const request = this.creatureForm.getRawValue()

    this.musteringGroundsApi.createCreature(request).pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe(
      {
        next: () => {
          this.apiError.set(null);
          this.validationErrors.set({});
          this.creatureForm.reset();
        },
        error: (error: HttpErrorResponse) => {
          const parsedError = parseHttpError(error);
          this.apiError.set(parsedError.apiError);
          this.validationErrors.set(parsedError.validationErrors);
        }
      }
    )



  }

}
