CREATE TABLE "public"."test" (
  "id" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default",
  PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."test"
  OWNER TO "mybbs";