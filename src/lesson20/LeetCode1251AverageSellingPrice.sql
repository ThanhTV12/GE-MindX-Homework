# Write your MySQL query statement below
select us.product_id, ROUND(SUM(p.price * us.units) / sum(us.units), 2) as average_price
from UnitsSold us
left join Prices p
    on us.product_id = p.product_id
    and us.purchase_date >= p.start_date and us.purchase_date <= p.end_date
group by us.product_id
