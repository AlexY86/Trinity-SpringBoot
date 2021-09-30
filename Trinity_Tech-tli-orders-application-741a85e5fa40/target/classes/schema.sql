CREATE TABLE order_statuses (
    id INT NULL,
    name VARCHAR(50)  NULL,
    created_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT  NULL,
    modified_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by INT  NULL,
    UNIQUE KEY order_statuses_name (`name`)
);

CREATE TABLE orders (
    id INT NULL,
    status_id INT  NULL,
    created_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT  NULL,
    modified_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by INT  NULL
);

CREATE TABLE order_line_items (
    `number` INT NULL,
    order_id INT NULL,
    `name` VARCHAR(255) NULL,
    price DECIMAL(10, 2)  NULL DEFAULT 0.00,
    quantity DECIMAL(10, 2)  NULL DEFAULT 1.00,
    created_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT  NULL,
    modified_date TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by INT  NULL,
    UNIQUE KEY order_line_item_id (`number`, order_id)
);