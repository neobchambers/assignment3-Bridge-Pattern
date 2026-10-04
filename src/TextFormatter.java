public class TextFormatter implements Formatter{
    @Override
    public String formatAttendance(double percentage) {
        return "Attendance: " + percentage + "%";
    }

    @Override
    public String formatGrade(double average) {
        return "Average grade: " + average;
    }
}
