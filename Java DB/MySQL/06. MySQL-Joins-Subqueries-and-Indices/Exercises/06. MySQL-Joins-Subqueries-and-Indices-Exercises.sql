# EX.01
SELECT 
    e.employee_id, e.job_title, a.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
ORDER BY e.address_id
LIMIT 5; 


# EX.02
SELECT 
    e.first_name, e.last_name, t.name AS town, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
        JOIN
    towns AS t USING (town_id)
ORDER BY first_name , last_name
LIMIT 5;



# EX.03
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS deparment_name
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    d.name = 'Sales'
ORDER BY employee_id DESC;



# EX.04
SELECT 
    e.employee_id, e.first_name, e.salary, d.name AS department_name
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;



# EX.05
 SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep USING (employee_id)
WHERE
    ep.employee_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;



# EX.06
SELECT 
    e.first_name, e.last_name, e.hire_date, d.name AS dept_name
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    d.name = 'Sales' OR d.name = 'Finance'
AND e.hire_date > '1999-01-01'
ORDER BY hire_date;




# EX.07
SELECT 
    e.employee_id, e.first_name, p.name AS project_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep USING (employee_id)
        LEFT JOIN
    projects AS p USING (project_id)
WHERE
    p.start_date > 2002 - 08 - 13
        AND p.end_date is NULL
ORDER BY e.first_name , p.name
LIMIT 5;



# EX.08
SELECT 
    e.employee_id,
    e.first_name,
    IF(YEAR(p.start_date) >= 2005,
        NULL,
        p.name) AS project_name
FROM
    employees AS e
        JOIN
    employees_projects AS ep USING (employee_id)
        JOIN
    projects AS p USING (project_id)
WHERE
    employee_id = 24
ORDER BY project_name;


# EX.09
SELECT 
    e.employee_id,
    e.first_name,
    e.manager_id,
    m.first_name AS manager_name
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.manager_id = m.employee_id
WHERE
    e.manager_id IN (3 , 7)
ORDER BY e.first_name;



# EX.10
SELECT 
    e.employee_id,
    concat(e.first_name, ' ', e.last_name) AS employee_name,
    concat(m.first_name, ' ', m.last_name) AS manager_name,
    d.name
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.manager_id = m.employee_id
        JOIN
    `departments` AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;



# EX.11
SELECT 
    AVG(salary) AS min_average_salary
FROM
    employees
GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;



# EX.12
SELECT 
    c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    countries AS c
        JOIN
    mountains_countries AS m_c USING (country_code)
        JOIN
    mountains AS m ON m_c.mountain_id = m.id
        JOIN
    peaks AS p ON m.id = p.mountain_id
WHERE
    country_code = 'BG' AND elevation > 2835
ORDER BY elevation DESC;


# EX.13
SELECT 
    c.country_code, COUNT(m.mountain_range) AS mountain_range
FROM
    countries AS c
        JOIN
    mountains_countries AS m_c USING (country_code)
        JOIN
    mountains AS m ON m_c.mountain_id = m.id
GROUP BY country_code
HAVING country_code IN ('BG' , 'RU', 'US')
ORDER BY mountain_range DESC;


# EX.14
SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS c_r USING (country_code)
        LEFT JOIN
    rivers AS r ON c_r.river_id = r.id
        LEFT JOIN
    continents AS cn USING (continent_code)
WHERE
    continent_name = 'Africa'
ORDER BY country_name
LIMIT 5;



# EX.16
SELECT COUNT(*) AS country_count FROM countries AS c
WHERE c.country_code NOT IN
(SELECT country_code FROM mountains_countries)



# EX.17
s





