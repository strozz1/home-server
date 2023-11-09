CREATE TABLE cpu (
    id integer PRIMARY KEY,
    time timestamp,
    temp decimal
);

CREATE TABLE speed (
    id integer PRIMARY KEY,
    time timestamp,
    ping decimal,
    download decimal,
    upload decimal

);