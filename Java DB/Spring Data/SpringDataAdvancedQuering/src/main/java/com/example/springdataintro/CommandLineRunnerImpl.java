package com.example.springdataintro;

import com.example.springdataintro.model.entity.AgeRestriction;
import com.example.springdataintro.model.entity.Book;
import com.example.springdataintro.service.AuthorService;
import com.example.springdataintro.service.BookService;
import com.example.springdataintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printAllBooksAfterYear(2000);
        //printAllAuthorNameWithBooksWithReleaseDateBeforeYear(1990);
        // printAllAuthorsAndNumberOfTheBooks();
        // printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Select ex:");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1 -> booksTilesByAgeRest();
            case 2 -> goldenBooks();
            case 3 -> booksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBefore();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBooksCopies();
            case 11 -> reducedBook();
        }
    }

    private void reducedBook() throws IOException {
        System.out.println("Enter data:");
        String data = bufferedReader.readLine();
        bookService
                .findInformationTitleTypeRestrictionPrice(data)
                .forEach(System.out::println);
    }

    private void totalBooksCopies() {
        authorService
                .findAllAuthorsAndTheirTotalCopies();
    }

    private void countBooks() throws IOException {
        System.out.println("Input length of title of book:");
        int length = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService
                .findCountOfAllBooksWhereTitleHasLongerLengthThanGivenNumber(length));

    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Enter begin string of author's last name:");
        String begStr = bufferedReader.readLine();

        bookService
                .findAllTitleOfBooksWhereAuthorLastNameBeginWithStr(begStr)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Enter containing str:");
        String contStr = bufferedReader.readLine();

        bookService
                .findAllBooksTitlesWithContainingString(contStr)
                .forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.println("Enter last letter of first name:");
        String endStr = bufferedReader.readLine();

        authorService
                .findAuthorFullNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void booksReleasedBefore() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy:");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService
                .findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Enter year:");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findNotReleasedBookTitlesInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBookTitlesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBooks() {
        bookService.findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void booksTilesByAgeRest() throws IOException {
        System.out.println("Enter Age Restriction:");
        AgeRestriction ageRestriction =
                AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase(Locale.ROOT));
        bookService
                .findAllBooksTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }


    private void printAllBooksByAuthorNameOrderByReleaseDate(String fName, String lName) {
        bookService.findAllAuthorsFirstNameAndLastName(fName, lName)
                .forEach(System.out::println);

    }

    private void printAllAuthorsAndNumberOfTheBooks() {
        authorService
                .findAllAuthorsOrderByCountOfTheisBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorNameWithBooksWithReleaseDateBeforeYear(int year) {
        bookService.findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
