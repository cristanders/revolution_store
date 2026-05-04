create database revolution_store_in5bv;

use revolution_store_in5bv;
create table customer(
dpi_customer int primary key auto_increment not null,
first_name varchar(50) not null,
last_name varchar(50) not null,
address varchar(100) not null,
status_customer enum("ACTIVE", "INACTIVE") not null
);

create table product(
code_product int primary key auto_increment not null,
product_name varchar(100) not null,
price decimal(10,2) not null,
stock int not null,
status_product boolean not null
);

create table users(
code_user int primary key auto_increment not null,
username varchar(45) not null,
passwords varchar(45) not null,
email varchar(67) not null,
user_role enum("ADMIN",  "USER") not null
);

create table sales(
code_sales int primary key auto_increment not null,
sale_date date not null,
total decimal(10,2) not null,
status_sales enum("ACTIVE", "IN_PROCESS", "CANCELLED") not null,
dpi_customer int not null,
code_user int not null,
foreign key (dpi_customer) references customer (dpi_customer),
foreign key (code_user) references users (code_user)
);

create table sale_details(
code_sale_detail int primary key auto_increment not null,
quantity int not null,
unit_price decimal(10,2) not null,
subtotal decimal(10,2) not null,
code_product int not null,
code_sales int not null,
foreign key (code_product) references product(code_product),
foreign key (code_sales) references sales(code_sales)
);

USE revolution_store_in5bv;

INSERT INTO customer (first_name, last_name, address, status_customer) VALUES 
('James', 'Harrison', '742 Evergreen Terrace, Springfield', 'ACTIVE'),
('Emma', 'Sullivan', '1202 Baker Street, London', 'ACTIVE'),
('Noah', 'Richardson', '455 Mission District, San Francisco', 'INACTIVE'),
('Sophia', 'Bennett', '89 High Street, Manchester', 'ACTIVE'),
('Lucas', 'Morgan', '23 Briarwood Court, Seattle', 'ACTIVE');


INSERT INTO product (product_name, price, stock, status_product) VALUES 
('Mechanical Keyboard RGB', 125.50, 45, 1),
('Wireless Noise Cancelling Headphones', 299.99, 20, 1),
('Ergonomic Gaming Chair', 350.00, 12, 1),
('UltraWide Monitor 34"', 499.00, 8, 1),
('Portable SSD 1TB', 89.95, 100, 1);


INSERT INTO users (username, passwords, email, user_role) VALUES 
('admin_chris', 'AdminPass777', 'c.perez@revstore.com', 'ADMIN'),
('sarah_sales', 'Sarah2026!', 's.jones@revstore.com', 'USER'),
('mike_clerk', 'MikeStore44', 'm.thompson@revstore.com', 'USER'),
('emily_manager', 'EmiManager99', 'e.clark@revstore.com', 'ADMIN'),
('david_pro', 'DaveSales55', 'd.wilson@revstore.com', 'USER');

INSERT INTO sales (sale_date, total, status_sales, dpi_customer, code_user) VALUES 
('2026-05-01', 425.49, 'ACTIVE', 1, 2),
('2026-05-02', 299.99, 'IN_PROCESS', 2, 3),
('2026-05-03', 1250.00, 'ACTIVE', 4, 1),
('2026-05-04', 89.95, 'CANCELLED', 5, 5),
('2026-05-04', 700.00, 'ACTIVE', 1, 2);


INSERT INTO sale_details (quantity, unit_price, subtotal, code_product, code_sales) VALUES 
(1, 125.50, 125.50, 1, 1), 
(1, 299.99, 299.99, 2, 1), 
(1, 299.99, 299.99, 2, 2), 
(2, 350.00, 700.00, 3, 3), 
(1, 89.95, 89.95, 5, 4);   