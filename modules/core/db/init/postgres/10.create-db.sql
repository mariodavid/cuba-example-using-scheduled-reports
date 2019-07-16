-- begin CEUSR_CUSTOMER
create table CEUSR_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TOTAL_TURNOVER decimal(19, 2),
    --
    primary key (ID)
)^
-- end CEUSR_CUSTOMER
-- begin CEUSR_ORDER
create table CEUSR_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    CUSTOMER_ID uuid,
    TOTAL_AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end CEUSR_ORDER
-- begin CEUSR_LINE_ITEM
create table CEUSR_LINE_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID uuid not null,
    AMOUNT integer not null,
    TOTAL_PRICE decimal(19, 2) not null,
    ORDER_ID uuid not null,
    --
    primary key (ID)
)^
-- end CEUSR_LINE_ITEM
-- begin CEUSR_PRODUCT
create table CEUSR_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION text,
    PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end CEUSR_PRODUCT
-- begin CEUSR_BIG_CUSTOMERS_LIST
create table CEUSR_BIG_CUSTOMERS_LIST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHEDULED_REPORT_EXECUTION_ID uuid not null,
    BIG_CUSTOMER_LIST_FILE_ID uuid not null,
    FROM_ date not null,
    --
    primary key (ID)
)^
-- end CEUSR_BIG_CUSTOMERS_LIST
