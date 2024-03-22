# XAuth API

## Overview

XAuth API is a permission-based authorization system for API access control. It provides endpoints for user registration, authentication, and accessing public and private APIs.

## Endpoints

### Public Endpoints

- **POST** `/api/v1/auth/register`: Register a new user.
- **POST** `/api/v1/auth/authenticate`: Authenticate a user.
- **GET** `/api/v1/public/example`: testing public endpoint.

### Private Endpoints

- **GET** `/api/v1/private/example`: Access a private resource (example).

## Authentication

To authenticate with the API, send a POST request to `/api/v1/auth/authenticate` with the user's credentials (email and password). Upon successful authentication, you will receive an authentication token. Include this token in the Authorization header for accessing private endpoints.

## Usage

### Registration

To register a new user, send a POST request to `/api/v1/auth/register` with the following JSON payload:

```json
{
  "username": "example_user",
  "email": "user@example.com",
  "password": "password123"
}
```
# Postman Collection

Click the button below to import the Postman collection:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/12734353-2ddfe725-3ecd-4413-bb44-91aa0193d73c?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D12734353-2ddfe725-3ecd-4413-bb44-91aa0193d73c%26entityType%3Dcollection%26workspaceId%3Deb6039ff-527d-4e42-a8c0-36baf4ffd0b0)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
