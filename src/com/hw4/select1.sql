/* ошибки в расписании (фильмы накладываются друг на друга),
* отсортированные по возрастанию времени.
* Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;*/

select movies.name, timetable.dateTimeStart, duration.duration
from dbo.timetable
         inner join dbo.movies on movies.id = timetable.movieId
         inner join dbo.duration on duration.id = movies.durationId
where EXISTS (SELECT (tt.id) FROM timetable as tt
                                      inner join dbo.movies as m on m.id = tt.movieId
                                      inner join dbo.duration as d on d.id = m.durationId
              WHERE tt.dateTimeStart < DATEADD(mi, duration.duration, timetable.dateTimeStart)
                AND DATEADD(mi, d.duration, tt.dateTimeStart)> DATEADD(mi, duration.duration, timetable.dateTimeStart))
union
select movies.name, timetable.dateTimeStart, duration.duration
from dbo.timetable
         inner join dbo.movies on movies.id = timetable.movieId
         inner join dbo.duration on duration.id = movies.durationId
where EXISTS (SELECT (tt.id) FROM timetable as tt
                                      inner join dbo.movies as m on m.id = tt.movieId
                                      inner join dbo.duration as d on d.id = m.durationId
              WHERE tt.dateTimeStart > timetable.dateTimeStart
                AND DATEADD(mi, d.duration, tt.dateTimeStart) < DATEADD(mi, duration.duration, timetable.dateTimeStart))
order by dateTimeStart