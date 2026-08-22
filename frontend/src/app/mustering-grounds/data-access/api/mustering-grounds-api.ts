import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CreatureForgeRequiredDataResponse} from '../../models/response/creature/creature-forge-required-data-response';
import {CreatureCreateRequest} from '../../models/request/CreatureCreateRequest';
import {PlayerRequiredDataResponse} from '../../models/response/player/player-required-data-response';
import {CreatureItemResponse} from '../../models/response/creature/creature-item-response';
import {CreatureEquipmentSave} from '../../models/request/creature-equipment-save';

const BASE_URL = 'http://localhost:8080';

@Service()
export class MusteringGroundsApi {

  private readonly http = inject(HttpClient);

  public getCreatureForgeRequiredData() : Observable<CreatureForgeRequiredDataResponse> {
    return this.http.get<CreatureForgeRequiredDataResponse>(`${BASE_URL}/creature/forge-required-data`);
  }

  public getPlayerRequiredData() : Observable<PlayerRequiredDataResponse> {
    return this.http.get<PlayerRequiredDataResponse>(`${BASE_URL}/player/required-data`);
  }

  public getAllCreatures() : Observable<CreatureItemResponse[]>{
    return this.http.get<CreatureItemResponse[]>(`${BASE_URL}/creature`);
  }

  public createCreature(request: CreatureCreateRequest) : Observable<void> {
    return this.http.post<void>(`${BASE_URL}/creature/forge`, request);
  }

  public getCreature(creatureId:number) : Observable<CreatureItemResponse> {
    return this.http.get<CreatureItemResponse>(`${BASE_URL}/creature/${creatureId}`);
  }


  saveEquipment(creatureId : number,equipmentDraft: CreatureEquipmentSave) : Observable<void> {
    return this.http.post<void>(`${BASE_URL}/creature/${creatureId}/equipment`, equipmentDraft);
  }
}
