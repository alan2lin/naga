DROP SEQUENCE if exists test_id_seq ;
CREATE SEQUENCE test_id_seq START 3;

CREATE TABLE "public"."test" (
  "id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default",
  PRIMARY KEY ("id")
)
;
ALTER TABLE "public"."test" ALTER COLUMN "id" SET DEFAULT nextval('test_id_seq'::regclass);


ALTER TABLE "public"."test"
  OWNER TO "mybbs";

CREATE TABLE "public"."tshard_0" (
  "id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default",
  PRIMARY KEY ("id")
)
;


ALTER TABLE "public"."tshard_0"
  OWNER TO "mybbs";


CREATE TABLE "public"."tshard_1" (
  "id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default",
  PRIMARY KEY ("id")
)
;


ALTER TABLE "public"."tshard_1"
  OWNER TO "mybbs";
