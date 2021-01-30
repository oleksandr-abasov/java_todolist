CREATE TABLE IF NOT EXISTS todos(
    id INTEGER PRIMARY KEY,
    title TEXT,
    completed VARCHAR2(5) NOT NULL,
    sorting_order NUMBER
);
