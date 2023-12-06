create table drone
(
    serial_number    varchar(100) not null
        primary key,
    battery_capacity int          not null,
    model            tinyint      not null,
    state            tinyint      null,
    weight_limit     int          not null,
    check (`model` between 0 and 3),
    check (`state` between 0 and 5)
);

INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('AB', 50, 3, 3, 50);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('ABC123', 100, 3, 3, 500);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('DJI0004', 100, 2, 0, 250);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('DJI0005', 20, 2, 0, 250);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('jsdfhksd', 25, 3, 0, 50);
