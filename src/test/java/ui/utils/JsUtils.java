package ui.utils;

import generalutils.LoggerUtils;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@UtilityClass
public class JsUtils {

    public static void openLinkInNewTab(String url) {
        LoggerUtils.getLogger().debug("Opening link in new tab");
        executeJavaScript("window.open('" + url + "');");
    }

}
