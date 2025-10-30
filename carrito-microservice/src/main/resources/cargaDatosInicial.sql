
-- Script de carga de datos iniciales
-- Proyecto: Huerto Hogar - Carrito Microservicio


-- Insertar carritos de ejemplo

INSERT INTO carrito (id, usuario_id, total) VALUES 
(1, 'user001', 8700),
(2, 'user002', 7200);


-- Insertar items del carrito

INSERT INTO item_carrito (id, producto_id, cantidad, nombre_producto, descripcion_producto, precio_unitario, carrito_id)
VALUES
-- Carrito 1 (user001)
(1, 'fruit1', 2, 'Manzanas Fuji', 'Manzanas Fuji crujientes y dulces, cultivadas en el Valle del Maule.', 1200, 1),
(2, 'fruit2', 3, 'Naranjas Valencianas', 'Jugosas y ricas en vitamina C, ideales para zumos frescos.', 1000, 1),
(3, 'verdura1', 1, 'Zanahorias Orgánicas', 'Cultivadas sin pesticidas, excelentes para ensaladas.', 900, 1),

-- Carrito 2 (user002)
(4, 'verdura2', 2, 'Espinacas Frescas', 'Perfectas para ensaladas y batidos verdes.', 700, 2),
(5, 'organicproduct1', 1, 'Miel Orgánica', 'Miel pura y orgánica de apicultores locales.', 5000, 2);
