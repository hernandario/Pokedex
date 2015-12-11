DROP TABLE IF EXISTS "types";
CREATE TABLE types (
	id INTEGER NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	generation_id INTEGER NOT NULL, 
	damage_class_id INTEGER, 
	PRIMARY KEY (id), 
	FOREIGN KEY(generation_id) REFERENCES generations (id), 
	FOREIGN KEY(damage_class_id) REFERENCES move_damage_classes (id)
);
INSERT INTO "types" VALUES(1,'normal',1,2);
INSERT INTO "types" VALUES(2,'fighting',1,2);
INSERT INTO "types" VALUES(3,'flying',1,2);
INSERT INTO "types" VALUES(4,'poison',1,2);
INSERT INTO "types" VALUES(5,'ground',1,2);
INSERT INTO "types" VALUES(6,'rock',1,2);
INSERT INTO "types" VALUES(7,'bug',1,2);
INSERT INTO "types" VALUES(8,'ghost',1,2);
INSERT INTO "types" VALUES(9,'steel',2,2);
INSERT INTO "types" VALUES(10,'fire',1,3);
INSERT INTO "types" VALUES(11,'water',1,3);
INSERT INTO "types" VALUES(12,'grass',1,3);
INSERT INTO "types" VALUES(13,'electric',1,3);
INSERT INTO "types" VALUES(14,'psychic',1,3);
INSERT INTO "types" VALUES(15,'ice',1,3);
INSERT INTO "types" VALUES(16,'dragon',1,3);
INSERT INTO "types" VALUES(17,'dark',2,3);
INSERT INTO "types" VALUES(18,'fairy',6,NULL);
INSERT INTO "types" VALUES(10001,'unknown',2,NULL);
INSERT INTO "types" VALUES(10002,'shadow',3,NULL);
