package de.diedavids.cuba.ceusr.core;

import com.haulmont.cuba.core.global.DataManager;
import de.diedavids.cuba.ceusr.entity.BigCustomersList;
import de.diedavids.cuba.scheduledreports.entity.ScheduledReportExecution;
import de.diedavids.cuba.scheduledreports.events.ScheduledReportRun;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Component(BigCustomersListSaver.NAME)
public class BigCustomersListSaver implements ApplicationListener<ScheduledReportRun> {


    public static final String NAME = "ceusr_BigCustomersListSaver";

    @Inject
    protected DataManager dataManager;


    @Override
    public void onApplicationEvent(ScheduledReportRun scheduledReportRun) {

        ScheduledReportExecution reportExecution = scheduledReportRun.getReportExecution();
        String scheduledReportCode = reportExecution.getScheduledReport().getCode();

        if (Objects.equals(scheduledReportCode,"big-customers")) {
            BigCustomersList bigCustomersList = dataManager.create(BigCustomersList.class);
            bigCustomersList.setFrom(toLocalDate(reportExecution.getExecutedAt()));
            bigCustomersList.setBigCustomerListFile(scheduledReportRun.getReportFile());
            bigCustomersList.setScheduledReportExecution(reportExecution);
            dataManager.commit(bigCustomersList);
        }
    }

    private LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }



}