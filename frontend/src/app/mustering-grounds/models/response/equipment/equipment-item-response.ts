export interface EquipmentItemResponse {

  id: number;
  creatureId: number;

  rightHand: string | null;
  rightHandIconImgUrl: string | null;
  rightHandLayerImgUrl: string | null;

  leftHand: string | null;
  leftHandIconImgUrl: string | null;
  leftHandLayerImgUrl: string | null;

  weapons: string[];
}
