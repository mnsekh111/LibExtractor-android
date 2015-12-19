/**
 * Created by mns on 12/19/15.
 */

import java.io.File;

/**
 * Container class for the information about the files
 */
public class LibInfo {
    private String name;
    private String archType;

    public LibInfo(String name){
        this.name = name;
        archType = "unknown";
    }

    public String getFileName(){
        if(name != null && !name.isEmpty()){
            File f = new File(name);
            if(f!=null){
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

    public String getArchType() {
        return archType;
    }

    public void setArchType(String archType) {
        this.archType = archType;
    }
}
