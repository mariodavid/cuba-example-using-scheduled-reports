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
);