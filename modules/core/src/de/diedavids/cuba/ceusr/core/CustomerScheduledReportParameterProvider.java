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

@Component(CustomerScheduledReportParameterProvider.NAME)
public class CustomerScheduledReportParameterProvider implements ScheduledReportExtension {

    public static final String NAME = "ceusr_CustomerScheduledReportParameterProvider";
    @Inject
    protected TimeSource timeSource;


    @Override
    public boolean supports(ScheduledReport scheduledReport) {
        return scheduledReport.getCode().equals("big-customers");
    }

    @Override
    public Map<String, Object> provideParameters(ScheduledReport scheduledReport) {
        Map<String, Object> params = new HashMap<>();
        params.put("totalTurnoverThreshold", 100);
        return params;
    }

    @Override
    public Optional<String> provideFilename(ScheduledReport scheduledReport, ReportTemplate reportTemplate) {
        return Optional.of("big-customers-" + today().toString());
    }

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

    @Override
    public Optional<ReportTemplate> provideReportTemplate(ScheduledReport scheduledReport, Report report) {
        return Optional.empty();
    }
}