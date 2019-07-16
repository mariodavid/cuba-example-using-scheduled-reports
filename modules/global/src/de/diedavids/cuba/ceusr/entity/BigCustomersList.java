package de.diedavids.cuba.ceusr.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import de.diedavids.cuba.scheduledreports.entity.ScheduledReportExecution;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "CEUSR_BIG_CUSTOMERS_LIST")
@Entity(name = "ceusr_BigCustomersList")
public class BigCustomersList extends StandardEntity {
    private static final long serialVersionUID = 2674213596639733402L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SCHEDULED_REPORT_EXECUTION_ID")
    protected ScheduledReportExecution scheduledReportExecution;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BIG_CUSTOMER_LIST_FILE_ID")
    protected FileDescriptor bigCustomerListFile;

    @NotNull
    @Column(name = "FROM_", nullable = false)
    protected LocalDate from;

    public FileDescriptor getBigCustomerListFile() {
        return bigCustomerListFile;
    }

    public void setBigCustomerListFile(FileDescriptor bigCustomerListFile) {
        this.bigCustomerListFile = bigCustomerListFile;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public ScheduledReportExecution getScheduledReportExecution() {
        return scheduledReportExecution;
    }

    public void setScheduledReportExecution(ScheduledReportExecution scheduledReportExecution) {
        this.scheduledReportExecution = scheduledReportExecution;
    }
}