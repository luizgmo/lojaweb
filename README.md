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
| DELETE | `/api/produto/{id}`  | Remove produto       |
| GET    | `/api/cliente`       | Lista clientes       |
| POST   | `/api/cliente`       | Cria cliente         |
| GET    | `/api/cliente/{id}`  | Busca cliente por ID |
| DELETE | `/api/cliente/{id}`  | Remove cliente       |

## Front end

```sh
cd frontend
npm install
npm start
```

Aplicação em <http://localhost:4200>.

## Testes

```sh
cd backend && ./gradlew test
cd frontend && npm test
```
