# assignment3-Bridge-Pattern
Assignment 3 — Bridge Pattern

Name: Imanova Yerkezhan
Group: SE-2528
Topic: C — Reports
Repository: https://github.com/neobchambers/assignment3-Bridge-Pattern
[MarkdownFormatter.java](src/MarkdownFormatter.java)
Topic : This project demonstrates the Bridge Design Pattern using reports and formatters.

Two independent dimensions:
Abstraction: reports
Implementor: formatting

Reports:
AttendanceReport
GradeReport

Formatters:
TextFormatter
HtmlFormatter
MarkdownFormatter

Bridge field: protected Formatter formatter in Report.
Main abstraction operation: public abstract String execute().
Runtime switching: setImplementation(Formatter formatter).

Behavior
AttendanceReport calculates 3 of 4 attended sessions = 75%.
GradeReport calculates the average of 70, 80, and 90 = 80.
The same domain data can be formatted as plain text, HTML, or Markdown.

T1–T7
T1 AttendanceReport + TextFormatter → Attendance: 75.0%
T2 AttendanceReport + HtmlFormatter → <p>Attendance: 75.0%</p>
T3 GradeReport + TextFormatter → Average grade: 80.0
T4 GradeReport + HtmlFormatter → <p>Average grade: 80.0</p>
T5 The same AttendanceReport object switches from TextFormatter to HtmlFormatter at runtime.
T6 AttendanceReport + MarkdownFormatter → **Attendance:** 75.0%
T7 GradeReport + MarkdownFormatter → **Average grade:** 80.0

Build and run

javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo

Expected final line:
SUMMARY: 7/7 PASS

Extension
The first working version contains I1 and I2. The extension adds I3 as MarkdownFormatter.
The existing abstraction classes, Formatter interface, TextFormatter, and HtmlFormatter remain unchanged for the extension.
