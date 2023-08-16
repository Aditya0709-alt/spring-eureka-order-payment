#### A simple implementation of the API gateway pattern where two microservices communicate

<img width="1392" alt="Screenshot 2023-08-17 at 12 42 18 AM" src="https://github.com/Aditya0709-alt/stegano-master/assets/77115883/865055c9-4612-4626-8379-6a349af0d58d">

```
URL: "http://localhost:9192/order/bookOrder"
HTTP Method: POST
```

```json
{
	"order":{
		"id":103,
		"name":"Mobile",
		"qty":1,
		"price":8000
		
	},
	"payment":{}
}
```

Response

```json

{
    "order": {
        "id": 26,
        "name": "ear-phone",
        "qty": 5,
        "price": 4000
    },
    "amount": 4000,
    "transactionId": "9a021fa6-2061-4332-bdb7-b1358b3430c2",
    "message": "payment processing successful and order placed"
}
```

```
URL : "http://localhost:9191/payment/26"
HTTP Method : GET
```

Response

```json
{
    "paymentId": 1,
    "transactionId": "d86cfeca-0b26-455e-a1a2-ac3e53707829",
    "orderId": 103,
    "paymentStatus": "SUCCESS",
    "amount":4000
}
```
