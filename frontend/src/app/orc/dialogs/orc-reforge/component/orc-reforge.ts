import {Component, inject} from '@angular/core';
import {OrcStore} from '../../../service/store/orc-store';

@Component({
  selector: 'app-orc-reforge',
  imports: [],
  templateUrl: './orc-reforge.html',
  styleUrl: './orc-reforge.css',
})
export class OrcReforge {

  private readonly orcStore = inject(OrcStore);

  protected isReforged = this.orcStore.isReforged;
}
