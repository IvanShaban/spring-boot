CREATE TABLE IF NOT EXISTS users
(
    id       bigserial         NOT NULL,
    name     varchar(100)      NOT NULL,
    sex      varchar(100)      NOT NULL,
    email    varchar(100)      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS devices
(
    id       BIGSERIAL         NOT NULL,
    name     varchar(100)      NOT NULL,
    type     varchar(100)      NOT NULL,
    owner_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES users (id)
);