-- begin CEUSR_CUSTOMER
create table CEUSR_CUSTOMER (
    ID varchar(36) not null,
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
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    CUSTOMER_ID varchar(36),
    TOTAL_AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end CEUSR_ORDER
-- begin CEUSR_LINE_ITEM
create table CEUSR_LINE_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(36) not null,
    AMOUNT integer not null,
    TOTAL_PRICE decimal(19, 2) not null,
    ORDER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CEUSR_LINE_ITEM
-- begin CEUSR_PRODUCT
create table CEUSR_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longvarchar,
    PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end CEUSR_PRODUCT
-- begin CEUSR_BIG_CUSTOMERS_LIST
create table CEUSR_BIG_CUSTOMERS_LIST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SCHEDULED_REPORT_EXECUTION_ID varchar(36) not null,
    BIG_CUSTOMER_LIST_FILE_ID varchar(36) not null,
    FROM_ date not null,
    --
    primary key (ID)
)^
-- end CEUSR_BIG_CUSTOMERS_LIST
