## CUBA example - using scheduled reports

This CUBA example uses the [scheduled-report application component](https://github.com/mariodavid/cuba-component-scheduled-reports) and shows
some use-cases for having scheduled reports.

### Example Domain - Order management

The domain model of the application looks like this:

![Domain model](https://github.com/mariodavid/cuba-example-using-scheduled-reports/blob/master/img/domain-model.png)

### Scheduled Report #1 - Big customers

One scheduled report that has to be send out to the whole organisation is the report "Big Customers".

It is a excel sheet that contains all customers that have reached a particular total turnover value.
