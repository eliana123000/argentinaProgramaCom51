use tpexamenfinal;
CREATE TABLE alumnos(
id INT (30) PRIMARY KEY AUTO_INCREMENT,
legajo int,
nombre VARCHAR (100),
apellido VARCHAR (100) 
);

CREATE TABLE materias (
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    materias VARCHAR(100));
    
CREATE TABLE alumnosmaterias (
idalumno INT,
idmateria INT,
FOREIGN KEY (idalumno) REFERENCES alumnos(id),
FOREIGN KEY (idmateria) REFERENCES materias(id));

CREATE TABLE correlativas (
idMAT INT,
idcorrelativa INT,
FOREIGN KEY (idMAT) REFERENCES materias(id));
