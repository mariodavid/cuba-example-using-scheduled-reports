alter table CEUSR_LINE_ITEM add constraint FK_CEUSR_LINE_ITEM_ON_PRODUCT foreign key (PRODUCT_ID) references CEUSR_PRODUCT(ID);
alter table CEUSR_LINE_ITEM add constraint FK_CEUSR_LINE_ITEM_ON_ORDER foreign key (ORDER_ID) references CEUSR_ORDER(ID);
create index IDX_CEUSR_LINE_ITEM_ON_PRODUCT on CEUSR_LINE_ITEM (PRODUCT_ID);
create index IDX_CEUSR_LINE_ITEM_ON_ORDER on CEUSR_LINE_ITEM (ORDER_ID);