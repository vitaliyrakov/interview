USE TEST_DB

CREATE TABLE dbo.tickets
(
    id          int IDENTITY (1,1) NOT NULL,
    timeTableId int                NULL,
    CONSTRAINT PK_tickets PRIMARY KEY (id),
    CONSTRAINT FK_tickets_timetable FOREIGN KEY (timeTableId)
        REFERENCES dbo.timetable (id)
)

CREATE TABLE dbo.prices
(
    id    int IDENTITY (1,1) NOT NULL,
    price decimal(15, 2)     NULL,
    CONSTRAINT PK_prices PRIMARY KEY (id)
)

CREATE TABLE dbo.duration
(
    id       int IDENTITY (1,1) NOT NULL,
    duration smallint           NOT NULL,
    CONSTRAINT PK_duration PRIMARY KEY (id)
)

CREATE TABLE dbo.movies
(
    id         int IDENTITY (1,1) NOT NULL,
    name       nchar(100)         NOT NULL,
    durationId int                NOT NULL,
    CONSTRAINT PK_movies PRIMARY KEY (id),
    CONSTRAINT FK_movies_duration FOREIGN KEY (durationId)
        REFERENCES dbo.duration (id)
)

CREATE TABLE dbo.timetable
(
    id            int IDENTITY (1,1) NOT NULL,
    dateTimeStart smalldatetime      NOT NULL,
    movieId       int                NOT NULL,
    priceId       int                NOT NULL,
    CONSTRAINT PK_timetable PRIMARY KEY (id),
    CONSTRAINT FK_timetable_movies FOREIGN KEY (movieId)
        REFERENCES dbo.movies (id),
    CONSTRAINT FK_timetable_prices FOREIGN KEY (priceId)
        REFERENCES dbo.prices (id)
)





