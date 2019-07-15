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
