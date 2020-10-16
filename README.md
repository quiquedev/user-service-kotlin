# User Service API

## API Documentation

You can find it [here](https://editor.swagger.io/?url=https%3A%2F%2Fraw.githubusercontent.com%2Fquiquedev%2Fuser-service%2Fmaster%2Fopenapi.yaml).

## Local run

### Requirements

You must have [docker-compose](https://docs.docker.com/compose/install) installed in your machine.

### How To

```
git clone git@github.com:quiquedev/user-service-kotlin.git
cd user-service-kotlin
docker-compose up --build
```

The service will be listening on the port `8080`.

## About

### Technologies

#### Language

#### Libraries

* [flyway](https://flywaydb.org) for database version control


#### Persistence

[PostgreSQL](https://www.postgresql.org) is the storage type I decided to use so that we could have:

* normalized data
* version control
* json support

#### API 
## Code
### [Tagless final](https://scalac.io/tagless-final-pattern-for-scala-code)

### Simplified [Entity-control-boundary](https://en.wikipedia.org/wiki/Entity-control-boundary)

Each endpoint uses exclusively an [use case](src/main/scala/info/quiquedev/userservice/usecases/UserUsecases.scala) 
which encapsulate the required business logic.
The relation *endpoint-use_case* is `1:1` with the purpose of introducing orthogonality to totally decouple business use cases.

### [Data Transfer Object](https://en.wikipedia.org/wiki/Data_transfer_object)
 
*DTO* and [data model](https://en.wikipedia.org/wiki/Data_model) are completely separated but still keep an almost `1:1` relationship,
i.e. for the representation of an `User` we have the [DTO](src/main/scala/info/quiquedev/userservice/routes/dtos/UserDto.scala)
and its corresponding [data model](src/main/scala/info/quiquedev/userservice/usecases/model/User.scala).

This design allow us to decouple the [service domain](https://en.wikipedia.org/wiki/Domain-driven_design) from the data model.

## Test Coverage

### How To


### Current Coverage
* [Statement coverage](https://www.zyxware.com/articles/4161/what-is-statement-coverage-in-testing):  **89.07%** 
* [Branch coverage](https://www.cs.odu.edu/~cs252/Book/branchcov.html): **100%**




