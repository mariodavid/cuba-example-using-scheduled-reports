package de.diedavids.cuba.ceusr.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.Customer;

@UiController("ceusr_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}