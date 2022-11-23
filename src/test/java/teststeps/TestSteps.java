package teststeps;

import ui.pages.BooksPage;
import ui.utils.JsUtils;
import generalutils.LoggerUtils;

import java.util.List;

public class TestSteps {

    public static int getHeaderIndex(String headerName) {
        LoggerUtils.getLogger().info("Getting index of header on page");
        BooksPage booksPage = new BooksPage();
        List<String> headers = booksPage.getHeaders();
        int startIndex = 1;
        for (String s : headers) {
            if (s.equals(headerName)) {
                break;
            }
            else {
                startIndex++;
            }
        }
        return startIndex;
    }

    public static void clickMultipleTitles() {
        LoggerUtils.getLogger().info("Clicking on multiple titles on book's page");
        BooksPage booksPage = new BooksPage();
        String bookPublisher = "Reilly Media";
        List<String> urls = booksPage.getLinksFromTitles(bookPublisher);
        for (String url : urls){
            JsUtils.openLinkInNewTab(url);
        }
    }

}
