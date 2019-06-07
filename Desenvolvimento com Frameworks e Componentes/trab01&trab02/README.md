# Loja Virtual

## Equipe

Cesar Filho

## Forma de Acesso

Vá na pasta raiz com o comando:

- docker build -t loja .
- docker run -p 9990:9990 -p 8080:8080 loja

wildfly vai subir na porta 9990 e aplicação na porta 8080(padrão)
raiz : localhost:8080/web

## Caminhos para acesso URL

- GET: http://localhost:8080/web/estoque/listar
- GET: http://localhost:8080/web/carrinho/listar
- POST: http://localhost:8080/web/carrinho/adicionar

  **Exemplo 1 :**

```
  {
  "id": 0,
  "produto": {
  "id": 1,
  "descricao": "Produto 01",
  "precoVenda": 2.3
  },
  "quantidade": 5
  }
```

**Exemplo 2 :**

```
  {
  "id": 1,
  "produto": {
  "id": 2,
  "descricao": "Produto 02",
  "precoVenda": 3.3
  },
  "quantidade": 23
  }
```

- POST: http://localhost:8080/web/carrinho/finalizar

## OBSERVAÇÕES

- Quando a quantidade é abaixo ou 0 o pedido vai para aumentar a quantidade novamente para 10 (estoque inicial)
- Cada projeto tem seu próprio dockerfile porém na raiz o dockerfile faz os projetos subir para mesma imagem junto. Caso queira subir os projetos seperados reveja como está configurado já que cada projeto procurará filas(ActiveMQ) feito pelo outro projeto.
