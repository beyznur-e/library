# Library Management System

This project is a simple Library Management System built using Java and Spring Boot. It allows managing books, users, and the relationship between them.

## Features

- **Book Management**: Add, update, delete, and view books.
- **User Management**: Add, update, delete, and view users.
- **Owned Books**: Manage relationships between users and books.

## Technologies Used

- **Java**: Core language for the project.
- **Spring Boot**: Framework for building REST APIs.
- **Hibernate/JPA**: ORM for database interactions.
- **Maven**: Dependency and build management.

## API Endpoints

### Book Management
| Method | Endpoint          | Description             |
|--------|-------------------|-------------------------|
| POST   | `/api/book/add`   | Add a new book          |
| POST   | `/api/book/update`| Update an existing book |
| DELETE | `/api/book/delete`| Delete a book           |
| GET    | `/api/book/list`  | List all books          |
| GET    | `/api/book/byId`  | Get book by ID          |

### User Management
| Method | Endpoint               | Description             |
|--------|------------------------|-------------------------|
| POST   | `/api/book_user/add`   | Add a new user          |
| POST   | `/api/book_user/update`| Update an existing user |
| DELETE | `/api/book_user/delete`| Delete a user           |
| GET    | `/api/book_user/list`  | List all users          |
| GET    | `/api/book_user/byId`  | Get user by ID          |

### Owned Book Management
| Method | Endpoint                     | Description                              |
|--------|------------------------------|------------------------------------------|
| POST   | `/api/owned-book-user/add`   | Add a book to a user                     |
| GET    | `/api/owned-book-user/list`  | List all books owned by users            |
| DELETE | `/api/owned-book-user/delete`| Remove a book-user relationship          |

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/beynur-e/library.java
