# exam-pub

Exam pub - REST API in Spring - simulating pub (customers, bartenders)

## Running

The only requirement is Docker.

```bash
docker compose up --build
```

The API runs at `http://localhost:8080`. The database schema and test data are created automatically on startup.

## Test accounts

All accounts use the password `password`.

| Username    | ID | Role      | Purpose                          |
|-------------|----|-----------|----------------------------------|
| `bartender` | 1  | BARTENDER | Sees users and statistics        |
| `jan`       | 2  | CUSTOMER  | Adult with money                 |
| `petr`      | 3  | CUSTOMER  | Minor, cannot buy alcohol        |
| `eva`       | 4  | CUSTOMER  | Not enough money for most drinks |
| `karel`     | 5  | CUSTOMER  | Inactive, cannot buy             |

## Notes
- Price from the /buy request is not used, price is always loaded from DB.
- Every purchase is 1 piece, the request has no amount.
- A user can only buy for himself (userId must match the login).