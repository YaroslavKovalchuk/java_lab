use labor_sql;

# ------------1------------------
# 1
SELECT maker, model FROM product
WHERE TYPE = 'Laptop'
ORDER BY maker;

# 2
SELECT model, ram, screen, price FROM laptop
WHERE price > 1000 
ORDER BY ram DESC, price ASC;

# 3
SELECT * FROM printer
WHERE color = 'y'
ORDER BY price DESC;

# 4
SELECT model, speed, hd, cd, price FROM pc
WHERE (cd = '12x' OR cd = '24x') AND price < 600;

# 5
SELECT name, class FROM ships
ORDER BY name ASC;

# 6
SELECT * FROM pc
WHERE speed >= 500 AND price < 800
ORDER BY price DESC; 

# 7
SELECT * FROM printer
WHERE type != 'Matrix' AND price < 300
ORDER BY type DESC;

# 8
SELECT model,speed FROM pc
WHERE price >= 400 AND price <= 600
ORDER BY hd;

# 9
SELECT product.model, ram, hd FROM product 
JOIN pc ON product.model = pc.model 
WHERE (hd = 10 OR hd = 20) AND maker = 'A';

# 10 
SELECT model, speed, hd, price FROM laptop
WHERE screen >= 12
ORDER BY price DESC;

# 11
SELECT model, type, price FROM printer
WHERE price < 300
ORDER BY type DESC;

# 12
SELECT model, ram, price FROM laptop
WHERE ram = 64
ORDER BY screen;

# 13
SELECT model, ram, price FROM pc
WHERE ram > 64
ORDER BY hd;

# 14 
SELECT model, speed, price FROM pc
WHERE speed >= 500 AND speed < 750
ORDER BY hd DESC;

# 15
SELECT * FROM outcome_o
WHERE outcome_o.out > 200 
ORDER BY outcome_o.date DESC;

# 16
SELECT * FROM income_o
WHERE inc >= 5000 AND inc <= 10000
ORDER BY inc;

# 17
SELECT * FROM income
WHERE income.point = 1
ORDER BY inc;

# 18
SELECT * FROM outcome
WHERE outcome.point = 2
ORDER BY outcome.out;

# 19 
SELECT * FROM classes
WHERE country = 'Japan'
ORDER BY type DESC;

# 20
SELECT name, launched FROM ships
WHERE launched > 1920 AND launched < 1945
ORDER BY launched DESC;

# 23
SELECT class, displacement FROM classes
WHERE displacement >= 40000
ORDER BY type;

# 24
SELECT trip_no, town_from, town_to FROM trip
WHERE town_from = 'London' OR town_to = 'London'
ORDER BY time_out;

# 25
SELECT trip_no, plane, town_from, town_to FROM trip
WHERE plane = 'TU-134'
ORDER BY time_out DESC;

# 26
SELECT trip_no, plane, town_from, town_to FROM trip
WHERE plane != 'IL-86'
ORDER BY plane;

# 27
SELECT trip_no, town_from, town_to FROM trip
WHERE town_from != 'Rostov' AND town_to != 'Rostov'
ORDER BY plane;

#-----------------------2--------------------

# 1
SELECT * FROM product
WHERE model RLIKE '1{2,}';

# 2
SELECT * FROM outcome
WHERE MONTH(outcome.date) = '03';

# 3
SELECT * FROM outcome_o
WHERE dayofmonth(outcome_o.date) = '14';

# 4
SELECT * FROM ships
WHERE ships.name RLIKE '^W' AND ships.name RLIKE 'n$';

# 5
SELECT * FROM ships
WHERE ships.name RLIKE 'e{2}';

#6
SELECT * FROM ships
WHERE ships.name RLIKE '[^a]$';

# 7
SELECT * FROM battles
WHERE battles.name RLIKE '[[:space:]]' AND battles.name RLIKE '[^c]$';

# 8
SELECT * FROM trip
WHERE hour(time_out) >= 12 AND hour(time_out) <= 17;

# 9
SELECT * FROM trip
WHERE hour(time_in) >= 17 AND hour(time_in) <= 23;

# 10 
SELECT * FROM pass_in_trip
WHERE place RLIKE '1[a-z]';

# 11
SELECT * FROM pass_in_trip
WHERE place RLIKE '[0-9][c]';

# 12
SELECT * FROM passenger
WHERE name RLIKE '[[:space:],^[C]';

# 13
SELECT * FROM passenger
WHERE name RLIKE '[[:space:]^[^J]]';

#-------------------3---------------------
# 1
SELECT maker, type, speed, hd FROM product
JOIN pc ON product.model = pc.model
WHERE hd <= 8;

# 2
SELECT maker FROM product
JOIN pc ON product.model = pc.model
WHERE speed >=600;

# 3
SELECT maker FROM product
JOIN pc ON product.model = pc.model
WHERE speed <=500;

# 4
SELECT l1.model model1, l2.model model2, l1.hd hd1, l2.hd hd2, l1.ram ram1, l2.ram ram2 
FROM laptop l1, laptop l2 
WHERE l1.hd = l2.hd AND l1.ram = l1.ram AND l1.model != l2.model AND l1.model > l2.model
GROUP BY l1.model;

# 5
SELECT c1.country country FROM classes c1,classes c2
WHERE c1.type = 'bb' AND c2.type = 'bc'
GROUP BY c1.country;

# 6
SELECT pc.model, maker FROM product
JOIN pc ON product.model = pc.model
WHERE price < 600;

# 7
SELECT printer.model, maker FROM product
JOIN printer ON product.model = printer.model
WHERE price > 300;

# 8
SELECT maker, pc.model, price FROM product
JOIN pc ON product.model = pc.model
GROUP BY maker;

# 9
SELECT maker, pc.model, price FROM product
JOIN pc ON product.model = pc.model
GROUP BY price;

# 10
SELECT maker, type, laptop.model, speed FROM product
JOIN laptop ON product.model = laptop.model
WHERE speed > 600;

# 11
SELECT name, ships.class, launched, classes.displacement  FROM ships
JOIN classes ON classes.class = ships.class;

# 12



# 13
SELECT country, ships.class FROM ships
JOIN classes ON classes.class = ships.class
GROUP BY ships.class;

# 14


# 15
SELECT date, name FROM passenger
JOIN pass_in_trip ON pass_in_trip.id_psg = passenger.id_psg




