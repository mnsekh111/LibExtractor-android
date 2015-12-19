/**
 * Created by mns on 12/19/15.
 */

import java.io.File;
import java.util.Map;

/**
 * Container class for the information about the files
 */
public class LibInfo {
    private String name;
    Map<String, String> property;

    public LibInfo(String name) {
        this.name = name;
    }

    public String getFileName() {
        if (name != null && !name.isEmpty()) {
            File f = new File(name);
            if (f != null) {
                return f.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperty(Map<String, String> map) {
        this.property = map;
    }

    public void getAllProperty() {
        if (property != null) {
            for (Map.Entry<String, String> entry : property.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public String getArchType(){
        if(property != null){
            return property.get("Tag_CPU_name") + property.get("Tag_CPU_arch");
        }
        return "";
    }

}
