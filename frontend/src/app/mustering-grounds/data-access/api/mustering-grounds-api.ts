import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CreatureForgeRequiredDataResponse} from '../../models/response/creature/creature-forge-required-data-response';
import {CreatureCreateRequest} from '../../models/request/CreatureCreateRequest';

const BASE_URL = 'http://localhost:8080/creature';

@Service()
export class MusteringGroundsApi {

  private readonly http = inject(HttpClient);

  public getCreatureForgeRequiredData() : Observable<CreatureForgeRequiredDataResponse> {
    return this.http.get<CreatureForgeRequiredDataResponse>(`${BASE_URL}/forge-required-data`);
  }

  public createCreature(request: CreatureCreateRequest) : Observable<void> {
    return this.http.post<void>(`${BASE_URL}/forge`, request);
  }

}
