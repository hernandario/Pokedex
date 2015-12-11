DROP TABLE IF EXISTS "versions";
CREATE TABLE versions (
	id INTEGER NOT NULL, 
	version_group_id INTEGER NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	PRIMARY KEY (id), 
	FOREIGN KEY(version_group_id) REFERENCES version_groups (id)
);
INSERT INTO "versions" VALUES(1,1,'red');
INSERT INTO "versions" VALUES(2,1,'blue');
INSERT INTO "versions" VALUES(3,2,'yellow');
INSERT INTO "versions" VALUES(4,3,'gold');
INSERT INTO "versions" VALUES(5,3,'silver');
INSERT INTO "versions" VALUES(6,4,'crystal');
INSERT INTO "versions" VALUES(7,5,'ruby');
INSERT INTO "versions" VALUES(8,5,'sapphire');
INSERT INTO "versions" VALUES(9,6,'emerald');
INSERT INTO "versions" VALUES(10,7,'firered');
INSERT INTO "versions" VALUES(11,7,'leafgreen');
INSERT INTO "versions" VALUES(12,8,'diamond');
INSERT INTO "versions" VALUES(13,8,'pearl');
INSERT INTO "versions" VALUES(14,9,'platinum');
INSERT INTO "versions" VALUES(15,10,'heartgold');
INSERT INTO "versions" VALUES(16,10,'soulsilver');
INSERT INTO "versions" VALUES(17,11,'black');
INSERT INTO "versions" VALUES(18,11,'white');
INSERT INTO "versions" VALUES(19,12,'colosseum');
INSERT INTO "versions" VALUES(20,13,'xd');
INSERT INTO "versions" VALUES(21,14,'black-2');
INSERT INTO "versions" VALUES(22,14,'white-2');
INSERT INTO "versions" VALUES(23,15,'x');
INSERT INTO "versions" VALUES(24,15,'y');
