## API Endpoints

### Customer Management
#### Get All Customers
- **URL:** http://localhost:8080/pos/customer
- **Method:** GET
- **Description:** Retrieve a list of all customers.

#### Get Customer by ID
- **URL:** http://localhost:8080/pos/customer?customerId={id}
- **Method:** GET
- **Description:** Retrieve customer details by ID.

#### Add Customer
- **URL:** http://localhost:8080/pos/customer
- **Method:** POST
- **Description:** Add a new customer.
- **Request Body:** JSON representing the customer.

#### Update Customer
- **URL:** http://localhost:8080/pos/customer
- **Method:** PUT
- **Description:** Update an existing customer.
- **Request Body:** JSON representing the updated customer.

#### Delete Customer
- **URL:** http://localhost:8080/pos/customer?customerId={id}
- **Method:** DELETE
- **Description:** Delete a customer by ID.

### Item Management
#### Get All Items
- **URL:** http://localhost:8080/pos/item
- **Method:** GET
- **Description:** Retrieve a list of all items.

#### Get Item by Code
- **URL:** http://localhost:8080/pos/item?itemCode={code}
- **Method:** GET
- **Description:** Retrieve item details by code.

#### Add Item
- **URL:** http://localhost:8080/pos/item
- **Method:** POST
- **Description:** Add a new item.
- **Request Body:** JSON representing the item.

#### Update Item
- **URL:** http://localhost:8080/pos/item
- **Method:** PUT
- **Description:** Update an existing item.
- **Request Body:** JSON representing the updated item.

#### Delete Item
- **URL:** http://localhost:8080/pos/item?itemCode={code}
- **Method:** DELETE
- **Description:** Delete an item by code.

### Order Management
#### Get All Orders
- **URL:** http://localhost:8080/pos/order
- **Method:** GET
- **Description:** Retrieve a list of all orders.

#### Get Order by ID
- **URL:** http://localhost:8080/pos/order?orderId={id}
- **Method:** GET
- **Description:** Retrieve order details by ID.

#### Add Order
- **URL:** http://localhost:8080/pos/order
- **Method:** POST
- **Description:** Add a new order.
- **Request Body:** JSON representing the order.
