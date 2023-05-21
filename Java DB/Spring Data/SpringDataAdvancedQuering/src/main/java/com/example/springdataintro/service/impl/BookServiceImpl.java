package com.example.springdataintro.service.impl;

import com.example.springdataintro.model.entity.*;
import com.example.springdataintro.repository.BookRepository;
import com.example.springdataintro.service.AuthorService;
import com.example.springdataintro.service.BookService;
import com.example.springdataintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springdataintro.filePaths.FilePaths.BOOK_FILE_PATH;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count()>0){return;}

       Files.readAllLines(Path.of(BOOK_FILE_PATH))
                .stream()
                .map(String::trim)
                .filter(row -> !row.isEmpty())
               .forEach(row -> {
                   String[] bookInfo = row.split("\\s+");
                   Book book = createBookInfo(bookInfo);
                   bookRepository.save(book);
               });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
    return bookRepository
            .findAllByReleaseDateAfter(LocalDate.of(year,12, 31));

    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year+1, 1, 1))
                .stream().map(book -> String.format("%s %s",book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsFirstNameAndLastName(String fName, String lName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(fName,lName)
                .stream().
        map(book ->
            String.format("%s %s %d",
                    book.getTitle(),
                    book.getReleaseDate(),
                    book.getCopies()))
               .collect(Collectors.toList());
    }

//    @Override
//    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
//        return bookRepository
//                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName)
//                .stream()
//                .map(book -> String.format("%s %s %d",
//                        book.getTitle(),
//                        book.getReleaseDate(),
//                        book.getCopies()))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<String> findAllBooksTitlesWithAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllGoldBookTitlesWithCopiesLessThan5000() {
        return bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40() {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5L),
                        BigDecimal.valueOf(40L)).stream()
                .map(book -> String.format("%s - $%.2f",
                        book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findNotReleasedBookTitlesInYear(int year) {
        LocalDate lower = LocalDate.of(year, 1, 1);
        LocalDate upper = LocalDate.of(year, 12, 31);

        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(lower, upper)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksBeforeDate(LocalDate localDate) {
        return bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(book -> String.format("%s %s %.2f",
                        book.getTitle(), book.getEditionType().name(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksTitlesWithContainingString(String contStr) {
        return bookRepository.findAllByTitleIsContaining(contStr)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitleOfBooksWhereAuthorLastNameBeginWithStr(String begStr) {
        return bookRepository.findAllByAuthor_LastNameStartingWith(begStr)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int findCountOfAllBooksWhereTitleHasLongerLengthThanGivenNumber(int length) {
        return bookRepository.countOfBooksWithTitleLengthMoreThan(length);
    }

    @Override
    public List<String> findInformationTitleTypeRestrictionPrice(String data) {
        return bookRepository.findAllByTitle(data)
                .stream()
                .map(book -> String.format("%s %s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getAgeRestriction().name(),
                        book.getPrice()))
                .toList();

    }


    private Book createBookInfo(String[] bookInfo) {

        EditionType editionType = EditionType
                .values()[Integer.parseInt(bookInfo[0])];

        LocalDate releaseDate = LocalDate.parse(bookInfo[1],
                DateTimeFormatter.ofPattern("d/M/yyyy"));

        Integer copies = Integer.parseInt(bookInfo[2]);

        BigDecimal price = new BigDecimal(bookInfo[3]);

        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];

        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();

        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType,releaseDate,copies,price,ageRestriction,title,author,categories);
    }
}
