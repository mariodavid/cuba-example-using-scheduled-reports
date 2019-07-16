package de.diedavids.cuba.ceusr.web.screens.bigcustomerslist;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.BigCustomersList;

@UiController("ceusr_BigCustomersList.browse")
@UiDescriptor("big-customers-list-browse.xml")
@LookupComponent("bigCustomersListsTable")
@LoadDataBeforeShow
public class BigCustomersListBrowse extends StandardLookup<BigCustomersList> {
}