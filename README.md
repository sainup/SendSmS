# SendSmS
It is a web app created for me to send text to my friends around the world.
It uses Twilio SMS API, Spring, Java in the backend and Thymeleaf for simple UI for the app.
MySql is used as a database for storage.

The account used for the API is in trail period. So, It can only send message to the numbers that are verified
in the account.

See live demo <a  href="http://ec2-54-93-117-77.eu-central-1.compute.amazonaws.com:8081/" target="_blank">here</a>.

## Table of contents
* [Technologies](#technologies)
* [Setup](#setup)


## Technologies
* Java 11
* Spring boot 2.3.1.RELEASE
* Apache Maven 3.6.3
* Twilio 7.53.0
* MySql

## Setup
These instructions will get you a copy of the project up and running on your local machine for development
and testing purposes. 

### Prerequisites
* git@2.17.1 or higher
* maven@3.6.3 or higher


### How to Use
From your command line, first clone SendSms : 

* git clone https://github.com/sainup/SendSmS.git or Download Zip from github
* Make a schema named "your choice" in MySql for the app
  
You need to open the project in your IDE and follow the steps below:

* Go to src/main/resources and open application.properties
* Insert your database url in spring.datasource.url
* Insert your database username and password in spring.datasource.username and spring.datasource.password respectively

Make a twilio account at https://www.twilio.com/try-twilio if you don't have any.
Get your AccountSid and Authtoken. Get a Phone number(trial works) and follow the steps below: 
* In application.properties insert the above mentioned details in the respective fields

Run the app through IDE or from command line using mvn spring-boot:run

Open localhost:8080/sendSms and you have it up and running.














