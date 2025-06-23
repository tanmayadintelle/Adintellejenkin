package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static boolean isSetupDone = false;
    private static String baseResultDir = "D:\\fd\\btladintelleautomation\\Automation Sanity Result";
    private static String templatePath = baseResultDir + "\\Template\\TestResults.xlsx";
    private static String currentResultExcelPath;

    @Before("@Sanity")
    public void setupFolder() {
        if (!isSetupDone) {
            try {
                createExcelTemplateIfNotExist(templatePath);
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                String fileName = "TestResults_" + timestamp + ".xlsx";
                currentResultExcelPath = baseResultDir + "\\" + fileName;
                copyFile(templatePath, currentResultExcelPath);
                System.out.println("📄 Created result Excel file: " + currentResultExcelPath);
                isSetupDone = true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("❌ Failed during setup.");
            }
        }
    }

    @After("@Sanity")
    public void writeResultToExcel(Scenario scenario) {
        if (!isSetupDone || currentResultExcelPath == null) {
            System.out.println("❌ Excel file not ready. Skipping write.");
            return;
        }

        File file = new File(currentResultExcelPath);
        if (!file.exists()) {
            System.out.println("❌ Result Excel file missing: " + currentResultExcelPath);
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            String scenarioName = scenario.getName().trim();
            String result = scenario.isFailed() ? "Fail" : "Pass";
            String timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

            boolean updated = false;
            for (Row row : sheet) {
                Cell scenarioCell = row.getCell(2);
                if (scenarioCell != null && scenarioCell.getCellType() == CellType.STRING) {
                    if (scenarioCell.getStringCellValue().trim().equalsIgnoreCase(scenarioName)) {
                        row.createCell(1).setCellValue(timestamp);
                        row.createCell(3).setCellValue(result);
                        updated = true;
                        break;
                    }
                }
            }

            if (!updated) {
                int lastRow = sheet.getLastRowNum() + 1;
                Row newRow = sheet.createRow(lastRow);
                newRow.createCell(0).setCellValue(lastRow);
                newRow.createCell(1).setCellValue(timestamp);
                newRow.createCell(2).setCellValue(scenarioName);
                newRow.createCell(3).setCellValue(result);
            }

            fis.close();
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

            System.out.println("✅ Excel updated: " + scenarioName + " = " + result + " at " + timestamp);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ Failed to write result to Excel.");
        }
    }

    private void createExcelTemplateIfNotExist(String templatePath) throws IOException {
        File templateFile = new File(templatePath);
        if (!templateFile.exists()) {
            templateFile.getParentFile().mkdirs();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("TestResults");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Serial No");
            header.createCell(1).setCellValue("Timestamp");
            header.createCell(2).setCellValue("Scenario Name");
            header.createCell(3).setCellValue("Status");

            for (int i = 0; i <= 3; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(templateFile)) {
                workbook.write(fos);
            }
            workbook.close();
            System.out.println("✅ Template created at: " + templatePath);
        } else {
            System.out.println("ℹ️ Template already exists at: " + templatePath);
        }
    }

    private void copyFile(String sourcePath, String destPath) throws IOException {
        File source = new File(sourcePath);
        File dest = new File(destPath);
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
