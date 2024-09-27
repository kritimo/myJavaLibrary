CREATE TABLE IF NOT EXISTS Book (
    title varchar(250) NOT NULL,
    author varchar(250) NOT NULL,
    genre varchar(30),
    date_finished timestamp,
    status varchar(10),
    review varchar(250),
    rating INT,
    PRIMARY KEY (title)
);