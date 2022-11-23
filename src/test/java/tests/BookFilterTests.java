package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import teststeps.TestSteps;
import ui.pages.BooksPage;
import testbase.TestBase;
import generalutils.LoggerUtils;

import java.util.List;

public class BookFilterTests extends TestBase {

    private final static String SEARCH_WORD = "Javascript";
    private final static String PUBLISHER = "O'Reilly Media";
    private final static String FIRST_BOOK_TITLE = "Learning JavaScript Design Patterns";
    public final static int EXCEPTED_BOOK_AMOUNT = 10;

    @Test
    public void testBooksFilter() {

        LoggerUtils.getLogger().info("Starting testing of book's page filter!");
        BooksPage booksPage = new BooksPage();
        Assert.assertTrue(booksPage.isPageOpen(), "Books page isn't opened");
        booksPage.fillSearchBox(SEARCH_WORD);
        int booksByPublishersSize = booksPage.getBooksByPublisherSize(PUBLISHER);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(booksByPublishersSize,
                EXCEPTED_BOOK_AMOUNT, "Books count doesn't equals expected one");
        int titlesIndex = TestSteps.getHeaderIndex("Title");
        List<String> bookTitles = booksPage.getBooksListByHeaderIndex(titlesIndex);
        int firstBookTitleIndex = 0;
        Assert.assertEquals(bookTitles.get(firstBookTitleIndex),
                FIRST_BOOK_TITLE, "First book's title doesn't equals expected");
        TestSteps.clickMultipleTitles();

    }

}
