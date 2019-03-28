# ViewTheQueue
A REST service for getting wait times and other information about Attractions, Restaurants and Shows at a Theme Park Resort.

Master: [![Build Status](https://travis-ci.com/JamesHare/ViewTheQueue.svg?branch=master)](https://travis-ci.com/JamesHare/ViewTheQueue)

Code Coverage: [![Coverage Status](https://coveralls.io/repos/github/JamesHare/ViewTheQueue/badge.svg)](https://coveralls.io/github/JamesHare/ViewTheQueue)

# Author
James Hare

Email: harejamesm@gmail.com

LinkedIn: https://www.linkedin.com/in/jameshareuk

# Setup
To run the project, complete the following steps:

1. Install and start MySQL service. A helpful guide can be found [here](https://dev.mysql.com/doc/mysql-getting-started/en/) to accomplish this step.

2. Run the following command in your git bash to clone the project to a directory on the machine where you want to run the REST service:
```bash
git clone https://github.com/JamesHare/ViewTheQueue.git
```

3. Navigate to *configuration/config.properties* and enter the credentials to login to your MySQL instance.

For example:

```
DBUser=root
DBPassword=password
```

4. Run the following command to build and run the REST service:

```bash
mvn clean install && java -jar target/ViewTheQueue-1.0-SNAPSHOT.jar
```

# Usage
The View The Queue REST service is configured to automatically set up a database and populate it with data.
If you would like to add more data, you could use a client such as MySQL Workbench to execute Insert statements
against the database.

The table structures are as follows:

## Attractions Table

```sql
attraction_name varchar(60) NOT NULL,
description varchar(120),
park_name varchar(32) NOT NULL,
area varchar(32) NOT NULL,
operation_status varchar(6) NOT NULL,
opening_time time,
closing_time time,
wait_time int NOT NULL,
max_height_restriction_inches int,
min_height_restriction_inches int,
is_wheelchair_accessible bit(1) NOT NULL,
has_express_line bit(1) NOT NULL,
has_single_rider bit(1) NOT NULL,
primary key (attraction_name, park_name));
```

## Restaurants Table

```sql
restaurant_name varchar(32) NOT NULL,
description varchar(120),
park_name varchar(32) NOT NULL,
area varchar(32) NOT NULL,
operation_status varchar(6) NOT NULL,
opening_time time,
closing_time time,
serves_vegetarian bit(1) NOT NULL,
serves_vegan bit(1) NOT NULL,
primary key (restaurant_name, park_name));
```

## Shows Table

```sql
show_name varchar(32) NOT NULL,
description varchar(120),
park_name varchar(32) NOT NULL,
area varchar(32) NOT NULL,
operation_status varchar(6) NOT NULL,
is_wheelchair_accessible bit(1) NOT NULL,
has_express_line bit(1) NOT NULL,
show_times varchar(70),
primary key (show_name, park_name));
```

## Parks Table

```sql
park_name varchar(32) NOT NULL,
description varchar(120),
operation_status varchar(6) NOT NULL,
opening_time time,
closing_time time,
primary key (park_name)
```

Once you have inserted extra data, if any, you can make a RESTful call to the database using the following parameters
for each object.

*Note: for the purposes of an example, we will be using localhost as the hostname. In reality, this can be
set up to run on a different host and referenced by that hostname.*

## Attraction

### Request Mapping:

/attraction

### Available Parameters:

*attractionname* - The name of an attraction.

*parkname* - The name of the park in which the attraction is located.

*area* - The name of the area in which the attraction is located.

*operationstatus* - The operation status of the attraction. Can be Open or Closed.

*isWheelchairaccessible* - The wheelchair accessibility of the attraction. Can be true or false.

*hasexpressline* - The express line availability of the attraction. Can be true or false.

*hassingleriderline* - The single rider line availability of the attraction. Can be true or false.


### Examples:

```
http://localhost:8080/attraction?name=Rainforest%20Trails&operationstatus=open

http://localhost:8080/attraction?wheelchairaccessible=true&singleriderline=false

http://localhost:8080/attraction?parkname=Animal%20World
```


## Restaurant

### Request Mapping:

/restaurant

### Available Parameters:

*restaurantname* - The name of a restaurant.

*parkname* - The name of the park in which the restaurant is located.

*area* - The name of the area in which the restaurant is located.

*operationstatus* - The operation status of the restaurant. Can be Open or Closed.

*servesvegetarian* - The vegetarian status of the restaurant. Can be true or false.

*servesvegan* - The vegan status of the restaurant. Can be true or false.

### Examples:

```
http://localhost:8080/restaurant?name=The%20Stomping%20Saloon

http://localhost:8080/restaurant?operationstatus=open&servesvegetarian=true

http://localhost:8080/restaurant?parkname=Animal%20World
```