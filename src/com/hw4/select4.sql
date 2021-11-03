/*число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
  с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).*/

select '09_15' as tPeriod, count(t.id), sum(p.price)
from dbo.timetable as tt
         inner join dbo.tickets as t on t.timeTableId = tt.id
         inner join dbo.prices as p on p.id = tt.priceId
where cast(tt.dateTimeStart as time) between '09:00:00' and '15:00:00'
union
select '15_18' as tPeriod, count(t.id), sum(p.price)
from dbo.timetable as tt
         inner join dbo.tickets as t on t.timeTableId = tt.id
         inner join dbo.prices as p on p.id = tt.priceId
where cast(tt.dateTimeStart as time) between '15:00:00' and '18:00:00'
union
select '18_21' as tPeriod, count(t.id), sum(p.price)
from dbo.timetable as tt
         inner join dbo.tickets as t on t.timeTableId = tt.id
         inner join dbo.prices as p on p.id = tt.priceId
where cast(tt.dateTimeStart as time) between '18:00:00' and '21:00:00'
union
select '21_00' as tPeriod, count(t.id), sum(p.price)
from dbo.timetable as tt
         inner join dbo.tickets as t on t.timeTableId = tt.id
         inner join dbo.prices as p on p.id = tt.priceId
where cast(tt.dateTimeStart as time) between '21:00:00' and '00:00:00'