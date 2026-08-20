export interface CreatureTypeItem {
  raceTypeValue: string;
  raceTypeDisplayName: string;

  roleValue: string;
  roleDisplayName: string;

  creatureTypeValue: string;
  creatureTypeDisplayName: string;

  movementTypeValue: string;
  movementTypeDisplayName: string;

  strength: number;
  agility: number;
  intelligence: number;

  baseHealth: number;
  baseDamage: number;
  baseDefense: number;

  morale: number;

  movementSpeed: number;

  foodUpkeep: number;
  capacityCost: number;

  recruitmentGoldCost: number;
  recruitmentMordorSteelCost: number;

  imgUrl: string;
}
