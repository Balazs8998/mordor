import {Component, DestroyRef, effect, inject, signal} from '@angular/core';
import {NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {OrcApi} from '../../../../service/api/orc-api';
import {Router} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';
import {parseHttpError} from '../../../../../core/shared/models/http-error-util';
import {WeaponTypeResponse} from '../../models/response/weapon-type-response';
import {RaceTypeResponse} from '../../models/response/race-type-response';
import {OrcStore} from '../../../../service/store/orc-store';

@Component({
  selector: 'app-orc-create',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './orc-create.html',
  styleUrls: ['./orc-create.css'],
})
export class OrcCreate {

  private readonly orcApi = inject(OrcApi);
  private readonly orcStore = inject(OrcStore);
  private readonly router = inject(Router);

  private readonly formBuilder = inject(NonNullableFormBuilder);
  private readonly destroyRef = inject(DestroyRef);


  readonly raceTypes = signal<RaceTypeResponse[]>([]);
  readonly weaponTypes = signal<WeaponTypeResponse[]>([]);

  readonly validationErrors = signal<Record<string,string>>({})
  readonly apiError = signal<string | null>(null)

  readonly reforgedOrc = effect(() => {
   const id = this.orcStore.reforgedOrc();
   console.log(id)
   if (!id) {
     return;
   }
   this.orcApi.getOrc(id).pipe(
     takeUntilDestroyed(this.destroyRef)
   ).subscribe({
     next: (orc) => {
       this.orcForm.patchValue(orc);
     },
     error: (err: HttpErrorResponse) => {
       const parsedError = parseHttpError(err);
       this.apiError.set(parsedError.apiError);
     }
   });
  });


  readonly orcForm = this.formBuilder.group({
    id: [null as number | null],
    name: ['', Validators.required],
    race: ['', Validators.required],
    weapons: [<string[]>[], [Validators.required, Validators.maxLength(3)]],
    kills: [0],
  });

  ngOnInit() {
    this.getRaceAndWeapons();
    this.orcForm.valueChanges.pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe(() => {
      this.validationErrors.update(error => {
        const updatedErrors = {...error};
        delete updatedErrors['text'];
        delete updatedErrors['title'];
        return updatedErrors;
      });
    this.apiError.set(null);
    });
  }

  onSubmit(){
    if(this.orcForm.invalid){
      return;
    }
      const request = this.orcForm.getRawValue();
    console.log(this.orcForm.invalid)

      this.orcApi.createOrc(request).pipe(
        takeUntilDestroyed(this.destroyRef)
      ).subscribe({
        next:() => {
          this.router.navigate(['/orcs'])
          if(this.orcForm.getRawValue().id !== null){
            this.orcStore.isReforged.set(true);
            this.orcStore.reforgedOrc.set(null);
          }else {
            this.orcStore.isCreated.set(true);
          }
        },
        error: (err : HttpErrorResponse) => {
          const parsedError = parseHttpError(err)

          this.validationErrors.set(parsedError.validationErrors);
          this.apiError.set(parsedError.apiError);
        }
      });
  }

  getRaceAndWeapons(){
    this.orcApi.getCreateOrcRequiredData().pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: (data) => {
        this.raceTypes.set(data.raceTypes);
        this.weaponTypes.set(data.weaponTypes);
        console.log(this.raceTypes(), this.weaponTypes());
      },
      error: (err: HttpErrorResponse) => {
        const parsedError = parseHttpError(err);
        this.apiError.set(parsedError.apiError);
      }
    });
  }

}
