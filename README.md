
# Projeto SpringBoot com RabbitMQ

Serviço de mensageria em JAVA. O projeto consiste de uma api produtora e dois serviços consumidores.


## Tecnologias utilizadas

- Java
- SpringBoot
- Mysql
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

#### Retorna um item

```http
  GET /v1/orders/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID da ordem buscada. |


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

#### Edita uma ordem



## O RabbitMQ está disponível na porta 15672 e pode ser acessado utilizando as credencias descritas abaixo
    http://localhost:15672

- User: rabbitmq
- Password: rabbitmq
  
  

