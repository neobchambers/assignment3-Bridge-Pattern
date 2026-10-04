public class HtmlFormatter implements Formatter{
    @Override
    public String formatAttendance(double percentage) {
        return "<p>Attendance: " + percentage + "%</p>";
    }

    @Override
    public String formatGrade(double average) {
        return "<p>Average grade: " + average + "</p>";
    }
}
