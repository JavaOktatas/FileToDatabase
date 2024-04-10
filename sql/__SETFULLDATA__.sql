INSERT INTO cities( city ) VALUES 
( ? );
INSERT INTO workers( name, city_id, address, salary, bonus, borndate, hiredate ) VALUES
( ?, ( SELECT id FROM cities WHERE city = ? ), ?, ?, ?, ?, ? );