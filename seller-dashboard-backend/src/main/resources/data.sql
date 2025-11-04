INSERT INTO sellers (id, name, region) VALUES
(1, 'Ali', 'Karachi'),
(2, 'Hassan', 'Lahore');

INSERT INTO sales (id, seller_id, date, quantity, price, returned) VALUES
(1, 1, '2025-01-01', 10, 500, false),
(2, 1, '2025-01-02', 20, 450, true),
(3, 2, '2025-01-03', 15, 700, false);
