
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "customer_id" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "member_id" varchar(20) COLLATE "pg_catalog"."default",
  "global_id" varchar(20) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."customer" OWNER TO "mybbs";

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO "public"."customer" ("customer_id", "member_id", "global_id") VALUES ('1', '2343c', '33fd');
COMMIT;

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "customer_pkey" PRIMARY KEY ("customer_id");
