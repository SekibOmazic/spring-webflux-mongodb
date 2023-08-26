
## spring-webflux-mongodb

User service for Spring Data Reactive MongoDB with Spring Webflux (Functional Endpoints)


### Prerequisites
* JDK 11+
* Docker or MongoDB installed


Examples

* Mono, Flux structures
* Functional Reactive Endpoints
* WebTestClient
* Spring Data Mongo Reactive


**Running the Database**

Type the following command in your terminal to run the database -

     docker-compose up -d


**Running the App**

Type the following command in your terminal to run the app -

     ./gradlew bootRun

The app will start running at  [http://localhost:8088](http://localhost:8088/).


**Running the Tests**

Type the following command in your terminal to run the tests -

     ./gradlew test


<code>  


     ### 
     GET http://localhost:8088/api/v1/users
      
     ###    
     POST http://localhost:8088/api/v1/users    
     Content-Type: application/json  
      
     {    
     "name": "Sekib",    
     "score": 88    
     }  
      
     ###    
     PUT http://localhost:8088/api/v1/users/61ec13ca48d46147479f8fcd    
     Content-Type: application/json  
     
     {    
     "name": "Sekib Dev",    
     "score": 55    
     }  

     ###
     GET http://localhost:8088/api/v1/users/61ec13ca48d46147479f8fcd
     
     ###
     DELETE http://localhost:8088/api/v1/users/61ec13ca48d46147479f8fcd  
     
     ###    
     DELETE http://localhost:8088/api/v1/users?name=Sekib  

</code>
