import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mns on 12/19/15.
 */
public class CommandUtility {

    public static void execReadelf(String fileName) throws IOException {

        List<String> commands = new ArrayList<String>();
        commands.add("readelf");
        commands.add("-A");
        commands.add(fileName);


        //Run macro on target
        ProcessBuilder pb = new ProcessBuilder(commands);
        StringBuilder out = null;
        Process process = null;

        process = pb.start();

        //Read output
        out = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null, previous = null;
        while ((line = br.readLine()) != null) {
            if (!line.equals(previous)) {
                previous = line;
                out.append(line).append('\n');
                System.out.println(line);
            }
        }
    }
}


