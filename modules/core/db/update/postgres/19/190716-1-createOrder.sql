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
);