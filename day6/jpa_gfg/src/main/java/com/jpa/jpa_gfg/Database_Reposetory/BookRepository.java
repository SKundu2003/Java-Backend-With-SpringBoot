package com.jpa.jpa_gfg.Database_Reposetory;

import com.jpa.jpa_gfg.Modules.Book;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
//@Component
public interface BookRepository extends JpaRepository<Book,Integer> { //Intiger is the primary key type
    //this will autometacally implimented by hibernate
    public Book findById(int id);
//    public List<Book> findByAuthr(int prise);



    //but when we need to make some other name for a fuction then we need to use "@Query"
    //1
    //using the proper SQL syntex
    @Query(value = "select * from book b where b.authr=:author_name",nativeQuery = true) //":" is importent for parameter
    public List<Book> getListOfAllbooks_By_Using_Author_Name(String author_name);


    //2
    //by using JPQL -> java percistent Query language
    @Query("select b from Book b where b.authr =:author_name") //just because it's JPQL -->so maping will be using java object
    public List<Book> findBookUsingAuthor(String author_name);

}
