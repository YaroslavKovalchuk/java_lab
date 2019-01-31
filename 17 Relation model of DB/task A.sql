drop database N1;
create database N1;
use N1;

#-------------------CREATE-------------------------
CREATE TABLE family_satellites(
surname varchar(255) NOT NULL,
firstname varchar(255) NOT NULL,
date_of_birth date NOT NULL,
date_of_death date NULL,
place_of_birth varchar(255) NOT NULL,
place_of_death varchar(255) NULL,
date_of_marriage date NULL
);

CREATE TABLE family_tree(
surname varchar(255) NOT NULL,
firstname varchar(255) NOT NULL,
date_of_birth date NOT NULL,
date_of_death date NULL,
place_of_birth varchar(255) NOT NULL,
place_of_death varchar(255) NULL,
credit_card_number varchar(16) NULL
);

CREATE TABLE sex(
sex ENUM('M','F') NOT NULL PRIMARY KEY
);

CREATE TABLE family_values(
name_value varchar(255) NOT NULL,
estimated_cost real NULL,
max_cost real NULL,
min_cost real NULL,
catalog_code int NOT NULL
);

CREATE TABLE family_tree_and_family_values(
surname varchar(255) NOT NULL,
firstname varchar(255) NOT NULL,
date_of_birth date NOT NULL,
place_of_birth varchar(255) NOT NULL,
catalog_code int NOT NULL
);

#-------------------------ALETR-------------------------------
ALTER TABLE family_satellites ADD 
	CONSTRAINT PK_family_satellites PRIMARY KEY  CLUSTERED 
	(
		surname,firstname,date_of_birth,place_of_birth
	);

ALTER TABLE family_tree ADD 
	CONSTRAINT PK_family_family_tree PRIMARY KEY  CLUSTERED 
	(
		surname,firstname,date_of_birth,place_of_birth
	);


ALTER TABLE family_satellites ADD
		CONSTRAINT FK_family_satellites_AND_family_tree FOREIGN KEY
        (
			surname,firstname,date_of_birth,place_of_birth
        ) REFERENCES family_tree(
			surname,firstname,date_of_birth,place_of_birth
        );

ALTER TABLE family_satellites ADD 
		sex ENUM('M','F');
        
ALTER TABLE family_satellites ADD
		CONSTRAINT FK_family_satellites_AND_sex FOREIGN KEY
        (
			sex
        ) REFERENCES sex(
			sex
        );  
        
ALTER TABLE family_tree ADD
		sex ENUM('M','F');
        
ALTER TABLE family_tree ADD
		CONSTRAINT FK_family_tree_AND_sex FOREIGN KEY
        (
			sex
        ) REFERENCES sex(
			sex
        );

ALTER TABLE family_tree_and_family_values ADD 
	CONSTRAINT PK_family_tree_and_family_values PRIMARY KEY  NONCLUSTERED 
	(
		surname,firstname,date_of_birth,place_of_birth,catalog_code
	);

ALTER TABLE family_tree_and_family_values ADD
		CONSTRAINT FK_family_tree_AND_family_values FOREIGN KEY
        (
			surname,firstname,date_of_birth,place_of_birth
        ) REFERENCES family_tree(
			surname,firstname,date_of_birth,place_of_birth
        )ON DELETE CASCADE;
        
ALTER TABLE family_values ADD 
	CONSTRAINT PK_family_values PRIMARY KEY  NONCLUSTERED 
	(
		catalog_code
	);        
        
ALTER TABLE family_tree_and_family_values ADD
	CONSTRAINT FK_family_values_AND_family_tree_code FOREIGN KEY
        (
			catalog_code
        ) REFERENCES family_values(
			catalog_code
        )ON DELETE CASCADE; 

#------------------------INSERT----------------------------------------
INSERT INTO sex VALUES ('f');
INSERT INTO sex VALUES ('m');

INSERT INTO family_tree VALUES ('Bismarck', 'Iowa', '1942-11-15', '1992-11-15', 'Cuba', 'Cuba', '19621115587968', 'f'); 
INSERT INTO family_tree VALUES ('Bismar', 'Iow', '1943-11-15', '1991-11-15', 'Cub', 'Cub', '19621115587968', 'm'); 
INSERT INTO family_tree VALUES ('Marck', 'Rowa', '1962-11-15', '2002-11-15', 'Tuba', 'Nuba', '19621122587968', 'f'); 

INSERT INTO family_satellites VALUES ('Bismarck', 'Iowa', '1942-11-15', '1992-11-15', 'Cuba', 'Cuba', '1962-11-15', 'f');
INSERT INTO family_satellites VALUES ('Bismar', 'Iow', '1943-11-15', '1991-11-15', 'Cub', 'Cub', '1972-11-15', 'm');
INSERT INTO family_satellites VALUES ('Marck', 'Rowa', '1962-11-15', '2002-11-15', 'Tuba', 'Nuba', '1982-11-15', 'f');

INSERT INTO family_values VALUES ('Missouri',2202.2,10000.5,500.8,25);
INSERT INTO family_values VALUES ('Ssouri',3202.2,20000.5,600.8,35);
INSERT INTO family_values VALUES ('Dissouri',4202.2,30000.5,700.8,45);

INSERT INTO family_tree_and_family_values VALUES('Bismarck', 'Iowa', '1942-11-15','Cuba',25);
INSERT INTO family_tree_and_family_values VALUES('Bismar', 'Iow', '1943-11-15','Cub',35);
INSERT INTO family_tree_and_family_values VALUES('Marck', 'Rowa', '1962-11-15','Tuba',45);

#---------------------Generated Columns-------------------------------------------------
SELECT CONCAT(surname,' ',firstname) AS full_name FROM family_tree;
SELECT CONCAT(firstname,' ',surname,' born ',DAYOFYEAR(date_of_birth),' day ',YEAR(date_of_birth),' years') AS all_info FROM family_satellites;
SELECT SIN(min_cost)+COS(max_cost) AS formula FROM family_values;