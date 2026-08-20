import {EquipmentItemResponse} from '../equipment/equipment-item-response';

export interface CreatureItemResponse {

  id: number;
  name: string;
  level: number;

  raceTypeValue: string;
  raceTypeDisplayName: string;
  roleDisplayName: string;
  creatureTypeDisplayName: string;

  strength: number;
  agility: number;
  intelligence: number;

  health: number;
  damage: number;
  defense: number;

  morale: number;

  movementSpeed: number;
  strengthLoad: number;
  currentHealth: number;

  foodUpkeep: number;
  capacityCost: number;

  weaponCount: number;
  imgUrl: string;

  equipments: EquipmentItemResponse;
}
