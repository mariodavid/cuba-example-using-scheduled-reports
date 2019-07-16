## CUBA example - using scheduled reports

This CUBA example uses the [scheduled-report application component](https://github.com/mariodavid/cuba-component-scheduled-reports) and shows
some use-cases for having scheduled reports.

### Example Domain - Order management

The domain model of the application looks like this:

![Domain model](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/domain-model.png)


### Scheduled Report #1 - Big customers

One scheduled report that has to be available to the whole organisation is the report "Big Customers".

It is a excel sheet that contains all customers that have reached a particular total turnover value.

![big customer report result](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/big-customers-result.png)

C-Level management wants every employee in the company to download the report daily and print it, in oder
to ensure that whenever one of those customers calls in - they can be handled with the proper respect they deserve.

#### Scheduled Report configuration

![big customer scheduled report](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/big-customers-scheduled-report.png)

#### Scheduled Report execution overview
![big customer scheduled report execution](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/big-customers-execution.png)


#### Programmatic Interaction with the Resulting Report File

It is also possible to interact with the result of the scheduled report execution.

The application component sends out an Event via CUBAs Event mechanism. In this example, the result file
should be stored in a reference to a particular business entity: [BigCustomerList](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/modules/global/src/de/diedavids/cuba/ceusr/entity/BigCustomersList.java), which stores
the big customer list for every day.

It gives the users the ability to see the different lists for each day, without need to interact with the scheduled report execution screens.

In this example the Spring bean [BigCustomersListSaver](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/modules/core/src/de/diedavids/cuba/ceusr/core/BigCustomersListSaver.java#L27) listens to the `ScheduledReportRun` event from the scheduled-reports application component:

```
@Component(BigCustomersListSaver.NAME)
public class BigCustomersListSaver implements ApplicationListener<ScheduledReportRun> {

    public static final String NAME = "ceusr_BigCustomersListSaver";

    @Inject
    protected DataManager dataManager;

    @Override
    public void onApplicationEvent(ScheduledReportRun scheduledReportRun) {

        ScheduledReportExecution reportExecution = scheduledReportRun.getReportExecution();
        String scheduledReportCode = reportExecution.getScheduledReport().getCode();

        if (scheduledReportCode.equals("big-customers")) {
            BigCustomersList bigCustomersList = dataManager.create(BigCustomersList.class);
            bigCustomersList.setFrom(toLocalDate(reportExecution.getExecutedAt()));
            bigCustomersList.setBigCustomerListFile(scheduledReportRun.getReportFile());
            bigCustomersList.setScheduledReportExecution(reportExecution);
            dataManager.commit(bigCustomersList);
        };
    }

    private LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
```

The event contains the report execution as well as the report file. With those two attributes it is possible to
identify in the event listener if the listener should be executed for this report run.

In this example a new `BigCustomersList` entity is created and the references to the FileDescriptor are stored
in the business entity.

The last remaining piece is a button on the main screen, that acts on the `BigCustomersList` entity, and fetch the latest
entity instance and downloads the file.

![main window button](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/main-window-button.png)


### Scheduled Report #1 - Sales Report

One scheduled report that has to be send out to the C-Level executives is the report "Sales Report".

It is an executive summary presented as a Word document that contains all sales of the last month.

![sales report result](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/sales-report-result.png)

C-Level management wants to be informed in a timely manner via Email with the attached report. The report
has to be send out monthly on the first of the month containing the data from the previous sales month.


#### Scheduled Report configuration

![sales report scheduled report](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/sales-report-scheduled-report.png)

#### Scheduled Report Email template

![sales report scheduled email template](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/sales-report-email-template.png)

#### Scheduled Report Execution

![sales report scheduled execution details](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/sales-report-execution.png)
