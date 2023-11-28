INSERT INTO "public"."test" ("id", "name", "value") VALUES (1, 'alan', 'hello');
INSERT INTO "public"."test" ("id", "name", "value") VALUES (2, 'bob', 'world');

INSERT INTO "public"."tshard_1" ("id", "name", "value") VALUES (1, 'bob1', 'world1');
INSERT INTO "public"."tshard_1" ("id", "name", "value") VALUES (3, 'bob3', 'world3');
INSERT INTO "public"."tshard_1" ("id", "name", "value") VALUES (5, 'bob4', 'world4');
INSERT INTO "public"."tshard_0" ("id", "name", "value") VALUES (2, 'bob2', 'world2');
INSERT INTO "public"."tshard_0" ("id", "name", "value") VALUES (4, 'bob4', 'world4');
INSERT INTO "public"."tshard_0" ("id", "name", "value") VALUES (6, 'bob6', 'world6');
