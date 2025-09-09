//package StepDefinitions;
//
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.BeforeAll;
//
//import java.io.*;
//import java.nio.file.*;
//import java.util.Comparator;
//import java.util.zip.*;
//
//public class TestSetupHooks {
//
//    private static final String SCREENSHOT_DIR = "screenshots";
//    private static final String ZIP_FILE = "screenshots.zip";
//
//    @BeforeAll
//    public static void cleanScreenshotFolder() {
//        try {
//            Path dir = Paths.get(SCREENSHOT_DIR);
//            if (Files.exists(dir)) {
//                // Delete all files and subdirectories recursively
//                Files.walk(dir)
//                    .sorted(Comparator.reverseOrder()) // delete children before parents
//                    .map(Path::toFile)
//                    .forEach(File::delete);
//            }
//
//            // Recreate the empty screenshots directory
//            Files.createDirectories(dir);
//            System.out.println("✅ Screenshot folder cleaned (files and folders deleted)");
//        } catch (IOException e) {
//            System.err.println("❌ Error cleaning screenshot folder:");
//            e.printStackTrace();
//        }
//    }
//
//    @AfterAll
//    public static void zipScreenshotFolder() {
//        try (FileOutputStream fos = new FileOutputStream(ZIP_FILE);
//             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
//
//            File folderToZip = new File(SCREENSHOT_DIR);
//            zipFiles(folderToZip, folderToZip.getName(), zipOut);
//            System.out.println("✅ Screenshot folder zipped successfully");
//
//        } catch (IOException e) {
//            System.err.println("❌ Error zipping screenshot folder:");
//            e.printStackTrace();
//        }
//    }
//
//    private static void zipFiles(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
//        if (fileToZip.isHidden()) return;
//
//        if (fileToZip.isDirectory()) {
//            if (!fileName.endsWith("/")) {
//                fileName += "/";
//            }
//            zipOut.putNextEntry(new ZipEntry(fileName));
//            zipOut.closeEntry();
//
//            File[] children = fileToZip.listFiles();
//            if (children != null) {
//                for (File childFile : children) {
//                    zipFiles(childFile, fileName + childFile.getName(), zipOut);
//                }
//            }
//            return;
//        }
//
//        // If it's a file
//        try (FileInputStream fis = new FileInputStream(fileToZip)) {
//            ZipEntry zipEntry = new ZipEntry(fileName);
//            zipOut.putNextEntry(zipEntry);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = fis.read(buffer)) >= 0) {
//                zipOut.write(buffer, 0, length);
//            }
//        }
//    }
//}
