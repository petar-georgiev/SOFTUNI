package com.example.springdataintro;

import com.example.springdataintro.model.entity.Book;
import com.example.springdataintro.service.AuthorService;
import com.example.springdataintro.service.BookService;
import com.example.springdataintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
//        printAllBooksAfterYear(2000);
        //     printAllAuthorNameWithBooksWithReleaseDateBeforeYear(1990);
       // printAllAuthorsAndNumberOfTheBooks();
        printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
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
}
