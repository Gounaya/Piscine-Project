Project done with GOUNAYA Oussama & Errami Abdeljalil 
Group-4
You will find attached the complete project with code java, JUnit tests and UML.

# Project Swimming Pool

### 1- Deposit recovery : 
    git pull
### 2- Generate the javadoc :
    mvn javadoc:javadoc
### 3- Generate project : 
    mvn package
### 4- Execute Project : 
    java jar target/COO-Piscine-1.0-SNAPSHOT.jar
    
#### Description of the project : 
    - this application is a shared resource usage simulation app known as the pool probleme.
    
    - That every swimmer should want to access the pool must do these steps: 
    1- Take a basket
    2- Go to a cubicle
    3- To undress
    4- Release the cubicle
    5- Swim
    6- Find a cubicle
    7- Get dressed
    8- Release his cubicle
    9- Return his basket
    10- Go out 
    
    - For one swimmer it's easy to do because the person finds an available basket and cabins too. So he's waiting for no one.
    Each swimmer is characterized by : Name, basket, cubicle, time to undress, swimming time and time to get dressed.
    
    - For this problem we have different swimmers with different actions and that's what makes the problem difficult, so we will need a FairScheduler that deals with different swimmers to produce the simulation of the operation of a pool. Also each swimmer considered as a sequentialScheduler and had different actions so that the ForeseeabeleScheduler can manage all of them.
    
#### Design pattern use it in this project : 
    - Template method
