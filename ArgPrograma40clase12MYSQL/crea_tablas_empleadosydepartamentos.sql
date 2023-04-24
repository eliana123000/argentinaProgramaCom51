use ejguia12_qatar2022;
CREATE TABLE departamentos(
id INT (30) PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (100),
presupuesto_asignado FLOAT 
);

CREATE TABLE empleados (
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    dni INT(9),
    nacionalidad VARCHAR(30),
    departamentoid INT,
    FOREIGN KEY (departamentoid) REFERENCES departamentos(id)
);