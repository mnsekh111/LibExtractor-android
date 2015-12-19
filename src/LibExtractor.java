/**
 * Created by mns on 12/19/15.
 */
public class LibExtractor {
    public static void main(String[] args) {
        String zipFilePath = "/home/mns/Downloads/test-apk.apk";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.traverseZip(args[0]);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
}
