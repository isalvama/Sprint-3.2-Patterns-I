package third_level;

public class Report {
    private String content;
    private String fileName;

    public Report(String content, String fileName) {
        this.content = content;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }
}
