INSERT INTO workers( name, city_id, address, salary, bonus, borndate, hiredate ) VALUES
( ?, ( SELECT id FROM cites WHERE city = ? ), ?, ?, ?, ?, ? );