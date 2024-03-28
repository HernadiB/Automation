package webTDK.environment;

public class OSManagement {
    public static String adjustPathToCurrentOS(String path){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            path = path.replace("/", "\\");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix") || os.contains("mac")){
            path = path.replace("\\", "/");
        }
        return path;
    }
}
