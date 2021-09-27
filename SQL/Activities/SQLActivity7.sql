describe orders;

Select * from orders;

Select Sum(Purchase_amount) as "Total_Sum" from orders;

Select Avg(Purchase_amount) as "Average_Sum" from orders;

Select Max(Purchase_amount) as "Max_Purchase" from orders;

Select Min(Purchase_amount) as "Min_Purchase" from orders;

Select Count(distinct Salesman_ID) as "No_of_Salesman" from orders;