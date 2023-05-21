package com.example.springdataintro.repository;

import com.example.springdataintro.model.entity.Author;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from authors a order by a.books.size desc")
    List<Author> findAllByBooksSizeDESC();
}
