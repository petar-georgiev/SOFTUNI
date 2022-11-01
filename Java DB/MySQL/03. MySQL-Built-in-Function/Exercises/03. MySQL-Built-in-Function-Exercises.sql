# EX. 1
SELECT first_name, last_name 
FROM employees
WHERE substring(first_name, 1, 2) = 'Sa'
ORDER BY employee_id;

# EX. 2
SELECT first_name, last_name 
FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

# EX. 3
SELECT first_name FROM employees
WHERE department_id IN (3, 10) 
AND YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id; 

# EX. 4
SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%engineer%'
ORDER BY employee_id;

# EX. 5
SELECT `name` FROM towns
WHERE char_length(name) IN (5,6)
ORDER BY `name`;

# EX. 6
SELECT `town_id`, `name` FROM towns
WHERE LEFT(`name`, 1) IN ('M','K','B','E')
ORDER BY `name`;

# EX. 7
SELECT `town_id`, `name` FROM towns
WHERE NOT LEFT(`name`, 1) IN ('R','B','D')
ORDER BY `name`;

# EX. 8
CREATE VIEW  `v_employees_hired_after_2000` AS
SELECT first_name, last_name FROM employees
WHERE year(hire_date) > 2000; 

# EX. 9
SELECT first_name, last_name FROM employees
WHERE char_length(last_name) = 5;

# EX. 10
SELECT country_name, iso_code FROM countries
where country_name like '%A%A%A%'
ORDER BY iso_code;

# EX. 11
SELECT 
    peak_name,
    river_name,
    lower(concat(peak_name, substring(river_name, 2))) AS mix
FROM
    peaks,
    rivers
WHERE
    right(peak_name, 1) = left(river_name, 1)
ORDER BY mix;
 
# EX. 12
SELECT name, date_format(start, '%Y-%m-%d')
 FROM games
WHERE year(start) IN (2011, 2012)
ORDER BY start
LIMIT 50;

# EX. 13
SELECT user_name, substring_index(email, '@', -1) AS `Email Provider` FROM users
ORDER BY `Email Provider`, user_name;

# EX. 14
SELECT user_name, ip_address FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

# EX. 15
SELECT 
    `name`,
    (CASE
        WHEN hour(start) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN hour(start) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS `Part of the Day`,
    (CASE
        WHEN duration < 4 THEN 'Extra Short'
        WHEN duration < 7 THEN 'Short'
        WHEN duration < 11 THEN 'Long'
        ELSE 'Extra Long'
    END) AS `Duration`
FROM
    games;

# EX. 16
SELECT product_name, order_date,
date_add(order_date, interval 3 day) AS pay_due,
date_add(order_date, interval 1 month) AS deliver_due
FROM orders;

