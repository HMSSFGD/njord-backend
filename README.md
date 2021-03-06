# Njord backend
The backend for our entry into the [CSSxBoeing Life underwater hackathon 2021](https://cssbristol.co.uk/events/2021-03-20_boeing_hackathon/)

We entered into the *Communication* category

## Contributors
- [Daniel Jones](https://github.com/danjones1618)
- [Ralph Roberts](https://github.com/KingGax)
- [Rob Russman](https://github.com/orgs/HMSSFGD/people/Noobphail)
- [Viktor Kusheliev](https://github.com/orgs/HMSSFGD/people/vic-kush)
- [Bogdan Dumitrescu](https://github.com/orgs/HMSSFGD/people/bogdumi)
- [Tymoteusz Suszczynski](https://github.com/orgs/HMSSFGD/people/TiPEX360)

# njord project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/njord-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- REST Client ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Undertow WebSockets ([guide](https://quarkus.io/guides/websockets)): WebSocket communication channel support
- Security JPA ([guide](https://quarkus.io/guides/security-jpa)): Secure your applications with username/password stored in a database via JPA

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
