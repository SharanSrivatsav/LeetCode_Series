# Write your MySQL query statement below
select Users.name as name, ifnull(sum(Rides.distance),0) as travelled_distance
from Users
Left join Rides on Users.id = Rides.user_id
group  by Users.id,Users.name order by sum(distance) desc , name asc ;