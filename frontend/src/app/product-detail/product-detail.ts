import { CurrencyPipe } from '@angular/common';
import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

import { Produto } from '../produto';
import { ProdutoService } from '../produto-service';

@Component({
  selector: 'app-product-detail',
  imports: [RouterLink, CurrencyPipe],
  templateUrl: './product-detail.html',
  styleUrl: './product-detail.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProductDetail {
  private readonly produtoService = inject(ProdutoService);
  private readonly route = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly id = Number(this.route.snapshot.paramMap.get('id'));

  protected readonly produto = signal<Produto | null>(null);
  protected readonly loading = signal(true);
  protected readonly error = signal<string | null>(null);

  constructor() {
    if (!this.id) {
      this.loading.set(false);
      this.error.set('Produto não encontrado.');
      return;
    }

    this.produtoService.getProductById(this.id).subscribe({
      next: (produto) => {
        this.produto.set(produto);
        this.loading.set(false);
      },
      error: () => {
        this.error.set('Não foi possível carregar o produto.');
        this.loading.set(false);
      },
    });
  }

  protected remove(): void {
    const produto = this.produto();
    if (!produto || !confirm(`Excluir "${produto.descricao}"?`)) {
      return;
    }

    this.produtoService.deleteProduct(produto.id).subscribe({
      next: () => this.router.navigate(['/produtos']),
      error: () =>
        this.error.set('Não foi possível excluir o produto. Ele pode estar em um pedido.'),
    });
  }
}
