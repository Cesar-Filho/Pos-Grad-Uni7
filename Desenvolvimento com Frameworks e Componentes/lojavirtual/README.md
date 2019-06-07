# Loja Virtual Com Spring Boot

## Equipe

Cesar Filho

## Forma de Acesso

Vá na pasta raiz com o comando:

- docker build -t loja .
- docker run -p 8080:8080 loja

## Entidades para CRUD

- produtos
- estoque
- pedidos
- clientes
- reposicoes

## Caminhos para acesso URL

**Substitua o '{entidade}' por uma entidade encontrada logo a cima.**

- Listar tudo - GET: http://localhost:8080/api/{entidade}
- Buscar por ID - GET: http://localhost:8080/api/{entidade}/{id}
- Criar - POST: http://localhost:8080/api/{entidade}
- Editar - PUT: http://localhost:8080/api/{entidade}
- Deletar - PUT: http://localhost:8080/api/{entidade}

No caso do pedido tem a URL para finalizar e Cancelar:

- Finalizar - PUT: http://localhost:8080/api/{entidade}/finalizar
- Cancelar - PUT: http://localhost:8080/api/{entidade}/cancelar
