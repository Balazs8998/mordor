import {Component, inject} from '@angular/core';
import {OrcStore} from '../../../../service/store/orc-store';
import {OrcDelete} from '../../../../dialogs/orc-delete/component/orc-delete';
import {Router} from '@angular/router';
import {OrcReforge} from '../../../../dialogs/orc-reforge/component/orc-reforge';
import {OrcCreated} from '../../../../dialogs/orc-created/component/orc-created';

@Component({
  selector: 'app-orc-list',
  imports: [
    OrcDelete,
    OrcReforge,
    OrcCreated
  ],
  templateUrl: './orc-list.html',
  styleUrls: ['./orc-list.css'],
})
export class OrcList {

  private readonly orcStore = inject(OrcStore);
  private readonly router = inject(Router);

  readonly apiError = this.orcStore.apiError;

  readonly orcs = this.orcStore.orcs;

  readonly isExecuted = this.orcStore.isExecuted;
  readonly isReforged = this.orcStore.isReforged;
  readonly isCreated = this.orcStore.isCreated;


  ngOnInit() {
    this.orcStore.getAllOrcs();
    console.log(this.orcStore.orcs());
  }

  ngOnDestroy() {
    this.isReforged.set(false);
    this.isExecuted.set(false);
    this.isCreated.set(false);

  }

  execute(id:number){
    this.orcStore.deleteOrc(id);
  }

  reforge(id:number){
    this.orcStore.reforgedOrc.set(id);
    this.router.navigate(['/orcs/create']);
  }
}
