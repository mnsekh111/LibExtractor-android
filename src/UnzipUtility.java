import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {
    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * Traverses through the Zip file tree
     *
     * @param zipFilePath
     * @throws IOException
     */

    public void traverseZip(String zipFilePath) throws IOException {
        File file = new File(zipFilePath);
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zis = new ZipInputStream(bin);

        int soCount = 0;
        try {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                String fileName = ze.getName();

                String extension = "";
                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    extension = fileName.substring(i + 1);
                }

                if (extension.toLowerCase().contentEquals("so")) {
                    soCount++;
                    System.out.println(fileName);
                }


            }
        } finally {
            zis.close();
        }

        
        System.out.println("Number of Libs: " + soCount);
    }


    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            try {
                System.out.println(filePath);
                if (!entry.isDirectory()) {
                    // if the entry is a file, extracts it
                    extractFile(zipIn, filePath);

                } else {
                    // if the entry is a directory, make the directory
                    File dir = new File(filePath);
                    dir.mkdir();

                }
            } catch (IOException ie) {

            } finally {
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }


        }
        zipIn.close();
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}