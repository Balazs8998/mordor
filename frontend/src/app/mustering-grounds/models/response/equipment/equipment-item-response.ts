export interface EquipmentItemResponse {

  id: number;
  creatureId: number;

  rightHand: string | null;
  leftHand: string | null;

  weapons: string[];
}
