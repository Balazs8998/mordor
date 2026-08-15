import {CreatureTypeItem} from './creature-type-item';
import {WeaponTypeItem} from '../weapon/weapon-type-item';

export interface CreatureForgeRequiredDataResponse {
  orcRaceTypes: CreatureTypeItem[];
  trollRaceTypes: CreatureTypeItem[];
  flyingRaceTypes: CreatureTypeItem[];
  mountRaceTypes: CreatureTypeItem[];
  weaponTypes: WeaponTypeItem[];
}
