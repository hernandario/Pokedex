DROP TABLE IF EXISTS "version_groups";
CREATE TABLE version_groups (
	id INTEGER NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	generation_id INTEGER NOT NULL, 
	"order" INTEGER, 
	PRIMARY KEY (id), 
	UNIQUE (identifier), 
	FOREIGN KEY(generation_id) REFERENCES generations (id)
);
INSERT INTO "version_groups" VALUES(1,'red-blue',1,1);
INSERT INTO "version_groups" VALUES(2,'yellow',1,2);
INSERT INTO "version_groups" VALUES(3,'gold-silver',2,3);
INSERT INTO "version_groups" VALUES(4,'crystal',2,4);
INSERT INTO "version_groups" VALUES(5,'ruby-sapphire',3,5);
INSERT INTO "version_groups" VALUES(6,'emerald',3,6);
INSERT INTO "version_groups" VALUES(7,'firered-leafgreen',3,9);
INSERT INTO "version_groups" VALUES(8,'diamond-pearl',4,10);
INSERT INTO "version_groups" VALUES(9,'platinum',4,11);
INSERT INTO "version_groups" VALUES(10,'heartgold-soulsilver',4,12);
INSERT INTO "version_groups" VALUES(11,'black-white',5,13);
INSERT INTO "version_groups" VALUES(12,'colosseum',3,7);
INSERT INTO "version_groups" VALUES(13,'xd',3,8);
INSERT INTO "version_groups" VALUES(14,'black-2-white-2',5,14);
INSERT INTO "version_groups" VALUES(15,'x-y',6,15);
