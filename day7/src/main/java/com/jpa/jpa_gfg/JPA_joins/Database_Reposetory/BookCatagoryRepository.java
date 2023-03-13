package com.jpa.jpa_gfg.JPA_joins.Database_Reposetory;

import com.jpa.jpa_gfg.JPA_joins.Modules.BookCatagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCatagoryRepository extends JpaRepository<BookCatagory,Integer> {
}
