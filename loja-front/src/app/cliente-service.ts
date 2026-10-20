import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Cliente } from './cliente';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private readonly url = 'http://localhost:8080/api/cliente';
  private readonly http = inject(HttpClient);

  getAllClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url);
  }
}
