describe orders;

Select * from orders;

Select Customer_ID, Max(Purchase_Amount) from orders
group by Customer_ID
Order by Customer_ID;

SELECT salesman_id, order_date, MAX(purchase_amount) FROM orders WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') 
GROUP BY salesman_id, order_date;

Select Customer_id, Order_Date, Max(Purchase_Amount) from orders
group by Customer_id, Order_Date
having Max(Purchase_amount) IN(2030, 3450, 5760, 6000)