# BPDTSOnlineTechnicalTest
# bpdts-test

Sping Boot application that calls an API and returns all users who are listed as either living in London, or whose current coordinates are within 50 miles of London.

## Software used

london-users is written in Java 8 using Spring Boot and makes use of [Lucene](https://lucene.apache.org/core/8_3_0/core/org/apache/lucene/util/SloppyMath.html) libraries.

## Running the application locally

The source code of the application can be directly pulled into an IDE (e.g. IntelliJ, Eclipse) and run locally from inside there.

After the application is running, (assuming the application is running on localhost and poost 8080) simply make a GET request to http://localhost:8080/bpdts/results. 
This will return all users either listed as being from London or whose longitude and latitude place them within 50 miles of London. 

## Consuming the API
If you want to consume the API, please see the [swagger.yaml file](https://github.com/mohanamalini/bpdts-test/src/main/resources/swagger.yaml) of this project. 
This includes details of the API, such as the endpoint of the API, a definition of the output of the API and a definition of the user object.

## How the application works

The application returns the expected user list by first calling the downstream API using the path /city/London/users and then calling /users to get all users and filters to those within 50 miles of London based off their longitude and latitude. 

To determine users based within 50 miles of London, the [Haversine Method](https://en.wikipedia.org/wiki/Haversine_formula) has been used, specifically [lucene-solr](https://github.com/apache/lucene-solr/blob/master/lucene/core/src/java/org/apache/lucene/util/SloppyMath.java). 
The reasons for this choice are explained below in the assumptions.

## Assumptions
- "50 miles from London" was assumed to mean 50 miles from the centre of London. And the centre of London was taken from Google Maps as being `51.5074° N, 0.1278° W`.
- [Haversine](https://en.wikipedia.org/wiki/Haversine_formula) was used to calculate the distance betweeen long lat points as it has better accuracy over shorter distances than some other techniques.
