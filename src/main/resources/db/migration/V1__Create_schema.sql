CREATE SEQUENCE products_seq START 1 INCREMENT 1;

CREATE TABLE product (
    id BIGINT PRIMARY KEY DEFAULT nextval('products_seq'),
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT uk_product_code UNIQUE (code)
);

COMMENT ON TABLE product IS 'Tabla para almacenar productos del sistema';
COMMENT ON COLUMN product.id IS 'Identificador único del producto (secuencial)';
COMMENT ON COLUMN product.code IS 'Código único del producto';
COMMENT ON COLUMN product.name IS 'Nombre del producto';
COMMENT ON COLUMN product.price IS 'Precio del producto';