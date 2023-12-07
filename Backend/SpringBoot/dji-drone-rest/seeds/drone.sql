create table drone
(
    serial_number    varchar(100)                                                               not null
        primary key,
    battery_capacity int                                                                        not null,
    model            enum ('Lightweight', 'Middleweight', 'Cruiserweight', 'Heavyweight')       not null,
    state            enum ('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING') null,
    weight_limit     int                                                                        not null
);

INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('AB', 50, 'Heavyweight', 'DELIVERING', 50);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('ABC123', 100, 'Heavyweight', 'DELIVERING', 500);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('DJI0004', 100, 'Cruiserweight', 'IDLE', 250);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('DJI0005', 20, 'Cruiserweight', 'IDLE', 250);
INSERT INTO remotedrone.drone (serial_number, battery_capacity, model, state, weight_limit) VALUES ('jsdfhksd', 25, 'Heavyweight', 'IDLE', 50);
