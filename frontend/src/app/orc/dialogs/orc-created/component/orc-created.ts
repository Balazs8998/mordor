import {Component, inject} from '@angular/core';
import {OrcStore} from '../../../service/store/orc-store';

@Component({
  selector: 'app-orc-created',
  imports: [],
  templateUrl: './orc-created.html',
  styleUrl: './orc-created.css',
})
export class OrcCreated {

  private readonly orcStore = inject(OrcStore);

  protected isCreated = this.orcStore.isCreated;

}
