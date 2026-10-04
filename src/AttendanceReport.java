public class AttendanceReport extends Report{
     private final int attended;
     private final int total;

     public AttendanceReport(
             int attended,
             int total,
             Formatter formatter) {
         super(formatter);
         this.attended =  attended;
         this.total = total;
     }

    @Override
    public String execute() {
         double percentage = (double) attended / total * 100;
        return formatter.formatAttendance(percentage);
    }
}
