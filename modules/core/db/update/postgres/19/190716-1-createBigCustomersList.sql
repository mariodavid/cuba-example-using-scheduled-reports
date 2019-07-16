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
);