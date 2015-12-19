/**
 * Created by mns on 12/19/15.
 */
public class UnzipUtilityTest {
    public static void main(String[] args) {
        String zipFilePath = "/home/mns/Downloads/test-apk.apk";
        String destDirectory = "/home/mns/Downloads/Pics";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.traverseZip(zipFilePath);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
}
