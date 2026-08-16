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
  movementSpeed: number;

  baseHealth: number;
  baseDamage: number;
  baseDefense: number;

  recruitmentGoldCost: number;
  recruitmentMordorSteelCost: number;
  foodUpkeep: number;
  capacityCost: number;

  imgUrl: string;
}
