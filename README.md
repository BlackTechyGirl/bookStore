

# Bookstore Management Application

This application is a RESTful web service for managing a bookstore with CRUD operations for books, authors, and genres. It is built using Spring Boot, Java 19, MySQL, and Spring Data JPA.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [Testing the Application](#testing-the-application)
- [API Endpoints](#api-endpoints)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- Manage authors with CRUD operations
- Manage books with CRUD operations
- Manage genres with CRUD operations
- Exception handling and validation
- Comprehensive unit tests

## Technologies Used

- Java 19
- Spring Boot
- Spring Data JPA
- MySQL
- H2 Database (for testing)
- Maven

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed on your machine:

- Java 19
- Maven
- MySQL

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/BlackTechyGirl/bookStore.git
   cd bookStore-app
   ```

2. Set up your MySQL database:

   - Create a database named `bookstore`.
   - Create a `secrets.prop` file in the `src/main/resources` directory and add your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     ```

3. Update the `application.properties` file to use the `secrets.prop`:
   ```properties
   spring.config.import=optional:secrets.prop
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

## Usage

### Running the Application

To run the application, use the following command:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### Testing the Application

To run unit tests, use the following command:
```bash
mvn test
```

## API Endpoints

### Author Endpoints

- **Create Author**
  - `POST /api/v1/authors/create`
  - Request Body:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "biography": "Author biography",
      "books": []
    }
    ```

- **Get All Authors**
  - `GET /api/v1/authors`

- **Get Author by ID**
  - `GET /api/v1/authors/{id}`

- **Update Author**
  - `PATCH /api/v1/authors/update/{id}`
  - Request Body:
    ```json
    {
      "firstName": "UpdatedFirstName",
      "lastName": "UpdatedLastName",
      "biography": "Updated biography",
      "books": []
    }
    ```

- **Delete Author**
  - `DELETE /api/v1/authors/delete/{id}`

### Book Endpoints

- **Create Book**
  - `POST /api/v1/books/create`
  - Request Body:
    ```json
    {
      "title": "Book Title",
      "isbn": "123456789",
      "publisher": "Publisher",
      "author": {
        "id": 1
      },
      "genre": {
        "id": 1
      },
      "yearPublished": 2023
    }
    ```

- **Get All Books**
  - `GET /api/v1/books`

- **Get Book by ID**
  - `GET /api/v1/books/{id}`

- **Update Book**
  - `PATCH /api/v1/books/update/{id}`
  - Request Body:
    ```json
    {
      "title": "Updated Title",
      "isbn": "987654321",
      "publisher": "Updated Publisher",
      "author": {
        "id": 1
      },
      "genre": {
        "id": 1
      },
      "yearPublished": 2023
    }
    ```

- **Delete Book**
  - `DELETE /api/v1/books/delete/{id}`

### Genre Endpoints

- **Create Genre**
  - `POST /api/v1/genres/create`
  - Request Body:
    ```json
    {
      "name": "Genre Name",
      "books": []
    }
    ```

- **Get All Genres**
  - `GET /api/v1/genres`

- **Get Genre by ID**
  - `GET /api/v1/genres/{id}`

- **Update Genre**
  - `PATCH /api/v1/genres/update/{id}`
  - Request Body:
    ```json
    {
      "name": "Updated Genre Name",
      "books": []
    }
    ```

- **Delete Genre**
  - `DELETE /api/v1/genres/delete/{id}`

## Error Handling

The application uses a global exception handler to manage errors and provide meaningful error responses.

### Example Error Response
```json
{
  "timeStamp": "2024-07-03T20:13:38.6879772+01:00",
  "message": "Author not found with id: 1",
  "description": "uri=/api/v1/authors/1"
}
```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License.

## Contact

If you have any questions or feedback, please contact:

- Your Name - [marthadanladi653@.com](mailto:marthadanladi653@gmail.com)
- GitHub: [BlackTechyGirl](https://github.com/BlackTechyGirl)
