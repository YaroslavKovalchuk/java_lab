use labor_sql;

# ------------1------------------
# 1
SELECT maker FROM product
WHERE  maker IN (SELECT maker FROM product WHERE type = 'pc') 
GROUP BY maker
HAVING maker NOT IN(SELECT maker FROM product WHERE type ='laptop');

# 2
SELECT maker FROM product
WHERE maker <> ALL (SELECT maker FROM product WHERE type ='printer' )
GROUP BY maker
HAVING maker >= ALL(SELECT maker FROM product WHERE type ='pc');

# 3 -
SELECT maker FROM product
WHERE maker = ANY (SELECT maker FROM product WHERE type !='laptop')
GROUP BY maker
HAVING maker = ANY(SELECT maker FROM product WHERE type ='pc');

# 4
SELECT maker FROM product
WHERE  maker IN (SELECT maker FROM product WHERE type = 'pc') 
GROUP BY maker
HAVING maker IN(SELECT maker FROM product WHERE type ='laptop');

# 5
SELECT maker FROM product
WHERE maker <> ALL (SELECT maker FROM product WHERE type ='pc')
GROUP BY maker
HAVING maker = ALL(maker);

