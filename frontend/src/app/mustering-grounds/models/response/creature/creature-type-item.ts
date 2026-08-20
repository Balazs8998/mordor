export interface CreatureTypeItem {
  raceTypeValue: string;
  raceTypeDisplayName: string;

  roleValue: string;
  roleDisplayName: string;

  creatureTypeValue: string;
  creatureTypeDisplayName: string;

  movementTypeValue: string;
  movementTypeDisplayName: string;

  baseStrength: number;
  baseAgility: number;
  baseIntelligence: number;

  baseHealth: number;
  baseDamage: number;
  baseDefense: number;

  baseMorale: number;

  baseMovementSpeed: number;

  foodUpkeep: number;
  capacityCost: number;

  recruitmentGoldCost: number;
  recruitmentMordorSteelCost: number;

  imgUrl: string;
}
