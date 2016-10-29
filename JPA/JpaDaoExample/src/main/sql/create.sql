CREATE TABLE IF NOT EXISTS Author ( id bigserial PRIMARY KEY UNIQUE NOT NULL, name varchar(24) NOT NULL, lastname varchar(48) NOT NULL );
CREATE TABLE IF NOT EXISTS Book ( id bigserial PRIMARY KEY UNIQUE NOT NULL, title varchar(24) NOT NULL, author_id bigserial REFERENCES Author (id) );