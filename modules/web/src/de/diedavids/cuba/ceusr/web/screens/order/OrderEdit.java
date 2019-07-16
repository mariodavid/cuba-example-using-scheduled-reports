package de.diedavids.cuba.ceusr.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.Order;

@UiController("ceusr_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}