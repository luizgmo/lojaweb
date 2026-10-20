import { ProdutoService } from './../produto-service';
import { Component, inject } from '@angular/core';
import { Produto } from '../produto';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css',
})
export class ProductList {
  produtoService: ProdutoService = inject(ProdutoService);
  protected produtos$: Observable<Produto[]>;

  constructor() {
    this.produtos$ = this.produtoService.getAllProducts();
  }
}
