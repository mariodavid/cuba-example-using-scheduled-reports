package de.diedavids.cuba.ceusr.web.screens.lineitem;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.LineItem;

@UiController("ceusr_LineItem.edit")
@UiDescriptor("line-item-edit.xml")
@EditedEntityContainer("lineItemDc")
@LoadDataBeforeShow
public class LineItemEdit extends StandardEditor<LineItem> {
}