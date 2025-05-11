# User API Spec

## Register User

Endpoint : POST /api/users

Request Body : 

```json
{
  "username" : "piter",
  "password" : "rahasia",
  "name" : "Piter Pangaribuan"
}
```

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) : 
```json
{
  "errors" : "Username must not blank, ???"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username" : "piter",
  "password" : "rahasia"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 32131231 // millisecond
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Username or password wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Request Header : 

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : {
    "username" : "piter",
    "name" : "Piter pangaribuan"
  }
  
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

```json
{
  "name" : "Piter", // put if only want to update name
  "password" : "new password" // put if only want to update password
}
```

Response Body (Success) :

```json
{
  "data" : {
    "username" : "piter",
    "name" : "Piter pangaribuan"
  }
  
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Unauthorized"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) : 

```json
{
  "data" : "OK"
}
```