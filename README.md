# Loja Web

Aplicação de loja com back end Spring Boot e front end Angular, organizados em um monorepo.

## Estrutura

```
.
├── backend/    # Spring Boot (Java 21, Spring Data JPA, MySQL)
└── frontend/   # Angular 21 (standalone components, Vitest)
```

## Back end

Requisitos: Java 21 e MySQL em `localhost:3307`, base `loja`.

```sh
cd backend
./gradlew bootRun
```

Para recriar e popular o banco (com o MySQL já em execução):

```sh
cd backend
./database-reset.sh
```

API em <http://localhost:8080>.

### Endpoints

| Método | Rota                 | Descrição            |
| ------ | -------------------- | -------------------- |
| GET    | `/api/produto`       | Lista produtos       |
| POST   | `/api/produto`       | Cria produto         |
| GET    | `/api/produto/{id}`  | Busca produto por ID |
| PUT    | `/api/produto/{id}`  | Atualiza produto     |
| DELETE | `/api/produto/{id}`  | Remove produto       |
| GET    | `/api/cliente`       | Lista clientes       |
| POST   | `/api/cliente`       | Cria cliente         |
| GET    | `/api/cliente/{id}`  | Busca cliente por ID |
| PUT    | `/api/cliente/{id}`  | Atualiza cliente     |
| DELETE | `/api/cliente/{id}`  | Remove cliente       |
| GET    | `/api/pedido`        | Lista pedidos        |
| GET    | `/api/pedido/{id}`   | Detalha pedido       |

## Front end

```sh
cd frontend
npm install
npm start
```

Aplicação em <http://localhost:4200>.

### Funcionalidades

- Produtos: listar, detalhar, criar, editar e excluir
- Clientes: listar, detalhar, criar, editar e excluir
- Pedidos: listar e detalhar itens, quantidades, preços e total
- Valores em BRL e datas no formato pt-BR

## Testes

```sh
cd backend && ./gradlew test
cd frontend && npm test
```
