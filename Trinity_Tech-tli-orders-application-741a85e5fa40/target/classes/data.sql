INSERT INTO order_statuses(`name`, created_date, created_by, modified_date, modified_by)
VALUES
('New', NOW(), 1, NOW(), 1),
('Processing', NOW(), 1, NOW(), 1),
('In Transit', NOW(), 1, NOW(), 1),
('Delivered', NOW(), 1, NOW(), 1),
('Canceled', NOW(), 1, NOW(), 1);



INSERT INTO orders(id, status_id, created_date, created_by, modified_date, modified_by)
VALUES
(1, 1, NOW(), 1, NOW(), 1),
(2, 2, NOW(), 2, NOW(), 6),
(3, 3, NOW(), 3, NOW(), 7),
(4, 4, NOW(), 4, NOW(), 9),
(5, 5, NOW(), 5, NOW(), 8);


INSERT INTO order_line_items(`number`, order_Id, `name`, price, quantity) 
VALUES 
(1, 6, 'Widget', 20, 1),
(2, 6, 'Widget', 35, 2);

