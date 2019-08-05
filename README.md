# Spring Boot Event Bus

This is a spring boot Java web application which demonstrates
the use of Event bus library to handle different types of payment
transaction events.

## Getting Started

Clone this repository to your local machine and import it into the IDE
as a maven project. Start the spring boot application and navigate to
http://localhost:8080/\<endpoint> to initiate different kind of payment
transactions.

### Prerequisites

You need to have the following software installed to run this project

```
1. Git installed in your machine
2. Java (minimum version 8)
3. Any IDE
4. Maven to build the project
```

### Installing

Below steps will tell how to run the project

Clone the git repository using

```
git clone <link>
```

cd to the downloaded directory and run the below command ot start the project

```
./mvnw spring-boot:run
```

Now navigate to your broswer with the following endpoints

To initiate a cash payment event
```http request
http://localhost/cash
```

To initiate a credit card payment event
```http request
http://localhost/credit
```

To initiate a debit card payment event
```http request
http://localhost/debit
```

To initiate a ideal card payment event
```http request
http://localhost/ideal
```

## Running the tests

Will be added later


## Deployment

To deploy this application using tomcat, run the below commands

```bash
mvn package
```

This will generate the jar package in arget folder. Run it using

```bash
java -jar target/eventbus-0.0.1.jar
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Event Bus](https://github.com/google/guava/wiki/EventBusExplained) - Google Guava Event Bus library to handle events

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Rakesh Venkatesh** - *Initial work* - [rakgenius](https://github.com/rakgenius)


## License

This project is licensed under the Apache License 2.0

