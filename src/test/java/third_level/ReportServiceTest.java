package third_level;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class ReportServiceTest implements WithAssertions {
Report report = new Report("Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
        "Achievements: Social media campaign launch; 10% increase in leads.\n" +
        "Challenges: Delay in client approval of artwork.\n" +
        "Next steps: Follow-up meeting on Monday and budget optimization.", "Weekly Work Report");


    @Test
    void generateReport_whenInstancingReportServiceWithHtmlReportStrategy_returnsReportWithFormattedTextAndHTMLFileName(){
        Report expectedHtmlReport = new Report("<!DOCTYPE html>\n<head>\n    <body>\n    <Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.>\n    </body>\n</html>", "Weekly Work Report.html");
        ReportService htmlReportService = new ReportService(ReportStrategy.htmlReport());
        Report generatedReport = htmlReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedHtmlReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedHtmlReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithJsonReportStrategy_returnsReportWithFormattedTextAndJsonFileName(){
        Report expectedJsonReport = new Report("{report: Weekly Work Report\n  {content: Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.\n  }\n}", "Weekly Work Report.json");
        ReportService jsonReportService = new ReportService(ReportStrategy.jsonReport());
        Report generatedReport = jsonReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedJsonReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedJsonReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithXMLReportStrategy_returnsReportWithFormattedTextAndXMLFileName(){
        Report expectedXmlReport = new Report("<xml><content>Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.</content></xml>", "Weekly Work Report.xml");
        ReportService xmlReportService = new ReportService(ReportStrategy.xmlReport());
        Report generatedReport = xmlReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedXmlReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedXmlReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithPdfReportStrategy_returnsReportWithFormattedTextAndPdfFileName(){
        Report expectedPdfReport = new Report("[PDF-Header] Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization. [PDF-Footer]", "Weekly Work Report.pdf");
        ReportService pdfReportService = new ReportService(ReportStrategy.pdfReport());
        Report generatedReport = pdfReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedPdfReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedPdfReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithCsvReportStrategy_returnsReportWithFormattedTextAndCsvFileName(){
        Report expectedCsvReport = new Report("Header_Report\nWeekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.", "Weekly Work Report.csv");
        ReportService csvReportService = new ReportService(ReportStrategy.csvReport());
        Report generatedReport = csvReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedCsvReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedCsvReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithWordReportStrategy_returnsReportWithFormattedTextAndDocxFileName(){
        Report expectedWordReport = new Report("Sheet1\nRow1: Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.", "Weekly Work Report.docx");
        ReportService wordReportService = new ReportService(ReportStrategy.wordReport());
        Report generatedReport = wordReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedWordReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedWordReport.getFileName());
    }

    @Test
    void generateReport_whenInstancingReportServiceWithExcelReportStrategy_returnsReportWithFormattedTextAndXlsxFileName(){
        Report expectedExcelReport = new Report("{MS-WORD-DATA: Weekly Work Report\nTo: Management\nFrom: Juan Rodriguez\nDate: 22/04/2026\n" +
                "Achievements: Social media campaign launch; 10% increase in leads.\n" +
                "Challenges: Delay in client approval of artwork.\n" +
                "Next steps: Follow-up meeting on Monday and budget optimization.}", "Weekly Work Report.xlsx");
        ReportService excelReportService = new ReportService(ReportStrategy.excelReport());
        Report generatedReport = excelReportService.generateReport(report);
        assertThat(generatedReport.getContent()).isEqualTo(expectedExcelReport.getContent());
        assertThat(generatedReport.getFileName()).isEqualTo(expectedExcelReport.getFileName());
    }
}