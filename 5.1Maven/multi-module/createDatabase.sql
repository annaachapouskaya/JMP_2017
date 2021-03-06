 create tablespace ANIMAL_SHELTER_TABSPACE datafile 'ANIMAL_SHELTER_TABSPACE.dat' size 10M autoextend on;
 create temporary tablespace ANIMAL_SHELTER_TABSPACE_TEMP tempfile 'ANIMAL_SHELTER_TABSPACE_TEMP.dat' size 5M autoextend on;
 create user ANIMAL_SHELTER identified by ANIMAL_SHELTER default tablespace ANIMAL_SHELTER_TABSPACE temporary tablespace ANIMAL_SHELTER_TABSPACE_TEMP;
 grant create session to ANIMAL_SHELTER;
 grant create table to ANIMAL_SHELTER;
 grant create sequence to ANIMAL_SHELTER;
 grant unlimited tablespace to ANIMAL_SHELTER;
 
   CREATE TABLE "ANIMAL_SHELTER"."PET" 
   (	"ID" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"AGE" NUMBER, 
	"HISTORY" NVARCHAR2(500), 
	"NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"SEX" VARCHAR2(20 BYTE), 
	"TYPE" VARCHAR2(20 BYTE), 
	 CONSTRAINT "PET_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE" ;
  
    CREATE TABLE "ANIMAL_SHELTER"."CAT" 
   (	"ID" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"BREED" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"CHARACTER" VARCHAR2(20 BYTE), 
	"WOOL_LENGTH" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "CAT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE"  ENABLE, 
	 CONSTRAINT "CAT_FK1" FOREIGN KEY ("ID")
	  REFERENCES "ANIMAL_SHELTER"."PET" ("ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE" ;
  
    CREATE TABLE "ANIMAL_SHELTER"."DOG" 
   (	"ID" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"BREED" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"CHARACTER" VARCHAR2(20 BYTE), 
	 CONSTRAINT "DOG_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE"  ENABLE, 
	 CONSTRAINT "DOG_FK1" FOREIGN KEY ("ID")
	  REFERENCES "ANIMAL_SHELTER"."PET" ("ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE" ;
  
  CREATE TABLE "ANIMAL_SHELTER"."BIRD" 
   (	"ID" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"BREED" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"IS_SINGING" NUMBER(1,0) NOT NULL ENABLE, 
	 CONSTRAINT "BIRD_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE"  ENABLE, 
	 CONSTRAINT "BIRD_FK1" FOREIGN KEY ("ID")
	  REFERENCES "ANIMAL_SHELTER"."PET" ("ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "ANIMAL_SHELTER_TABSPACE" ;
  
 CREATE SEQUENCE  "ANIMAL_SHELTER"."HIBERNATE_SEQUENCE"  MINVALUE 0 MAXVALUE 10000 INCREMENT BY 1 START WITH 10 NOCACHE  ORDER  NOCYCLE ;
