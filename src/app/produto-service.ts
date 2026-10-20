import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Produto } from './produto';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private readonly url = 'http://localhost:8080/api/produto';
  private readonly http = inject(HttpClient);

  getAllProducts(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.url);
  }

  createProduct(produto: Omit<Produto, 'id'>): Observable<Produto> {
    return this.http.post<Produto>(this.url, produto);
  }
}
