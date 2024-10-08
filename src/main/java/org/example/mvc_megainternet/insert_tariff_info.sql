-- Создание таблицы TariffInfo
CREATE TABLE TariffInfo (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            tariff_name VARCHAR(255) NOT NULL,
                            connection_type VARCHAR(255) NOT NULL,
                            price INT NOT NULL,
                            speed INT NOT NULL,

                            stock VARCHAR(255)
);

-- Вставка данных в таблицу TariffInfo
INSERT INTO TariffInfo (tariff_name, connection_type, price, speed, data_limit, stock)
VALUES
    ('БАЗОВЫЙ', 'Волоконно-оптический', 500, 50, 500, 'Без акций'),
    ('СРЕДНИЙ', 'DSL', 800, 100, 1000, '3 месяца бесплатно для новых клиентов'),
    ('УЛЬТРА', 'Волоконно-оптический', 1200, 500, 2000, 'Бесплатная установка роутера'),
    ('ПРЕМИУМ', 'Волоконно-оптический', 2000, 1000, 5000, 'Годовая подписка со скидкой 20%'),
    ('ЭКОНОМ', 'DSL', 400, 25, 250, 'Без акций');