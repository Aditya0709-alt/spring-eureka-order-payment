#### A simple implementation of the API gateway pattern where two microservices communicate

<img width="1212" alt="Screenshot 2023-08-17 at 12 56 22 AM" src="https://github.com/Aditya0709-alt/spring-eureka-order-payment/assets/77115883/428dd736-b329-4cd3-8d6c-1ea5749fd402">



```
URL: "http://localhost:9192/order/bookOrder"
HTTP Method: POST
Status: 200 OK
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
Status: 200 OK
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
