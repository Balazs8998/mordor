import {Component, inject} from '@angular/core';
import {OrcStore} from '../../../service/store/orc-store';

@Component({
  selector: 'app-orc-delete',
  imports: [],
  templateUrl: './orc-delete.html',
  styleUrls: ['./orc-delete.css'],
})
export class OrcDelete {

  private readonly orcStore = inject(OrcStore);

  protected isExecuted = this.orcStore.isExecuted;
}
