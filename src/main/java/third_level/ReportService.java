package third_level;

public class ReportService {
    final private ReportStrategy strategy;

    public ReportService(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    private Report generateReport(Report report){
     return strategy.generateReport(report);
    }
}
