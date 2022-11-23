package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import generalutils.LoggerUtils;
import ui.utils.UIUtils;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {

    private final SelenideElement uniqueElement = $(By.xpath("//div[@class='books-wrapper']"));
    private final SelenideElement searchBox = $(By.xpath("//input[@id='searchBox']"));
    private final ElementsCollection bookImages = $$(By.xpath("//div[@class='books-wrapper']//img"));
    private final ElementsCollection headers = $$(By.xpath("//div[contains(@class,'header-content')]"));
    private final static String BOOKS_BY_PUBLISHERS_XPATH = "//div[contains(text(),\"%s\")]";
    private final static String LINKS_OF_BOOKS_BY_PUBLISHERS_XPATH = "//div[contains(text(),\"%s\")]//preceding::div[@class='rt-td'][2]//a";
    private final static String BOOK_HEADER_XPATH = "//div[@role='gridcell'][%s]";

    public boolean isPageOpen() {
        LoggerUtils.getLogger().info("Checking if book page is open");
        return uniqueElement.exists();
    }

    public boolean areBookImagesLoaded() {
        LoggerUtils.getLogger().info("Checking if images of books are loaded");
        return UIUtils.areImagesLoaded(bookImages);
    }

    public List<String> getHeaders() {
        LoggerUtils.getLogger().info("Getting headers from page");
        return headers.texts();
    }

    public List<String> getLinksFromTitles(String publisher) {
        LoggerUtils.getLogger().info("Getting links from book titles");
        ElementsCollection titles = $$(By.xpath(String.format(LINKS_OF_BOOKS_BY_PUBLISHERS_XPATH, publisher)));
        return UIUtils.getAttributesFromCollection(titles, "href");
    }

    public List<String> getBooksListByHeaderIndex(int headerIndex) {
        LoggerUtils.getLogger().info("Getting books list using index of header");
        return $$(By.xpath(String.format(BOOK_HEADER_XPATH, headerIndex))).texts();
    }

    public void fillSearchBox(String text) {
        LoggerUtils.getLogger().info(String.format("Searching: %s", text));
        searchBox.setValue(text);
    }

    public int getBooksByPublisherSize(String publisher) {
        LoggerUtils.getLogger().info("Getting size of book list, filtered by publisher");
        return $$(By.xpath(String.format(BOOKS_BY_PUBLISHERS_XPATH, publisher))).size();
    }

}
