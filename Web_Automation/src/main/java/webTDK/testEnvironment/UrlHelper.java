package webTDK.testEnvironment;

import webTDK.constants.EnvironmentUrls;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Helper for get test environment url's
 */
public class UrlHelper {
    /**
     * Get all used environment url by environment type
     * @param environmentType environment type like FIT, INT
     * @return
     */
    public static HashMap<String, String> getAllBaseUrlsByEnvironmentType(String environmentType){
        ArrayList<String> environmentNameList = new ArrayList<>();
        environmentNameList.add("GRANDCASINO");
        return getAllBaseUrlsByEnvironmentNameListAndType(environmentNameList, environmentType);
    }

    /**
     * Get environment base urls by environment name and environment type
     * @param environmentNameList environment name like FRONTEND, CLWS
     * @return environmentType environment type like FINT, INT
     */
    public static HashMap<String, String> getAllBaseUrlsByEnvironmentNameListAndType(ArrayList<String> environmentNameList, String environmentType){
        HashMap<String, String> baseUrls = new HashMap<>();
        for (String environmentName : environmentNameList){
            switch (environmentName){
                case "GRANDCASINO":
                    baseUrls.put(environmentName, getGrandCasinoUrlWithTestEnvironmentType(environmentType));
                    break;
                default:
                    throw new RuntimeException("This environment not exist. Get contact with TA team " + environmentName);
            }
        }
        return baseUrls;
    }

    /** Get Grand Casino url by test environment type like FIT - INT **/
    public static String getGrandCasinoUrlWithTestEnvironmentType(String environmentType){
        switch (environmentType){
            case "INT":
                return EnvironmentUrls.GRANDCASINO_INT_URL;
            default:
                throw new RuntimeException("This type of Grand Casino not exist. Get contact with TA team " + environmentType);
        }
    }
}
