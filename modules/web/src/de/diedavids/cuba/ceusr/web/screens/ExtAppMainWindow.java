package de.diedavids.cuba.ceusr.web.screens;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.screen.MessageBundle;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;
import de.diedavids.cuba.ceusr.entity.BigCustomersList;

import javax.inject.Inject;
import java.util.Optional;

public class ExtAppMainWindow extends AppMainWindow {

    @Inject
    protected ExportDisplay exportDisplay;

    @Inject
    protected DataManager dataManager;
    @Inject
    protected Notifications notifications;
    @Inject
    protected MessageBundle messageBundle;

    @Subscribe("downloadCurrentBigCustomerReport")
    protected void onDownloadCurrentBigCustomerReportClick(Button.ClickEvent event) {
        Optional<BigCustomersList> newestBigCustomerList = dataManager.load(BigCustomersList.class)
                .query("select e from ceusr_BigCustomersList e order by e.from desc")
                .view("bigCustomersList-view")
                .maxResults(1)
                .optional();

        if (newestBigCustomerList.isPresent()) {
            exportDisplay.show(
                    newestBigCustomerList.get().getBigCustomerListFile()
            );
        }
        else {
            notifications.create(Notifications.NotificationType.ERROR)
                    .withCaption(messageBundle.getMessage("noBigCustomerListAvailable"))
                    .show();
        }

    }
    
    
}