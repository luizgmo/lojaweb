import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { Cliente } from '../cliente';
import { ClienteService } from '../cliente-service';

@Component({
  selector: 'app-customer-list',
  imports: [CommonModule],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.css',
})
export class CustomerList {
  private readonly clienteService = inject(ClienteService);
  protected readonly clientes$: Observable<Cliente[]> = this.clienteService.getAllClientes();
}
