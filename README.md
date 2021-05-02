Oompa Loompa Service

## API: Spring boot + PostgreSQL + Docker

This is a personal API web service to get a counter about Oompa Loompa, how many of they are, its name, age, job and so.

##Dependencies:
- Docker: https://docs.docker.com/get-docker/
- Docker Compose: https://docs.docker.com/compose/install/

## Run
To boot the project just open a Terminal Emulator and put the prompt in the source directory and run the command: ```docker-compose up``` just where the ```docker-compose.yml``` field is.
It will start two containers that ones is the database, and the other one is the application.
- Database: PostgreSQL => 13.1, named 'db' 
- Application: SpringBoot => 2.2.3.RELEASE, named 'oompaLoompa'

When the docker starts the database will be populated with some dummy data. 
For more info just take a look:
- ```db/init.sh```
- ```docker-compose.yaml => services/db/volumes```

## How to use it
The endpoints of this API are:
- **GET /public/v1/oompas**: To get a list of Oompa Loompa, a basic list with the basic data such as: *name*, *job* and *age*.
- **GET /public/v1/oompas/details**: To get a detailed list of Oompa Loompa.
- **GET /public/v1/oompas/{id}**: To get a specific oompa loompa using the id. 
- **POST /public/v1/oompas**: To add a new oompa loompa.
- **PUT /public/v1/oompas/{id}**: To update an existing oompa loompa.
