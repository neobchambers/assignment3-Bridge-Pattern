public abstract class Report {
    protected Formatter formatter;
    protected Report(Formatter formatter){
        this.formatter = formatter;
    }

    public void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public abstract String execute();
}
