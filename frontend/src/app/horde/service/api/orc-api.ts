import {inject, Service} from '@angular/core';
import {HordeCreateRequest} from '../../page/horde-create/models/horde-create-request';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

const BASE_URL = 'http://localhost:8080/api/horde';

@Service()
export class OrcApi {

  private readonly http = inject(HttpClient);

  createHorde(request: HordeCreateRequest) : Observable<void>{
    return this.http.post<void>(BASE_URL,request)
  }

}
