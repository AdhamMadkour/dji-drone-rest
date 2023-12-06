create table medication
(
    medication_id       int auto_increment
        primary key,
    code                varchar(255) null,
    image               varchar(255) null,
    name                varchar(255) null,
    drone_serial_number varchar(100) not null,
    constraint FKqyvxk180cr7tw9esu9fhdokou
        foreign key (drone_serial_number) references drone (serial_number)
);

INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (1, 'PK1234', 'painkiller.jpg', 'abogbltreat', 'ABC123', 10);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (2, 'PK1234', 'painkiller.jpg', 'abogbltreat', 'ABC123', 25);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (3, 'PK1234', 'bbblabla.jpg', 'blavla', 'ABC123', 57);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (4, 'PK1234', 'bbblabla.jpg', 'blavla', 'ABC123', 36);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (5, '123456789', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.chemistwarehouse.com.au%2Fbuy%2F100%2FParacetamol-500mg-100-Tablets&psig=AOvVaw1QZ6Z4Z4Z4Z4Z4Z4Z4Z4Z4&ust=1634172021-10-14T13:00:00.000+00:00', 'Paracetamol', 'ABC123', 47);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (6, '123456789', 'dawaa.jpg', 'dawaa', 'AB', 20);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (7, '65433fg', 'bestInTheWest.jpg', 'bestInTheWest', 'AB', 30);
INSERT INTO remotedrone.medication (medication_id, code, image, name, drone_serial_number, weight) VALUES (8, 'PCT', 'paracetamol.jpg', 'Paracetamol', 'DJI0004', 10);
