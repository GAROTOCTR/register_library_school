CREATE TABLE IF NOT EXISTS student (
    registration INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created Timestamp NOT NULL,
    modified Timestamp
);

CREATE TABLE IF NOT EXISTS book (
    code INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    created Timestamp NOT NULL,
    modified Timestamp
);

CREATE TABLE IF NOT EXISTS rent (
    id INTEGER NOT NULL PRIMARY KEY,
    student_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    initial_date DATE NOT NULL,
    final_date DATE,
    created Timestamp NOT NULL,
    modified Timestamp,
    FOREIGN KEY (student_id) REFERENCES student (registration),
    FOREIGN KEY (book_id) REFERENCES book (code)
);