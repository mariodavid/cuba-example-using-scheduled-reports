package de.diedavids.cuba.ceusr.web.screens.bigcustomerslist;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.BigCustomersList;

@UiController("ceusr_BigCustomersList.edit")
@UiDescriptor("big-customers-list-edit.xml")
@EditedEntityContainer("bigCustomersListDc")
@LoadDataBeforeShow
public class BigCustomersListEdit extends StandardEditor<BigCustomersList> {
}