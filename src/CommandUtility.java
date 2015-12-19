import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mns on 12/19/15.
 * A helper class to run various unix commands
 */
public class CommandUtility {

    /**
     * Helper function to execute readelf with -A option. (Which is to extract only architectural properties of a file)
     * The problem can be solved using obj dump as well
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Map<String, String> execReadelf(String fileName) throws IOException {

        Map<String, String> propertyMap = new HashMap<>();

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
                int index = line.indexOf(":");
                if (index != -1) {
                    try {
                        propertyMap.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                    } catch (ArrayIndexOutOfBoundsException aie) {

                    }
                }
                out.append(line).append('\n');
                //System.out.println(line);

//                for (Map.Entry<String,String> entry : propertyMap.entrySet()){
//                    System.out.println(entry.getKey() +": " + entry.getValue());
//                }
            }
        }

        return propertyMap;
    }
}


