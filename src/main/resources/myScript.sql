SELECT  c.name, o.product_name
from CUSTOMERS c
         join ORDERS O on c.id = O.customer_id
where c.name = :name
;