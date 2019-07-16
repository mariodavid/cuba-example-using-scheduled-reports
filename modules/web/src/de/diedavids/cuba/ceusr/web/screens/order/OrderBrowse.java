package de.diedavids.cuba.ceusr.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.Order;

@UiController("ceusr_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}