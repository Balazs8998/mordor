import {Component, signal} from '@angular/core';
import {Armory} from '../../components/armory/armory';
import {CreatureRoster} from '../../components/creature-roster/creature-roster';
import {ForgeServant} from '../../components/forge-servant/forge-servant';

@Component({
  selector: 'app-mustering-grounds',
  imports: [
    Armory,
    CreatureRoster,
    ForgeServant
  ],
  templateUrl: './mustering-grounds.html',
  styleUrl: './mustering-grounds.css',
})
export class MusteringGrounds {

  activeSection = signal<'forge' | 'roster' | 'armory' | null>(null);

  selectSection(section: 'forge' | 'roster' | 'armory') {
    this.activeSection.set(section);
  }

}
