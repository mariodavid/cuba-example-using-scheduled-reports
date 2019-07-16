package de.diedavids.cuba.ceusr.core;

import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.reports.entity.Report;
import com.haulmont.reports.entity.ReportTemplate;
import de.diedavids.cuba.scheduledreports.ScheduledReportExtension;
import de.diedavids.cuba.scheduledreports.entity.ScheduledReport;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component(MonthlySalesReportScheduledReportExtension.NAME)
public class MonthlySalesReportScheduledReportExtension implements ScheduledReportExtension {

    public static final String NAME = "ceusr_WeeklySalesReportScheduledReportExtension";

    @Inject
    protected TimeSource timeSource;


    /**
     * this sales report extension checks for a particular scheduled report code to enrich
     */
    @Override
    public boolean supports(ScheduledReport scheduledReport) {
        return scheduledReport.getCode().equals("sales-report-monthly");
    }

    /**
     * the report contains a parameter "from", "to" and "month", that has to passed in
     *
     * the extension can configure the report with that parameter
     *
     * Currently the value is hard-coded in this extension class, but it can also be a result
     * of a calculation on the current date e.g.
     */
    @Override
    public Map<String, Object> provideParameters(ScheduledReport scheduledReport) {


        Map<String, Object> params = new HashMap<>();
        params.put("from", toDate(salesReportPeriod().atDay(1)));
        params.put("to", toDate(salesReportPeriod().atEndOfMonth()));
        params.put("month", salesReportPeriod().toString());
        return params;
    }


    private YearMonth currentYearMonth() {
        return YearMonth.from(today());
    }

    private YearMonth salesReportPeriod() {
        return currentYearMonth().minusMonths(1);
    }

    private Date toDate(LocalDate localDate) {
        return Date.valueOf(localDate);

    }
    /**
     * the filename should contain the current date as part of the filename
     */
    @Override
    public Optional<String> provideFilename(ScheduledReport scheduledReport, ReportTemplate reportTemplate) {
        return Optional.of("sales-report-" + salesReportPeriod().toString());
    }

    /**
     * this report should be always only until 2021, because afterwards there is a new report structure in place
     */
    @Override
    public boolean shouldBeExecuted(ScheduledReport scheduledReport) {
        return today().isBefore(LocalDate.of(2021,1,1));
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