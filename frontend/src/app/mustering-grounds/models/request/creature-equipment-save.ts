export interface CreatureEquipmentSave {
  creatureId: number;
  leftHand: string | null;
  rightHand: string | null;
  weapons: (string | null)[];
}
