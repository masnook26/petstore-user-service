# User Service

## Utilizando Scripts SQL

### Listar todos os usuários

Listar todos os usuários ordenados pelo ID

```sql
SELECT *
FROM users
ORDER BY id;
```

### Buscar usuário pelo username

**Busca exata**

```sql
SELECT *
FROM users
WHERE username = :username;

-- Exemplo:
SELECT *
FROM users
WHERE username = 'juliane';
```

**Parcial (LIKE)**

```sql
SELECT *
FROM users
WHERE username ILIKE '%' || :username || '%';

-- Exemplo:
SELECT *
FROM users
WHERE username ILIKE '%' || 'ad' || '%';
```

### Buscar usuário pelo email

**Exato**

```sql
SELECT id,
       username,
       email,
       first_name,
       last_name,
       phone_number,
       user_status
FROM users
WHERE email = :email;
```

**Parcial (LIKE)**

```sql
SELECT *
FROM users
WHERE email ILIKE '%' || :email || '%';
```

### Buscar usuário por username OU email

**Muito comum em login/autenticação:**

```sql
SELECT id,
       username,
       email,
       first_name,
       last_name,
       phone_number,
       user_status
FROM users
WHERE username = :login
   OR email = :login;
```

### Buscar usuário ativo (exemplo com `user_status`)

**Supondo:**

- `1 = ATIVO`
- `O = INATIVO`

```sql
SELECT *
FROM users
WHERE user_status = 1;
```

---

## Usando Postman (cURL)

### Cadastrar Usuário

- `POST /users`

**Request**

```
```

**Response**

- Status: `201 CREATED`

```
```

### Buscar Usuário

- `GET /users/{username}`

**Request**

```
http://localhost:8080/user/admin
```

**Response**

- Status: `200 OK`

```json
{
  "id": 2,
  "username": "admin",
  "firstName": "Admin",
  "lastName": "System",
  "email": "admin@petstore.com",
  "phoneNumber": "11000000000",
  "userStatus": 1
}
```

### Atualizar Usuário

- `PUT /users/{username}`

**Request**

```
```

**Response**

- Status: `200 OK`

```
```

### Excluir Usuário

- `DELETE /users/{username}`

**Request**

```
```

**Response**

- Status: `204 No Content`

```
```

---

## Boas Práticas

### DTO de Entrada (Request)

- Responsável **somente** pelos dados que o cliente pode enviar.
- Cliente **não envia `id`**.
- Cliente **não define `userStatus`**.
- Validações já protegem a API

### Service - Regras de Negócio

- Uso do `@Transactional`
- Service NÃO retorna entidade
- Regras de unicidade centralizadas
- Conversão Entity → DTO isolada

### Controller - API REST

- Responsável **apenas** por entrada/saída HTTP.

---

## Melhorias Futuras

- Adicionar `@RestControllerAdvice` com erros padronizados
- Enum `UserStatus`
- MapStruct
- Swagger / OpenAPI
- Testes Unitários (`@WebMvcTest` / `@DataJpaTest` / `@Testcontainers`)
- DDD
- CQRS
- Elasticsearch para buscar usuários por `username`