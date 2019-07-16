package de.diedavids.cuba.ceusr.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceusr.entity.Product;

@UiController("ceusr_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ProductBrowse extends MasterDetailScreen<Product> {
}