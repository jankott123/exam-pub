CREATE TABLE users (
                       id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name      VARCHAR(100)  NOT NULL,
                       username  VARCHAR(50)   NOT NULL UNIQUE,
                       password  VARCHAR(100)  NOT NULL,
                       role      VARCHAR(20)   NOT NULL,
                       is_active BOOLEAN       NOT NULL DEFAULT TRUE,
                       is_adult  BOOLEAN       NOT NULL,
                       pocket    DECIMAL(10,2) NOT NULL,
                       CHECK (pocket >= 0)
);

CREATE TABLE products (
                          id           BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name         VARCHAR(100)  NOT NULL,
                          price        DECIMAL(10,2) NOT NULL,
                          is_for_adult BOOLEAN       NOT NULL
);

CREATE TABLE orders (
                        id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id    BIGINT        NOT NULL,
                        product_id BIGINT        NOT NULL,
                        amount     INT           NOT NULL,
                        unit_price DECIMAL(10,2) NOT NULL,
                        created_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES users (id),
                        FOREIGN KEY (product_id) REFERENCES products (id),
                        INDEX idx_orders_user_id (user_id),
                        INDEX idx_orders_product_id (product_id)
);