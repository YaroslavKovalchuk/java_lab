DROP DATABASE N2;
CREATE DATABASE N2;
USE N2;

#-------------------CREATE-------------------------
CREATE TABLE student(
surname varchar(255) NOT NULL,
first_name varchar(255) NOT NULL,
middle_tname varchar(255) NOT NULL,
overal_rating int NULL,
date_of_birth date NOT NULL,
date_of_receipt date NOT NULL,
students_ticket_number varchar(16) NOT NULL,
email varchar(255) NOT NULL
);

CREATE TABLE student_group(
name_of_group varchar(255) NOT NULL,
number_of_group varchar(10) NOT NULL,
date_of_receipt date NOT NULL
);

CREATE TABLE secondary_education(
name_of_place varchar(255) ,
phone_number varchar(12),
director_full_name varchar(255)
);

CREATE TABLE subject_debt(
name_of_subject varchar(255)
);

CREATE TABLE city(
name_of_city varchar(255) NOT NULL
);

CREATE TABLE region(
name_of_region varchar(255) NOT NULL,
code_of_region varchar(25) NOT NULL
);

CREATE TABLE student_and_debpt(
name_of_subject varchar(255),
students_ticket_number varchar(16) NOT NULL
);

ALTER TABLE student ADD (
	name_of_group  varchar(255) NULL,
    number_of_group varchar(10) NULL,
    name_of_place_secondary_education varchar(255) NOT NULL,
	name_of_city varchar(255) NOT NULL
);

ALTER TABLE city ADD(
	name_of_region varchar(255) NOT NULL
);

ALTER TABLE secondary_education ADD(
	name_of_city varchar(255)
);

ALTER TABLE student ADD 
	CONSTRAINT PK_student_ticket PRIMARY KEY  CLUSTERED 
	(
		students_ticket_number
	);
    
ALTER TABLE subject_debt ADD 
	CONSTRAINT PK_subject_debt PRIMARY KEY  CLUSTERED 
	(
		name_of_subject
	);
 
ALTER TABLE student_group ADD 
	CONSTRAINT PK_number_of_group PRIMARY KEY  CLUSTERED 
	(
		name_of_group,number_of_group
	);
    
ALTER TABLE city ADD 
	CONSTRAINT PK_name_of_city PRIMARY KEY  CLUSTERED 
	(
		name_of_city
	);
    
ALTER TABLE region ADD 
	CONSTRAINT PK_name_of_region PRIMARY KEY  CLUSTERED 
	(
		name_of_region
	);
    
ALTER TABLE student ADD
	CONSTRAINT FK_student_and_name_of_group FOREIGN KEY
	(
		name_of_group,number_of_group
	) REFERENCES student_group(
		name_of_group,number_of_group
	);   
    
ALTER TABLE student ADD
	CONSTRAINT FK_student_and_name_of_city FOREIGN KEY
	(
	name_of_city
	) REFERENCES city(
		name_of_city
	);


ALTER TABLE city ADD
	CONSTRAINT FK_city_and_name_of_region FOREIGN KEY
	(
		name_of_region
	) REFERENCES region(
		name_of_region
	);

ALTER TABLE secondary_education ADD
	CONSTRAINT FK_city_and_secondary_education FOREIGN KEY
	(
		name_of_city
	) REFERENCES city(
		name_of_city
	)ON update CASCADE;
    
ALTER TABLE student_and_debpt ADD
	CONSTRAINT FK_student_and_student_and_debpt FOREIGN KEY
	(
		students_ticket_number
	) REFERENCES student(
		students_ticket_number
	);

ALTER TABLE student_and_debpt ADD
	CONSTRAINT FK_student_and_s_and_debpt FOREIGN KEY
	(
		name_of_subject
	) REFERENCES subject_debt(
		name_of_subject
	);
    
    
INSERT INTO region VALUES ('LVIVSKA','066');
INSERT INTO region VALUES ('KIYVSKA','064');
INSERT INTO region VALUES ('TERNOPILSKA','062');

INSERT INTO city VALUES ('Lviv','LVIVSKA');
INSERT INTO city VALUES ('Kiev','KIYVSKA');
INSERT INTO city VALUES ('Ternopli','TERNOPILSKA');

INSERT INTO subject_debt VALUES ('Biologic');
INSERT INTO subject_debt VALUES ('Match');
INSERT INTO subject_debt VALUES ('Geography');  

INSERT INTO student_group VALUES ('SI','11','2010-11-15');
INSERT INTO student_group VALUES ('BI','12','2010-01-25');
INSERT INTO student_group VALUES ('TI','13','2010-01-05');
  
INSERT INTO secondary_education VALUES ('Disouri','kjbhk','Director','Kiev');
INSERT INTO secondary_education VALUES ('Diuri','kjbhk','Director','Lviv');
INSERT INTO secondary_education VALUES ('Rsouri','kjbhk','Director','Ternopli');

INSERT INTO student VALUES ('Koval','Ivan','Petrovysch','115','2000-11-15','2010-11-15','2546489','koval@i.ua','SI','11','Disouri','Lviv');
INSERT INTO student VALUES ('Toval','Svan','Retrovysch','125','2001-11-15','2011-11-15','3546489','roval@i.ua','BI','12','Diuri','Kiev');
INSERT INTO student VALUES ('Roval','Dvan','Tetrovysch','135','2002-11-15','2012-11-15','4546489','poval@i.ua','TI','13','Rsouri','Ternopli');

INSERT INTO student_and_debpt VALUES ('Biologic','2546489');
INSERT INTO student_and_debpt VALUES ('Biologic','3546489');
INSERT INTO student_and_debpt VALUES ('Match','4546489');

SELECT CONCAT(students_ticket_number,' ',YEAR(date_of_receipt)) AS full_student FROM student;
SELECT CONCAT(first_name,' ',surname,' ',middle_tname) AS all_info FROM student;
SELECT YEAR(date_of_receipt)-YEAR(date_of_birth) AS formula FROM student;


