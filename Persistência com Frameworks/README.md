**Persistência com Frameworks**

- [Bancario](bancario)

  - Trabalho tem como objetivo explorar a utilização e entendimento da camada de persistência de uma aplicação, no projeto em questão se utilização em questão hikari, conexão com um banco de dados mysql, data jpa e hibernate. Sendo assim, é explorando a utilização de anotações e funções para estabelecer uma estrutura ao banco de dados e sua consistência
  - Exemplos: @Verson, @Lock, @OneToOne, @OneToMany, @ManyToOne, @Transicional, @Entity, @Where, @JoinColumn, @ForeignKey, @SQLDelete e etc...
  - Observação: Como objetivo secundário foi tentado mostrar como essas anotações afetaria o uso de uma api, tal tópico não está dentro do escopo aguentado no trabalho em questão.

#### Entidades para CRUD

- agencias
- clientes
- contas
- movimentacoes

#### Caminhos para acesso URL

**Substitua o '{entidade}' por uma entidade encontrada logo a cima.**

- Listar tudo - GET: http://localhost:8080/api/{entidade}
- Buscar por ID - GET: http://localhost:8080/api/{entidade}/{id}
- Criar - POST: http://localhost:8080/api/{entidade}
- Editar - PUT: http://localhost:8080/api/{entidade}
- Deletar - PUT: http://localhost:8080/api/{entidade}

No caso de movimentações tem as URL's para buscar específica:

- Por Cliente - GET: http://localhost:8080/api/movimentacoes/por-cliente
- Por Agência - GET: http://localhost:8080/api/movimentacoes/por-agencia
- Por Periodo - GET: http://localhost:8080/api/movimentacoes/por-perido

```
  {
  "dataInicial": "2019-05-01",
  "dataFinal": "2019-05-31"
  }
```

No caso de gerar um transferência entre contas:

- Transferência - POST: http://localhost:8080/api/movimentacoes/transferencia

```
  {
  "remetente": {"id": 1},
  "destinatario": {"id": 2},
  "destinatario": {"id": 2},
  "agenciaRemetente": {"id": 1},
  "agenciaDestinatario": {"id": 2},
  "contaRemetente": {"id": 1},
  "contaDestinatario": {"id": 2},
  "valor": 100
  }
```
