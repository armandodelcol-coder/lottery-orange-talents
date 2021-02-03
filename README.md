# Orange Talents Challenge

Esse projeto foi desenvolvido para implementar um desafio proposto pelo programa de recrutamento da empresa Zup.

## Contexto

O projeto é uma API REST que simula um sistema de apostas e fornece 2 endpoints.

Um para cadastrar uma aposta enviando um email do concorrente.

E outro para listar as apostas de um concorrente.

## Tecnologias utilizadas

- Java 11
- Spring Boot (Spring Boot Web, Spring Data JPA)
- H2 Database
- Intellij IDE Community Edition

## Executar a Aplicação

Para executar a aplicação, faça um clone do projeto.

Tenha instalado e configurado o JDK 11, rode o projeto através da classe `src/main/LotteryApiApplication`.

Para acessar o Banco de dados H2, visite `http://localhost:8080/h2-console` (as configurações delogin estão em `resources/application-test.properties`)

## Utilizando os endpoints

`http://localhost:8080/lottery_tickets`:
JSON BODY:
```json
{
  "bettor": {
    "email": "bettor1@gmail.com"
  }
}
```
Resposta:
```json
{
  "id": 5,
  "bet1": 44,
  "bet2": 86,
  "bet3": 68,
  "bet4": 72,
  "bettor": {
    "id": 1,
    "email": "bettor1@gmail.com"
  }
}
```

E um GET:

`http://localhost:8080/lottery_tickets`:
JSON BODY
```json
{
  "bettor": {
    "email": "bettor1@gmail.com"
  }
}
```
Resposta:
```json
[
  {
    "id": 5,
    "bet1": 44,
    "bet2": 86,
    "bet3": 68,
    "bet4": 72,
    "bettor": {
      "id": 1,
      "email": "bettor1@gmail.com"
    }
  },
  {
    "id": 4,
    "bet1": 13,
    "bet2": 62,
    "bet3": 78,
    "bet4": 1,
    "bettor": {
      "id": 1,
      "email": "bettor1@gmail.com"
    }
  }
]
```