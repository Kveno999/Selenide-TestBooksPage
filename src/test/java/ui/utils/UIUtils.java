package ui.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@UtilityClass
public class UIUtils {

    public static List<String> getAttributesFromCollection(ElementsCollection elements, String attribute) {
        List<String> attrs = new ArrayList<>();
        for (SelenideElement s : elements) {
            attrs.add(s.getAttribute(attribute));
        }
        return attrs;
    }

    public static boolean areImagesLoaded(ElementsCollection images) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        for (SelenideElement s : images) {
            if (!s.has(Condition.image)) {
                atomicBoolean.set(false);
                break;
            }
        }
        return atomicBoolean.get();
    }

}
