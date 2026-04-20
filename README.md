# Document Prototype Design Pattern

## Overview
This project demonstrates the **Prototype Design Pattern** implemented in Java. The pattern is used to instantiate new objects by copying an existing object (the prototype) rather than creating new instances from scratch using a constructor. This is highly efficient when object creation is computationally expensive or requires standard boilerplate setup.

In this specific implementation, we manage different types of documents (PDF, Text, and Spreadsheet). 

## Structure
- **`Document` (Interface):** Extends `Cloneable`. Enforces that all concrete documents must be able to clone themselves, open, and report their type.
- **`PdfDocument`, `TextDocument`, `SpreadsheetDocument` (Concrete Prototypes):** Implement the `Document` interface. Each has unique fields specific to its file type.
- **`DocumentRegistry`:** Acts as a centralized factory. When instantiated, it pre-loads one prototype of every document type. When the client requests a document, it returns a clone of the respective prototype.
- **`ProcessedDocument` (Client):** Contains the `main()` method. It initializes the registry, requests clones of documents, modifies their specific metadata, and invokes their methods.

## How to Compile and Run

1. **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed on your system.
2. **Save the file:** Save the provided code into a single file named `ProcessedDocument.java`.
3. **Compile:** Open your terminal or command prompt, navigate to the folder containing your file, and run:
   ```bash
   javac ProcessedDocument.java