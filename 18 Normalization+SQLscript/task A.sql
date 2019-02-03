drop database N3;
create database N3;
use N3;

#-------------------CREATE-------------------------
CREATE TABLE person(
	id 				int 			auto_increment 	PRIMARY KEY,
	surname 		varchar(255) 	NOT NULL,
	firstname 		varchar(255) 	NOT NULL,
	middle_name 	varchar(255) 	NOT NULL,
	date_of_birth 	date 			NOT NULL,
	photo 			varchar(255) 	NULL,
	autobiography 	varchar(255) 	NULL,
	date_of_entry 	date 			NOT NULL,
    id_group		int				NULL,
    id_city			int				NOT NULL
);

CREATE TABLE result_of_student(
	id 				int 			auto_increment 	PRIMARY KEY,
    first_mudule 	int 			NULL,
    second_mudule 	int 			NULL,
    long_estimate	int				NULL,
    short_estimate	int				NULL,
    id_subject		int 			NOT NULL
);

CREATE TABLE teacher(
	id 				int 			auto_increment 	PRIMARY KEY,
	surname 		varchar(255) 	NOT NULL,
	firstname 		varchar(255) 	NOT NULL,
	middle_name 	varchar(255) 	NOT NULL,
	date_of_birth 	date 			NOT NULL
);

CREATE TABLE group_of_students(
	id 				int 			auto_increment 	PRIMARY KEY,
    name 			varchar(255) 	NOT NULL,
    code 			varchar(55)  	NOT NULL
);

CREATE TABLE city(
	id 				int 			auto_increment  PRIMARY KEY,
	name 			varchar(255) 	NOT NULL
);

CREATE TABLE subject_of_study(
	id 				int 			auto_increment 	PRIMARY KEY,
	name 			varchar(255) 	NOT NULL,
	student_term 	ENUM('FIRST','SECOND') NOT NULL,
    type_of_control ENUM('EXAM','TEST') NOT NULL 
);

CREATE TABLE current_level(
	id 				int 			auto_increment 	PRIMARY KEY,
    student_level	int				NULL,
    studentship	ENUM('STANDART','HIGH') NULL	
    
);

CREATE TABLE teacher_and_subject(
	id_teacher 		int,
    id_subject		int
);

CREATE TABLE person_and_result(
	id_person		int,
    id_result		int
);

#-------------------------ALETR-------------------------------

ALTER TABLE person ADD
		CONSTRAINT FK_person_AND_city FOREIGN KEY
        (
			id_city
        ) REFERENCES city(
			id
        );

ALTER TABLE person ADD
		CONSTRAINT FK_person_AND_group FOREIGN KEY
        (
			id_group
        ) REFERENCES group_of_students(
			id
        );

ALTER TABLE person ADD
		CONSTRAINT FK_person_AND_current_level FOREIGN KEY
        (
			id
        ) REFERENCES current_level(
			id
        );        
        
ALTER TABLE person_and_result ADD
		CONSTRAINT FK_person_and_result_AND_person FOREIGN KEY
        (
			id_person
        ) REFERENCES person(
			id
        );        

ALTER TABLE person_and_result ADD
		CONSTRAINT FK_person_and_result_AND_result FOREIGN KEY
        (
			id_result
        ) REFERENCES result_of_student(
			id
        );     

ALTER TABLE result_of_student ADD
		CONSTRAINT FK_result_of_student_AND_subject_of_study FOREIGN KEY
        (
			id_subject
        ) REFERENCES subject_of_study(
			id
        );     

ALTER TABLE teacher_and_subject ADD
		CONSTRAINT FK_teacher_and_subjectt_AND_teacher FOREIGN KEY
        (
			id_teacher
        ) REFERENCES teacher(
			id
        );
        
ALTER TABLE teacher_and_subject ADD
		CONSTRAINT FK_teacher_and_subject_AND_subject_of_study FOREIGN KEY
        (
			id_subject
        ) REFERENCES subject_of_study(
			id
        );
        
#------------------------INSERT----------------------------------------

INSERT INTO city (name) VALUES 
('Lviv'), 
('Dnipro'),
('Odesa');

INSERT INTO group_of_students (name,code) VALUES 
('SI','11'), 
('SI','12'),
('SI','13');

INSERT INTO teacher (surname,firstname,middle_name,date_of_birth) VALUES 
('Ivanov','Ivan','Ivanovych','1942-11-15'), 
('Petrov','Petro','Pertrovych','1943-11-15'),
('Stepanov','Stepan','Stepanovych','1944-11-15');

INSERT INTO subject_of_study (name,student_term,type_of_control) VALUES 
('Biology','FIRST','EXAM'), 
('Match','SECOND','TEST'),
('History','FIRST','EXAM');

INSERT INTO current_level (student_level,studentship) VALUES 
(87,'STANDART'), 
(55,NULL),
(95,'HIGH');

INSERT INTO teacher_and_subject (id_teacher,id_subject) VALUES 
(1,1), 
(1,2),
(2,3);

INSERT INTO result_of_student (first_mudule, second_mudule, long_estimate, short_estimate, id_subject) VALUES 
(25,25,50,3,1), 
(30,30,60,3,2),
(44,44,88,5,3);

INSERT INTO person (surname, firstname, middle_name, date_of_birth, photo,autobiography,date_of_entry,id_group,id_city) VALUES 
('Ivanov','Ivan','Ivanovych','1942-11-15','1.png','1.txt','2000-08-15',1,1), 
('Petrov','Petro','Pertrovych','1943-11-15','2.png','2.txt','2001-08-15',1,1),
('Stepanov','Stepan','Stepanovych','1944-11-15','3.png','2.txt','2002-08-15',1,1);




        