# Authentication with BCrypt 

This is a simple web application that demonstrates user authentication using BCrypt encryption in a Java Spring Boot application. Users can sign up, sign in, add posts, and log out.

## Getting Started

Add these Dependencies : 
```
   dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        developmentOnly 'org.springframework.boot:spring-boot-devtools'
        runtimeOnly 'org.postgresql:postgresql'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        implementation "org.mindrot:jbcrypt:0.4"
        }
```

### Installation

1. Clone this repository to your local machine

2. Open the project in your Java IDE.

3. Configure your database settings in the `application.properties` file.

4. Build the project (You can use ``` ./gradlew bootRun```)


### Routes (http://localhost:8080/[Routes])

1. "/" --> Home Page it will show you Two button "Sign In" , "Sign Up" 
2. "/SignUp" --> Sign Up Page to allow to yhe user create new account
3. "/SignIn" --> Sign In Page to allow to the user enter to the application

## Usage

1. Run the application.

2. Access the web application in your browser at `http://localhost:8080`.

3. Sign up, sign in, and add posts to test the authentication and posting functionality.

4. Log out when done.

### Note :: The password will be saved as hashed Password in the Database [ BCrypt for password hashing ]
