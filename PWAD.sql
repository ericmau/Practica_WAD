show databases;
use wad_p02;
show tables;

desc centrodetrabajo;
desc carrera;
desc alumnos;
desc materia;
desc alumnos_has_materia;
desc preguntas;
desc respuestas;

select * from centrodetrabajo;
select * from carrera;
select * from materia;
select * from alumnos;
select * from evaluacion;
select * from Preguntas;
select count(*) from Preguntas;

insert into centrodetrabajo (nombreCentroTrabajo) values('IPN');
insert into carrera (nombreCarrera,duracion,CentroDeTrabajo_idCentroDeTrabajo) values('ESCOM',4,1);
insert into alumnos (Nombre,Paterno,Materno,email,Carrera_idCarrera) values('Diego','Aguilar','Mayen','d@gmail.com',1);
insert into alumnos (Nombre,Paterno,Materno,email,Carrera_idCarrera) values('Eric','Gonzalez','Alonso','eric@gmail.com',1);
insert into alumnos (Nombre,Paterno,Materno,email,Carrera_idCarrera) values('Mariana','Cabanas','Silva','m29@gmail.com',1);
insert into alumnos (Nombre,Paterno,Materno,email,Carrera_idCarrera) values('Diego','Leon','Nolasco','leon@gmail.com',1);
insert into alumnos (Nombre,Paterno,Materno,email,Carrera_idCarrera) values('admin','admin','admin','admin@gmail.com',1);
insert into materia (Nombre,Creditos,Calificacion) values('WAD',12,0);
insert into materia (Nombre,Creditos,Calificacion) values('COMPILADORES',10,0);
insert into materia (Nombre,Creditos,Calificacion) values('MATEMATICAS',8,0);
insert into materia (Nombre,Creditos,Calificacion) values('PROYECTOS',12,0);
insert into materia (Nombre,Creditos,Calificacion) values('POO',10,0);
insert into materia (Nombre,Creditos,Calificacion) values('SO',8,0);
insert into materia (Nombre,Creditos,Calificacion) values('BD',12,0);

insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,1);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,2);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,3);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,4);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,5);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,6);
insert into alumnos_has_materia(Alumnos_idAlumnos,Materia_idMateria) values (1,7);

insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion WAD',1);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion COMPILADORES',2);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion MATEMATICAS',3);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion PROYECTOS',4);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion POO',5);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion SO',6);
insert into Evaluacion (Evaluacioncol,Materia_idMateria) values('1 Evaluacion BD',7);

insert into Respuestas (RespuestaA,RespuestaB,RespuestaC,RCorrecta) values('Web Application Development','Web Acces Data','Wey Amor Dame','a');
insert into Preguntas (Pregunta,Evaluacion_idEvaluacion,Respuestas_idRespuestas) 
			values('¿Que significa WAD?',1,1);

insert into Respuestas (RespuestaA,RespuestaB,RespuestaC,RCorrecta) values('Clase de Java sin main para HTML dinamico','Manejo de aplicaicones swing',
																	'Las dos anteriores','a');
insert into Preguntas (Pregunta,Evaluacion_idEvaluacion,Respuestas_idRespuestas) 
			values('¿Que es un servlet?',1,2);

insert into Respuestas (RespuestaA,RespuestaB,RespuestaC,RCorrecta) values('JAAS Single People','Java Server Page','Java Super Placeholder','b');
insert into Preguntas (Pregunta,Evaluacion_idEvaluacion,Respuestas_idRespuestas) 
			values('¿Que Significa JSP?',1,3);

select m.nombre from alumnos a,materia m where a.idAlumnos=1;

select r.RCorrecta from Preguntas p JOIN Respuestas r ON p.Respuestas_idRespuestas=r.idRespuestas;

select * from Respuestas;

