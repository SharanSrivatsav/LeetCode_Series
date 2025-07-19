# Write your MySQL query statement below
select e.unique_id ,em.name 
from EmployeeUNI e
right join Employees em on e.id=em.id;