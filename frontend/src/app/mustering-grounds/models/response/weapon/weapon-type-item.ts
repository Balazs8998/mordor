export interface WeaponTypeItem {
  iconImgUrl: string;
  imgUrl: string;
  leftHandLayerImgUrl: string;
  rightHandLayerImgUrl: string;
  twoHandedLayerImgUrl: string;

  value: string;
  displayName: string;
  combatRangeValue: string;
  combatRangeDisplayName: string;

  damageBonus: number;
  defenseBonus: number;
  strengthCost: number;
  range: number;
  requiredStrength: number;

  goldCost: number;
  mordorSteelCost: number;

}
