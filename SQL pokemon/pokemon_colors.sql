DROP TABLE IF EXISTS "pokemon_colors";
CREATE TABLE pokemon_colors (
	id INTEGER NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	PRIMARY KEY (id)
);
INSERT INTO "pokemon_colors" VALUES(1,'black');
INSERT INTO "pokemon_colors" VALUES(2,'blue');
INSERT INTO "pokemon_colors" VALUES(3,'brown');
INSERT INTO "pokemon_colors" VALUES(4,'gray');
INSERT INTO "pokemon_colors" VALUES(5,'green');
INSERT INTO "pokemon_colors" VALUES(6,'pink');
INSERT INTO "pokemon_colors" VALUES(7,'purple');
INSERT INTO "pokemon_colors" VALUES(8,'red');
INSERT INTO "pokemon_colors" VALUES(9,'white');
INSERT INTO "pokemon_colors" VALUES(10,'yellow');
