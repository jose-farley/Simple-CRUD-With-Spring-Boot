# Rotas
## Salvar produto
- url: http://localhost:8080/products
- method: POST
Request-Body: 
```
{
    "name":"Arroz",
    "price":5.75,
    "code":"001"
}
```
## Listar produtos
- url: http://localhost:8080/products
- method: GET

## Excluir produto
- url: http://localhost:8080/products?id=1
- method: DELETE
## Atualizar produto
- url: http://localhost:8080/products
- method: PUT
- Request-Body: 
```
{
  "id": 2,
  "name": "Macarrão",
  "code": "001",
  "price": 1.75
  
  }
```
