import { Routes } from '@angular/router';

import { CustomerDetail } from './customer-detail/customer-detail';
import { CustomerForm } from './customer-form/customer-form';
import { CustomerList } from './customer-list/customer-list';
import { Home } from './home/home';
import { OrderDetail } from './order-detail/order-detail';
import { OrderList } from './order-list/order-list';
import { ProductDetail } from './product-detail/product-detail';
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
    path: 'produtos/:id/editar',
    component: ProductForm,
  },
  {
    path: 'produtos/:id',
    component: ProductDetail,
  },
  {
    path: 'clientes',
    component: CustomerList,
  },
  {
    path: 'clientes/novo',
    component: CustomerForm,
  },
  {
    path: 'clientes/:id/editar',
    component: CustomerForm,
  },
  {
    path: 'clientes/:id',
    component: CustomerDetail,
  },
  {
    path: 'pedidos',
    component: OrderList,
  },
  {
    path: 'pedidos/:id',
    component: OrderDetail,
  },
  {
    path: '**',
    redirectTo: '',
  },
];
