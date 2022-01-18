# Write your MySQL query statement below

select tp.country_name,
    CASE
    WHEN e_weather_state <= 15 THEN "Cold"
    WHEN e_weather_state >= 25 THEN "Hot"
    ELSE "Warm"
END as weather_type
from
(select c.country_name,
       sum(w.weather_state) / count(w.weather_state) as e_weather_state
from Weather w
left join Countries c
    on w.country_id  = c.country_id
where  MONTH(w.day) = 11 and YEAR(w.day) = 2019
group by c.country_id) tp
