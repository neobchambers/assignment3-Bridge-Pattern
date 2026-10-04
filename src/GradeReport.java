public class GradeReport extends Report{
    private final double[] grades;

    public GradeReport(
            double[] grades,
            Formatter formatter) {
        super(formatter);
        this.grades = grades;

    }

    @Override
    public String execute() {
        double sum = 0;
        for(double grade : grades){
            sum += grade;
        }
        double average = sum / grades.length;
        return formatter.formatGrade(average);
    }
}
