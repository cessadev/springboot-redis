INSERT INTO product (code, name, price) VALUES
('PROD001', 'Laptop HP EliteBook', 1299.99),
('PROD002', 'Teclado Mecánico RGB', 89.50),
('PROD003', 'Mouse Inalámbrico', 25.99),
('PROD004', 'Monitor 24" Full HD', 199.00),
('PROD005', 'Disco SSD 1TB', 109.95),
('PROD006', 'Memoria RAM 16GB', 75.00),
('PROD007', 'Webcam HD', 45.50),
('PROD008', 'Auriculares Bluetooth', 59.99),
('PROD009', 'Impresora Multifunción', 149.00),
('PROD010', 'Tablet 10"', 229.00);

SELECT setval('products_seq', (SELECT MAX(id) FROM product));