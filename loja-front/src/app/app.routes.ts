import { Routes } from '@angular/router';

import { CustomerList } from './customer-list/customer-list';
import { Home } from './home/home';
import { ProductForm } from './product-form/product-form';
import { ProductList } from './product-list/product-list';

export const routes: Routes = [
  {
    path: '',
    component: Home,
  },
  {
    path: 'produtos',
    component: ProductList,
  },
  {
    path: 'produtos/novo',
    component: ProductForm,
  },
  {
    path: 'clientes',
    component: CustomerList,
  },
];
