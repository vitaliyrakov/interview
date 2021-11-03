/* список фильмов, для каждого — с указанием общего числа посетителей за все время,
   среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
   Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;*/

select movies.name,
       (SELECT count(t.id)
        FROM timetable as tt
                 inner join dbo.movies as m on m.id = tt.movieId
                 inner join dbo.tickets as t on t.timeTableId = tt.id
        WHERE m.id = movies.id)                            as sumTickets,
       (SELECT (count(t.id))
        FROM timetable as tt
                 inner join dbo.movies as m on m.id = tt.movieId
                 inner join dbo.tickets as t on t.timeTableId = tt.id
        WHERE m.id = movies.id) / (SELECT count(tt.id)
                                   FROM timetable as tt
                                            inner join dbo.movies as m on m.id = tt.movieId
                                   WHERE m.id = movies.id) as avgTicketsPerSession,
       (SELECT sum(p.price)
        FROM timetable as tt
                 inner join dbo.movies as m on m.id = tt.movieId
                 inner join dbo.tickets as t on t.timeTableId = tt.id
                 inner join dbo.prices as p on p.id = tt.priceId
        WHERE m.id = movies.id
        group by m.id)                                     as sumByMovie
from dbo.movies
where (SELECT count(tt.id)
       FROM timetable as tt
                inner join dbo.movies as m on m.id = tt.movieId
       WHERE m.id = movies.id) > 0
union
(select 'summary' as name,
        (SELECT count(t.id)
         FROM timetable as tt
                  inner join dbo.movies as m on m.id = tt.movieId
                  inner join dbo.tickets as t on t.timeTableId = tt.id),
        (SELECT (count(t.id))
         FROM timetable as tt
                  inner join dbo.movies as m on m.id = tt.movieId
                  inner join dbo.tickets as t on t.timeTableId = tt.id) /
        (SELECT count(tt.id)
         FROM timetable as tt
                  inner join dbo.movies as m on m.id = tt.movieId),
        (SELECT sum(p.price)
         FROM timetable as tt
                  inner join dbo.movies as m on m.id = tt.movieId
                  inner join dbo.tickets as t on t.timeTableId = tt.id
                  inner join dbo.prices as p on p.id = tt.priceId)
)
order by sumByMovie