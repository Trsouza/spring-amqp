
# Projeto SpringBoot com RabbitMQ (Em desenvolvimento)

Serviço de mensageria em JAVA. O projeto consiste de uma api produtora e dois serviços consumidores.
- Enquanto a API produtora **"order-service"** envia *"orders"*

## Tecnologias utilizadas

- Java
- SpringBoot
- Mysql
- MongoDB
- RabbitMQ - AMQP 
- Docker


## Execução do projeto

Para instaciar o banco de dados e o RabbitMQ

```bash
  cd spring-amqp
  docker-compose up
```

Para executar a aplicação produtora: Order

```bash
  cd order-service
  mvnw.cmd spring-boot:run
```

Para executar a aplicação consumidora: Cashback

```bash
  cd cashback-service
  mvnw.cmd spring-boot:run
```

Para executar a aplicação consumidora: Notification

```bash
  cd notification-service
  mvnw.cmd spring-boot:run
```
## Documentação da API

#### Retorna uma ordem

```http
  GET /v1/orders/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID da ordem buscada. |

#### Edita uma ordem

```http
  PUT /v1/orders/${id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Obrigatório**. O ID da ordem que será atualizada como paga. |

#### Cria uma ordem

```http
  POST /v1/orders
```

| Payload   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `value` | `BigDecimal` | Valor da ordem. |

### O RabbitMQ está disponível na porta 15672
    http://localhost:15672

- User: rabbitmq
- Password: rabbitmq

### O phpMyAdmin está disponível na porta 8085
    http://localhost:8085

- User: root
- Password: 123

### O Mongo Express está disponível na porta 8081, o banco "mydb" é criado após o primeiro post. Esse post ocorre após o recebimento de uma msg específica via rabbitMQ, a msg consiste em uma "order" que foi paga, que posteriormente gera um "cashback"
    http://localhost:8081

- User: root
- Password: 123

