package de.diedavids.cuba.ceusr.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.Customer;

@UiController("ceusr_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}