package tests;

import generalutils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import teststeps.TestSteps;
import ui.pages.BooksPage;
import testbase.TestBase;
import generalutils.LoggerUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookContentTests extends TestBase {

    @Test
    public void testBooksContent() {

        LoggerUtils.getLogger().info("Starting testing of book content!");
        BooksPage booksPage = new BooksPage();
        Assert.assertTrue(booksPage.isPageOpen(), "Books page isn't open");
        int titlesIndex = TestSteps.getHeaderIndex("Title");
        int publishersIndex = TestSteps.getHeaderIndex("Publisher");
        int authorsIndex = TestSteps.getHeaderIndex("Author");
        List<String> bookTitles = booksPage.getBooksListByHeaderIndex(titlesIndex);
        List<String> bookPublishers = booksPage.getBooksListByHeaderIndex(publishersIndex);
        List<String> bookAuthors = booksPage.getBooksListByHeaderIndex(authorsIndex);
        List<String> combinedList = Stream.of(bookAuthors, bookPublishers, bookTitles)
                .flatMap(Collection::stream).collect(Collectors.toList());
        Assert.assertTrue(StringUtils.areStringsFilled(combinedList), "String in list is an empty");
        Assert.assertTrue(booksPage.areBookImagesLoaded(), "Book image in list isn't loaded");

    }

}
