

# BookStore Application

This repository contains a Spring Boot application for managing a bookstore, implementing CRUD operations for books, authors, and genres. It uses MySQL with Spring Data JPA for database interactions.

## Technologies Used

- Java 19
- Spring Boot 3.3.1
- MySQL
- Spring Data JPA

## Features

- **Books:**
  - Create, Read, Update, Delete (CRUD) operations.
  - Search books by title, author, or genre.
  
- **Authors:**
  - Manage author details and their associated books.
  - CRUD operations for authors.
  
- **Genres:**
  - Define book genres and associate books with genres.
  - CRUD operations for genres.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/BlackTechyGirl/bookStore.git
   cd bookStore
   ```

2. **Configure MySQL:**
   - Install MySQL and create a database named `bookstore_db`.
   - Update `secrets.properties` in `src/main/resources` with your MySQL username and password:
     ```properties
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application:**
   Open your web browser and go to `http://localhost:8080`.

## API Endpoints

- **Books:**
  - `GET /api/v1/books`: Get all books.
  - `POST /api/v1/books/create`: Create a new book.
  - `PUT /api/v1/books/update/{id}`: Update a book by ID.
  - `DELETE /api/v1/books/delete/{id}`: Delete a book by ID.

- **Authors:**
  - `GET /api/v1/authors`: Get all authors.
  - `POST /api/v1/authors/create`: Create a new author.
  - `PUT /api/v1/authors/update/{id}`: Update an author by ID.
  - `DELETE /api/v1/authors/delete/{id}`: Delete an author by ID.

- **Genres:**
  - `GET /api/v1/genres`: Get all genres.
  - `POST /api/v1/genres/create`: Create a new genre.
  - `PUT /api/v1/genres/update/{id}`: Update a genre by ID.
  - `DELETE /api/v1/genres/delete/{id}`: Delete a genre by ID.

## Testing

Unit tests and integration tests are included to verify the functionality of services and controllers. To run the tests, use:
```bash
./mvnw test
```

## Contributing

Contributions are welcome! Please fork this repository and create a pull request with your improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

