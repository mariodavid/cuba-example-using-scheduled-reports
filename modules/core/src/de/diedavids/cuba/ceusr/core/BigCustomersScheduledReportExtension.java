package de.diedavids.cuba.ceusr.core;

import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.reports.entity.Report;
import com.haulmont.reports.entity.ReportTemplate;
import de.diedavids.cuba.scheduledreports.ScheduledReportExtension;
import de.diedavids.cuba.scheduledreports.entity.ScheduledReport;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

@Component(BigCustomersScheduledReportExtension.NAME)
public class BigCustomersScheduledReportExtension implements ScheduledReportExtension {

    public static final String NAME = "ceusr_BigCustomersScheduledReportExtension";

    @Inject
    protected TimeSource timeSource;


    /**
     * this customer report extension checks for a particular scheduled report code to enrich
     */
    @Override
    public boolean supports(ScheduledReport scheduledReport) {
        return Objects.equals(
                scheduledReport.getCode(),
                "big-customers"
        );
    }

    /**
     * the report contains a parameter "totalTurnoverThreshold", that has to passed in
     *
     * the extension can configure the report with that parameter
     *
     * Currently the value is hard-coded in this extension class, but it can also be a result
     * of a calculation on the current date e.g.
     */
    @Override
    public Map<String, Object> provideParameters(ScheduledReport scheduledReport) {
        Map<String, Object> params = new HashMap<>();
        params.put("totalTurnoverThreshold", 100);
        return params;
    }

    /**
     * the filename should contain the current date as part of the filename
     */
    @Override
    public Optional<String> provideFilename(ScheduledReport scheduledReport, ReportTemplate reportTemplate) {
        return Optional.of("big-customers-" + today().toString());
    }

    /**
     * this report should be only executed at weekdays
     */
    @Override
    public boolean shouldBeExecuted(ScheduledReport scheduledReport) {

        if (isWeekend()) {
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isWeekend() {
        return todaysWeekday().equals(DayOfWeek.SATURDAY) || todaysWeekday().equals(DayOfWeek.SUNDAY);
    }

    private DayOfWeek todaysWeekday() {
        return today().getDayOfWeek();
    }

    private LocalDate today() {
        ZonedDateTime now = timeSource.now();
        return now.toLocalDate();
    }

    /**
     * no particular report template is provided, therefore the default selection will be used
     */
    @Override
    public Optional<ReportTemplate> provideReportTemplate(ScheduledReport scheduledReport, Report report) {
        return Optional.empty();
    }
}