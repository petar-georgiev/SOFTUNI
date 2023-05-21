package com.example.springdataintro.service;


import com.example.springdataintro.model.entity.AgeRestriction;
import com.example.springdataintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> findAllBooksAfterYear(int year);
    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);
    List<String> findAllAuthorsFirstNameAndLastName(String fName, String lName);

    List<String> findAllBooksTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

    List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findNotReleasedBookTitlesInYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBooksTitlesWithContainingString(String contStr);

    List<String> findAllTitleOfBooksWhereAuthorLastNameBeginWithStr(String begStr);

    int findCountOfAllBooksWhereTitleHasLongerLengthThanGivenNumber(int length);

    List<String> findInformationTitleTypeRestrictionPrice(String data);

}
