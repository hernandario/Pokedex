DROP TABLE IF EXISTS "regions";
CREATE TABLE regions (
	id INTEGER NOT NULL, 
	identifier VARCHAR(79) NOT NULL, 
	PRIMARY KEY (id)
);
INSERT INTO "regions" VALUES(1,'kanto');
INSERT INTO "regions" VALUES(2,'johto');
INSERT INTO "regions" VALUES(3,'hoenn');
INSERT INTO "regions" VALUES(4,'sinnoh');
INSERT INTO "regions" VALUES(5,'unova');
INSERT INTO "regions" VALUES(6,'kalos');
