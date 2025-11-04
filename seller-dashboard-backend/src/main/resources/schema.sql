CREATE TABLE sellers (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    region VARCHAR(255)
);

CREATE TABLE sales (
    id INT PRIMARY KEY,
    seller_id INT,
    date DATE,
    quantity INT,
    price DECIMAL(10,2),
    returned BOOLEAN,
    FOREIGN KEY (seller_id) REFERENCES sellers(id)
);
