package generalutils;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@UtilityClass
public class PropertiesUtils {

    public static String getResourceFilePath(String name) {
        LoggerUtils.getLogger().debug("Getting path of resource file");
        File uploadFile = new File(String.format("src/test/resources/%s", name));
        return uploadFile.getPath();
    }

    public static Object getObjectFromJson(String fileName, String key) {
        LoggerUtils.getLogger().debug("Getting object from json file");
        JSONParser configJsonParser = new JSONParser();
        Object obj;
        try (FileReader reader = new FileReader(getResourceFilePath(fileName))) {
            obj = configJsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(key);
    }

}
