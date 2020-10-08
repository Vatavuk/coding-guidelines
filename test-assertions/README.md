The more assertions a test has, the less readable and reusable it becomes. Ideally a test should have only one assert statement. This is often not possible, however we should strive towards this goal.
In order to achieve this, tests should focus more on matching objects not variables. This way of thinking can significantly reduce amount of duplicated code and
increase reusability.

This module contains an example using junit for matching variables vs http://hamcrest.org/JavaHamcrest/tutorial[Hamcrest library] for matching objects.
