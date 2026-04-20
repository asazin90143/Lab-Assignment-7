// The Prototype Interface
interface Document extends Cloneable {
    Document clone();
    void open();
    String getType();
}

// Concrete Prototype: PDF Document
class PdfDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;

    // Setters for customization after cloning
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setAuthor(String author) { this.author = author; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setName(String name) { this.name = name; }

    @Override
    public PdfDocument clone() {
        try {
            return (PdfDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen since we implement Cloneable
        }
    }

    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
    }

    @Override
    public String getType() {
        return "Type: PDF, File: " + fileName + ", Author: " + author + ", Pages: " + pageCount;
    }
}

// Concrete Prototype: Text Document
class TextDocument implements Document {
    private String filePath; // Changed from Integer to String to match the requested output
    private String encoding;
    private int wordCount;

    // Setters for customization
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setEncoding(String encoding) { this.encoding = encoding; }
    public void setWordCount(int wordCount) { this.wordCount = wordCount; }

    @Override
    public TextDocument clone() {
        try {
            return (TextDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void open() {
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
    }

    @Override
    public String getType() {
        return "Type: Text, Path: " + filePath + ", Encoding: " + encoding + ", Words: " + wordCount;
    }
}

// Concrete Prototype: Spreadsheet Document
class SpreadsheetDocument implements Document {
    private String spreadsheetName;
    private int rowCount;
    private int columnCount;

    // Setters for customization
    public void setSpreadsheetName(String spreadsheetName) { this.spreadsheetName = spreadsheetName; }
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public void setColumnCount(int columnCount) { this.columnCount = columnCount; }

    @Override
    public SpreadsheetDocument clone() {
        try {
            return (SpreadsheetDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document: " + spreadsheetName + " (" + rowCount + " rows, " + columnCount + " columns)");
    }

    @Override
    public String getType() {
        return "Type: Spreadsheet, Name: " + spreadsheetName + ", Rows: " + rowCount + ", Columns: " + columnCount;
    }
}

// Registry to hold and manage our prototypes
class DocumentRegistry {
    private PdfDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;

    public DocumentRegistry() {
        System.out.println("Creating a PDF Document prototype.");
        pdfPrototype = new PdfDocument();
        
        System.out.println("Creating a Text Document prototype.");
        textDocumentPrototype = new TextDocument();
        
        System.out.println("Creating a Spreadsheet Document prototype.");
        spreadsheetPrototype = new SpreadsheetDocument();
    }

    // Clone methods (Replaces the animal methods from the UML)
    public PdfDocument createPdfDocument() {
        return pdfPrototype.clone();
    }

    public TextDocument createTextDocument() {
        return textDocumentPrototype.clone();
    }

    public SpreadsheetDocument createSpreadsheetDocument() {
        return spreadsheetPrototype.clone();
    }
}

// Client Class containing the main method
public class ProcessedDocument {
    public static void main(String[] args) {
        // 1. Initialize the registry (this prints the constructor messages)
        DocumentRegistry registry = new DocumentRegistry();

        // 2. Clone and setup the first PDF document
        PdfDocument annualReport = registry.createPdfDocument();
        annualReport.setFileName("annual_report_2024.pdf");
        annualReport.setAuthor("Acme Corp");
        annualReport.setPageCount(150);
        annualReport.open();
        System.out.println(annualReport.getType());

        // 3. Clone and setup the Text document
        TextDocument meetingNotes = registry.createTextDocument();
        meetingNotes.setFilePath("meeting_notes.txt");
        meetingNotes.setEncoding("UTF-8");
        meetingNotes.setWordCount(250);
        meetingNotes.open();
        System.out.println(meetingNotes.getType());

        // 4. Clone and setup the Spreadsheet document
        SpreadsheetDocument salesData = registry.createSpreadsheetDocument();
        salesData.setSpreadsheetName("sales_data_q1.xlsx");
        salesData.setRowCount(1000);
        salesData.setColumnCount(20);
        salesData.open();
        System.out.println(salesData.getType());

        // 5. Clone and setup a second PDF document to demonstrate cloning multiple times
        PdfDocument summaryReport = registry.createPdfDocument();
        summaryReport.setFileName("summary_report.pdf");
        summaryReport.setAuthor("Acme Corp");
        summaryReport.setPageCount(30);
        summaryReport.open();
    }
}