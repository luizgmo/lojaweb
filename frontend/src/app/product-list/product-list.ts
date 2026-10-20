import { CurrencyPipe } from '@angular/common';
import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { RouterLink } from '@angular/router';

import { Produto } from '../produto';
import { ProdutoService } from '../produto-service';

@Component({
  selector: 'app-product-list',
  imports: [RouterLink, CurrencyPipe],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProductList {
  private readonly produtoService = inject(ProdutoService);

  protected readonly produtos = signal<Produto[]>([]);
  protected readonly loading = signal(true);
  protected readonly error = signal<string | null>(null);

  constructor() {
    this.load();
  }

  protected load(): void {
    this.loading.set(true);
    this.error.set(null);

    this.produtoService.getAllProducts().subscribe({
      next: (produtos) => {
        this.produtos.set(produtos);
        this.loading.set(false);
      },
      error: () => {
        this.error.set('Não foi possível carregar os produtos.');
        this.loading.set(false);
      },
    });
  }

  protected remove(produto: Produto): void {
    if (!confirm(`Excluir "${produto.descricao}"?`)) {
      return;
    }

    this.produtoService.deleteProduct(produto.id).subscribe({
      next: () => this.load(),
      error: () =>
        this.error.set('Não foi possível excluir o produto. Ele pode estar em um pedido.'),
    });
  }
}
