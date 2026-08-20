import {Component, signal} from '@angular/core';
import {Armory} from '../../components/armory/armory';
import {CreatureRoster} from '../../components/creature-roster/creature-roster';
import {ForgeServant} from '../../components/forge-servant/forge-servant';
import {CreatureDetails} from '../../components/creature-details/creature-details';

@Component({
  selector: 'app-mustering-grounds',
  imports: [
    Armory,
    CreatureRoster,
    ForgeServant,
    CreatureDetails
  ],
  templateUrl: './mustering-grounds.html',
  styleUrl: './mustering-grounds.css',
})
export class MusteringGrounds {

  activeSection = signal<'forge' | 'roster' | 'armory' | 'details' | null>(null);

  selectSection(section: 'forge' | 'roster' | 'armory' | 'details') {
    this.activeSection.set(section);
  }

}
