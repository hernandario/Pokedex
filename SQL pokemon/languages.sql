DROP TABLE IF EXISTS "languages";
CREATE TABLE languages (
	id INTEGER NOT NULL, 
	iso639 VARCHAR(79) NOT NULL, 
	iso3166 VARCHAR(79) NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	official BOOLEAN NOT NULL, 
	"order" INTEGER, 
	PRIMARY KEY (id), 
	CHECK (official IN (0, 1))
);
INSERT INTO "languages" VALUES(1,'ja','jp','ja',1,1);
INSERT INTO "languages" VALUES(2,'ja','jp','roomaji',1,3);
INSERT INTO "languages" VALUES(3,'ko','kr','ko',1,4);
INSERT INTO "languages" VALUES(4,'zh','cn','zh',1,5);
INSERT INTO "languages" VALUES(5,'fr','fr','fr',1,7);
INSERT INTO "languages" VALUES(6,'de','de','de',1,8);
INSERT INTO "languages" VALUES(7,'es','es','es',1,9);
INSERT INTO "languages" VALUES(8,'it','it','it',1,10);
INSERT INTO "languages" VALUES(9,'en','us','en',1,6);
INSERT INTO "languages" VALUES(10,'cs','cz','cs',0,11);
INSERT INTO "languages" VALUES(11,'ja','jp','ja-kanji',1,2);
