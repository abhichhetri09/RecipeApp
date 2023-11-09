# Recipe Web Application

Welcome to the Recipe Web Application repository. This application is a full-stack solution for users to explore, add, and like different recipes. It is built with Spring Boot and Thymeleaf and deployed at [spyscout.store](http://spyscout.store).

## Features

- View a list of recipes
- Detailed view for each recipe including ingredients and preparation steps
- Add new recipes
- Edit existing recipes
- Delete recipes
- User authentication system
- Like and comment on recipes
- Filter recipes by category

## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database
- Heroku for deployment

## Local Setup

To run this project locally:

1. Clone the repository:

    ```bash
      git clone https://github.com/your-username/recipe-web-app.git

1. Navigate to the project directory:
    ```bash
      cd recipe-web-app

1. Build the project using Maven:
    ```bash
    mvn clean install

1. Run the application:
    ```bash
    mvn spring-boot:run
    
The application will start running on http://localhost:8080.

##Heroku Deployment
This application is deployed on Heroku. If you'd like to deploy your own instance, follow the steps below:

1. Create a Heroku account and log in.
2. Install the Heroku CLI and log in through the terminal.
3. Create a new Heroku app:

    ```bash
      heroku create

4. Push your code to Heroku:
    ```bash
    git push heroku main
    
Access your application through the URL provided by Heroku.

##Contributing
Contributions to the Recipe Web Application are welcome!

Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Make your changes and commit (git commit -am 'Add some feature').
4. Push to the branch (git push origin feature-branch).
5. Open a pull request.

Please ensure your pull request adheres to the following guidelines:

* Keep descriptions short and simple, but descriptive.
* Check your spelling and grammar.

##License
Distributed under the MIT License. See LICENSE for more information.

Contact
Abhishek khati chhetri - abhichhetri@outlook.com

Project Link: https://github.com/abhichhetri09/recipe-web-app

Acknowledgments
Icons8 - https://icons8.com
README Template Inspired by - othneildrew's Best-README-Template
