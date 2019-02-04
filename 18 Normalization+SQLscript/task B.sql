use labor_sql;

# ------------1------------------
# 1
SELECT maker FROM product
WHERE  maker IN (SELECT maker FROM product WHERE type = 'pc') 
GROUP BY maker
HAVING maker NOT IN(SELECT maker FROM product WHERE type ='laptop');

# 2
SELECT maker FROM (SELECT * FROM product WHERE type ='pc' GROUP BY maker) as product1
WHERE maker <> ALL (SELECT maker FROM product  WHERE type ='laptop' )
GROUP BY maker

# 3 -
SELECT maker FROM (SELECT * FROM product WHERE type ='pc' GROUP BY maker) as product1
WHERE maker = ANY (SELECT p1.maker, p2.maker FROM product p1, product p2 WHERE p1.type !='laptop'AND p2.type !='pc' AND  p1.maker != p2.maker GROUP BY p1.maker)
GROUP BY maker

# 4
SELECT maker FROM product
WHERE  maker IN (SELECT maker FROM product WHERE type = 'pc') 
GROUP BY maker
HAVING maker IN(SELECT maker FROM product WHERE type ='laptop');

# 5
SELECT maker FROM (SELECT maker FROM product WHERE type ='pc') product1
WHERE maker <> ALL (SELECT maker FROM product WHERE type !='laptop')
GROUP BY maker

# 6 
SELECT maker FROM (SELECT maker FROM product WHERE type ='laptop') product1
WHERE maker = ANY (SELECT maker FROM product WHERE type ='pc')
GROUP BY maker
