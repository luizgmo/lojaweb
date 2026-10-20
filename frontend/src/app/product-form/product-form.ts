import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';

import { ProdutoService } from '../produto-service';

@Component({
  selector: 'app-product-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './product-form.html',
  styleUrl: './product-form.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProductForm {
  private readonly fb = inject(FormBuilder);
  private readonly produtoService = inject(ProdutoService);
  private readonly router = inject(Router);
  private readonly route = inject(ActivatedRoute);
  protected readonly id = Number(this.route.snapshot.paramMap.get('id'));

  protected readonly editing = this.id > 0;
  protected readonly loading = signal(this.editing);
  protected readonly saving = signal(false);
  protected readonly error = signal<string | null>(null);

  protected readonly form = this.fb.nonNullable.group({
    descricao: ['', [Validators.required, Validators.minLength(3)]],
    preco: [0, [Validators.required, Validators.min(0.01)]],
  });

  constructor() {
    if (!this.editing) {
      return;
    }

    this.produtoService.getProductById(this.id).subscribe({
      next: (produto) => {
        this.form.setValue({ descricao: produto.descricao, preco: produto.preco });
        this.loading.set(false);
      },
      error: () => {
        this.error.set('Não foi possível carregar o produto.');
        this.loading.set(false);
      },
    });
  }

  protected submit(): void {
    if (this.form.invalid || this.saving()) {
      this.form.markAllAsTouched();
      return;
    }

    this.saving.set(true);
    this.error.set(null);

    const dados = this.form.getRawValue();
    const request = this.editing
      ? this.produtoService.updateProduct(this.id, dados)
      : this.produtoService.createProduct(dados);

    request.pipe(finalize(() => this.saving.set(false))).subscribe({
      next: (produto) =>
        this.router.navigate(this.editing ? ['/produtos', produto.id] : ['/produtos']),
      error: () => this.error.set('Não foi possível salvar o produto. Tente novamente.'),
    });
  }
}
