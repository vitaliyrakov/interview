/*перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
  Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;*/

select movies.name,
       timetable.dateTimeStart,
       duration.duration,
       (SELECT top 1 (tt.dateTimeStart)
        FROM timetable as tt
                 inner join dbo.movies as m on m.id = tt.movieId
                 inner join dbo.duration as d on d.id = m.durationId
        WHERE tt.dateTimeStart > timetable.dateTimeStart
        order by tt.dateTimeStart asc)                                                                        as dateTimeStartNextMovie,
       DATEDIFF(mi, DATEADD(mi, duration.duration, timetable.dateTimeStart), (SELECT top 1 (tt.dateTimeStart)
                                                                              FROM timetable as tt
                                                                                       inner join dbo.movies as m on m.id = tt.movieId
                                                                                       inner join dbo.duration as d on d.id = m.durationId
                                                                              WHERE tt.dateTimeStart > timetable.dateTimeStart
                                                                              order by tt.dateTimeStart asc)) as pauseD
from dbo.timetable
         inner join dbo.movies on movies.id = timetable.movieId
         inner join dbo.duration on duration.id = movies.durationId
where DATEDIFF(mi, DATEADD(mi, duration.duration, timetable.dateTimeStart), (SELECT top 1 (tt.dateTimeStart)
                                                                             FROM timetable as tt
                                                                                      inner join dbo.movies as m on m.id = tt.movieId
                                                                                      inner join dbo.duration as d on d.id = m.durationId
                                                                             WHERE tt.dateTimeStart > timetable.dateTimeStart
                                                                             order by tt.dateTimeStart asc)) > 30
order by pauseD