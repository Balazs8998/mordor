import {inject, Service} from '@angular/core';
import {OrcCreateRequest} from '../../page/orc-create/models/request/orc-create-request';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {OrcCreateRequiredData} from '../../page/orc-create/models/response/orc-create-required-data';
import {OrcListResponse} from '../../page/orc-list/models/response/orc-list-response';

const BASE_URL = 'http://localhost:8080/api/orc';

@Service()
export class OrcApi {

  private readonly http = inject(HttpClient);

  createOrc(request: OrcCreateRequest): Observable<void> {
    return this.http.post<void>(`${BASE_URL}/create`, request);
  }

  getCreateOrcRequiredData() : Observable<OrcCreateRequiredData> {
    return this.http.get<OrcCreateRequiredData>(`${BASE_URL}/required-data`);
  }

  getAllOrcs() : Observable<OrcListResponse[]> {
    return this.http.get<OrcListResponse[]>(BASE_URL);
  }
  deleteOrc(id:number){
    return this.http.delete<void>(`${BASE_URL}/delete/${id}`);
  }

  getOrc(id:number){
    return this.http.get<OrcListResponse>(`${BASE_URL}/${id}`);
  }

}
