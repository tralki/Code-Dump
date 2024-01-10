

1. https://dusted.codes/drawbacks-of-stored-procedures
2. https://www.sqlshack.com/sql-server-stored-procedures-for-beginners/
3. https://www.w3schools.com/sql/sql_stored_procedures.asp
4. https://searchoracle.techtarget.com/definition/stored-procedure



-- *********************************************************************************************
Benefits of using a stored procedure

It can be easily modified
We can easily modify the code inside the stored procedure without the need to restart or deploying the application.
For example, If the SQL queries are written in the application and if we need to change the logic, we must change the code in the application and re-deploy it.
Stored procedures eliminate such challenges by storing the code in the database. so, when we want to change the logic inside the procedure we can just do it by simple ALTER PROCEDURE statement.

Performance
The SQL Server stored procedure when executed for the first time creates a plan and stores it in the buffer pool so that the plan can be reused when it executes next time.
The use of stored procedures can reduce network traffic between clients and servers because the commands are executed as a single batch of code. This means only the call to execute the procedure is sent over a network, instead of every single line of code being sent individually.

Reusable
Stored procedures can be executed by multiple users or multiple client applications without the need of writing the code again.

Security
Stored procedures reduce the threat by eliminating direct access to the tables. we can also encrypt the stored procedures while creating them so that the source code inside the stored procedure is not visible.

Easier to troubleshoot
Stored procedures offer advantages over embedding queries in a graphical user interface (GUI).
Since stored procedures are modular, it is easier to troubleshoot when a problem arises in an application.
Stored procedures are also tunable, which eliminates the need to modify the GUI source code to improve its performance.
It’s easier to code stored procedures than to build a query through a GUI.



-- *********************************************************************************************
The disadvantage of Stored Procedure


Hard to Testing
First and foremost business logic which is encapsulated in stored procedures becomes very difficult to test (if tested at all).
Some developers prefer to write a thin data access layer on top of stored procedures to work around this issue, but even in this instance, the extent of testing is mostly limited to a few integration tests only.
Writing unit tests for any business logic inside a stored procedure is not possible, because there is no way to clearly separate the domain logic from the actual data. Mocking, faking, or stubbing won’t be possible either.

Hard to Debug
Depending on the database technology debugging stored procedures will either not be possible at all or extremely clunky.
Some relational databases, such as SQL Server, have some debugging capabilities and others none.
There’s nothing worse than having to use a database profiler to track down an application issue or to debug your database via print statements.

Versioning
Versioning is another crucial feature that stored procedures don’t support out of the box.
Putting stored procedure changes into re-runnable scripts and placing them into a version control system is certainly advisable, but it doesn’t solve the problem that there is nothing inside a stored procedure that tells us which version a stored procedure is on and if there wasn’t any other change being made after the latest script had been applied.
Hard to manage history

Similar to versioning, there’s no history attached to stored procedures.
Specifically if business logic spans across multiple stored procedures then it can be very difficult to establish the exact combination of different versions of different stored procedures at a given point in time.

Fear of changes
One of the biggest drawbacks of stored procedures is that it is extremely difficult to tell which parts of a system use them and which not.
Especially if the software is broken down into multiple applications then it’s often not possible to find all references in one go (or at all if a developer doesn’t have read access to all projects) and therefore it might be difficult to confidently establish how a certain change will affect the overall system.
As a result stored procedures pose a huge risk of introducing breaking changes and development teams often shy away from making any changes at all. Sometimes this can lead to crippling new technological innovations.






