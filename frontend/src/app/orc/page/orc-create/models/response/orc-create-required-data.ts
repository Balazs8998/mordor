import {WeaponTypeResponse} from './weapon-type-response';
import {RaceTypeResponse} from './race-type-response';

export interface OrcCreateRequiredData {
  raceTypes: RaceTypeResponse[];
  weaponTypes: WeaponTypeResponse[];
}
