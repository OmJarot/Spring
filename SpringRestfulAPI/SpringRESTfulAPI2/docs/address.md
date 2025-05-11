# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/addresses

Request Header : 

- X-API-TOKEN : Token (Mandatory)

Request Body : 

```json
{
  "street" : "jalan apa",
  "city" : "batam",
  "province" : "kepri",
  "country" : "indonesia",
  "postalCode" : "32123"
}
```

Response Body (Success) : 

```json
{
  "data" : {
    "id" : "random-string",
    "street" : "jalan apa",
    "city" : "batam",
    "province" : "kepri",
    "country" : "indonesia",
    "postalCode" : "32123"
  }
}
```

Response Body (Failed) : 

```json
{
  "errors" : "Contacts not found"
}
```

## Update Address

Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street" : "jalan apa",
  "city" : "batam",
  "province" : "kepri",
  "country" : "indonesia",
  "postalCode" : "32123"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street" : "jalan apa",
    "city" : "batam",
    "province" : "kepri",
    "country" : "indonesia",
    "postalCode" : "32123"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street" : "jalan apa",
    "city" : "batam",
    "province" : "kepri",
    "country" : "indonesia",
    "postalCode" : "32123"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street" : "jalan apa",
    "city" : "batam",
    "province" : "kepri",
    "country" : "indonesia",
    "postalCode" : "32123"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : [
    {
      "id" : "random-string",
      "street" : "jalan apa",
      "city" : "batam",
      "province" : "kepri",
      "country" : "indonesia",
      "postalCode" : "32123"
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors" : "Contacts not found"
}
```