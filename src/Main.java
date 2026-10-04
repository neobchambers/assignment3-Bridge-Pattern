public class Main {

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            runSimpleExample();
        }
    }

    private static void runSimpleExample() {
        Formatter textFormatter = new TextFormatter();

        AttendanceReport attendance =
                new AttendanceReport(3, 4, textFormatter);

        GradeReport grades =
                new GradeReport(
                        new double[]{70, 80, 90},
                        textFormatter
                );

        System.out.println(attendance.execute());
        System.out.println(grades.execute());
    }

    private static void runDemo() {

        int passed = 0;

        if (testT1()) passed++;
        if (testT2()) passed++;
        if (testT3()) passed++;
        if (testT4()) passed++;
        if (testT5()) passed++;
        if (testT6()) passed++;
        if (testT7()) passed++;

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }

    private static boolean testT1() {

        Formatter formatter = new TextFormatter();

        AttendanceReport report =
                new AttendanceReport(3, 4, formatter);

        String actual = report.execute();
        String expected = "Attendance: 75.0%";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T1 " + (pass ? "PASS" : "FAIL")
                        + " | AttendanceReport + TextFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }

    private static boolean testT2() {

        Formatter formatter = new HtmlFormatter();

        AttendanceReport report =
                new AttendanceReport(3, 4, formatter);

        String actual = report.execute();
        String expected = "<p>Attendance: 75.0%</p>";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T2 " + (pass ? "PASS" : "FAIL")
                        + " | AttendanceReport + HtmlFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }

    private static boolean testT3() {

        Formatter formatter = new TextFormatter();

        GradeReport report =
                new GradeReport(
                        new double[]{70, 80, 90},
                        formatter
                );

        String actual = report.execute();
        String expected = "Average grade: 80.0";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T3 " + (pass ? "PASS" : "FAIL")
                        + " | GradeReport + TextFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }

    private static boolean testT4() {

        Formatter formatter = new HtmlFormatter();

        GradeReport report =
                new GradeReport(
                        new double[]{70, 80, 90},
                        formatter
                );

        String actual = report.execute();
        String expected = "<p>Average grade: 80.0</p>";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T4 " + (pass ? "PASS" : "FAIL")
                        + " | GradeReport + HtmlFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }

    private static boolean testT5() {

        Formatter textFormatter = new TextFormatter();
        Formatter htmlFormatter = new HtmlFormatter();

        AttendanceReport report =
                new AttendanceReport(3, 4, textFormatter);

        AttendanceReport originalReference = report;

        String before = report.execute();

        report.setImplementation(htmlFormatter);

        String after = report.execute();

        boolean sameObject = originalReference == report;

        boolean stateUnchanged = before.equals("Attendance: 75.0%")
                && after.equals("<p>Attendance: 75.0%</p>");

        boolean pass = sameObject && stateUnchanged;

        System.out.println(
                "T5 " + (pass ? "PASS" : "FAIL")
                        + " | sameObject=" + sameObject
                        + " | stateUnchanged=" + stateUnchanged
                        + " | before=" + before
                        + " | after=" + after
        );

        if (!pass) {
            System.out.println(
                    "Expected: sameObject=true and correct results before and after switch"
            );
        }

        return pass;
    }

    private static boolean testT6() {

        Formatter formatter = new MarkdownFormatter();

        AttendanceReport report =
                new AttendanceReport(3, 4, formatter);

        String actual = report.execute();
        String expected = "**Attendance:** 75.0%";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T6 " + (pass ? "PASS" : "FAIL")
                        + " | AttendanceReport + MarkdownFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }

    private static boolean testT7() {

        Formatter formatter = new MarkdownFormatter();

        GradeReport report =
                new GradeReport(
                        new double[]{70, 80, 90},
                        formatter
                );

        String actual = report.execute();
        String expected = "**Average grade:** 80.0";

        boolean pass = actual.equals(expected);

        System.out.println(
                "T7 " + (pass ? "PASS" : "FAIL")
                        + " | GradeReport + MarkdownFormatter"
                        + " | result=" + actual
        );

        if (!pass) {
            System.out.println("Expected: " + expected);
        }

        return pass;
    }
}