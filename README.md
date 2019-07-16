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
