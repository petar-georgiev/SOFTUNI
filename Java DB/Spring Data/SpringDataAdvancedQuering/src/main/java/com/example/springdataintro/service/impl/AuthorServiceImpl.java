package com.example.springdataintro.service.impl;

import com.example.springdataintro.model.entity.Author;
import com.example.springdataintro.model.entity.Book;
import com.example.springdataintro.repository.AuthorRepository;
import com.example.springdataintro.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.springdataintro.filePaths.FilePaths.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHOR_FILE_PATH)).stream()
                .map(String::trim)
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    String fName = row.split("\\s+")[0];
                    String lName = row.split("\\s+")[1];

                    Author author = new Author(fName,lName);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, authorRepository.count()+1);
        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> findAllAuthorsOrderByCountOfTheisBooks() {
        return authorRepository.findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAuthorFullNameEndsWithStr(String endStr) {

        return authorRepository.findAllByFirstNameEndingWith(endStr)
                .stream()
                .map(author -> String.format("%s %s",author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public void findAllAuthorsAndTheirTotalCopies() {
     List<Author> authors = this.authorRepository.findAll();
     Map<String, Integer> authorCopies = new HashMap<>();
     authors.forEach(author -> {
         int copies = author
                 .getBooks()
                 .stream()
                 .mapToInt(Book::getCopies)
                 .sum();
         authorCopies.put(author.getFirstName() + " " +
                 author.getLastName(), copies);
     });

      authorCopies.entrySet()
                .stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
              .forEach(author -> System.out.printf("%s %d%n",
                      author.getKey(),
                      author.getValue()));
    }
}
