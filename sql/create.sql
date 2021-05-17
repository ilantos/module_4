CREATE TABLE questions (
    id INTEGER PRIMARY KEY,
    question VARCHAR (300),
    answer VARCHAR (300),
    points INTEGER
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100) UNIQUE,
    max_total_points INTEGER
);