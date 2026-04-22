package third_level;

public interface ReportStrategy {
    Report generateReport(Report report);

    static ReportStrategy htmlReport (){
        return report -> new Report(String.format("<!DOCTYPE html>\n<head>\n    <body>\n    <%s>\n    </body>\n</html>", report.getContent()), report.getFileName() + ".html");
    }

    static ReportStrategy jsonReport (){
        return report -> new Report(String.format("{report: %s\n  {content: %s\n  }\n}", report.getFileName(), report.getContent()),  report.getFileName() + ".json");
    }

    static ReportStrategy xmlReport (){
        return report -> new Report(String.format("<xml><content>%s</content></xml>", report.getContent()),  report.getFileName() + ".xml");
    }

    static ReportStrategy pdfReport (){
        return report -> new Report(String.format("[PDF-Header] %s [PDF-Footer]", report.getContent()),  report.getFileName() + ".pdf");
    }

    static ReportStrategy csvReport (){
        return report -> new Report(String.format("Header_Report\n%s", report.getContent()), report.getFileName() + ".csv");
    }

    static ReportStrategy wordReport (){
        return report -> new Report(String.format("Sheet1\nRow1: %s", report.getContent()), report.getFileName() + ".docx");
    }

    static ReportStrategy excelReport (){
        return report -> new Report(String.format("{MS-WORD-DATA: %s}", report.getContent()), report.getFileName() + ".xlsx");
    }
}
