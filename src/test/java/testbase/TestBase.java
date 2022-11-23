package testbase;

import generalutils.PropertiesUtils;
import org.testng.annotations.BeforeMethod;
import generalutils.LoggerUtils;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private final static String URL = PropertiesUtils.getObjectFromJson("config.json", "url").toString();

    @BeforeMethod
    protected void setUp() {
        LoggerUtils.getLogger().debug("Opening browser, go to url:" + URL);
        open(URL);
    }

}
