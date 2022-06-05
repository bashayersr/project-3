package com.example.bookmanage.Repository;


import java.util.List;

import com.example.bookmanage.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository  extends JpaRepository<Loan,Integer>{


    /*@Query("SELECT * FROM Loan t WHERE t.book_id = ?1")*/
    List<Loan> findByBookId(Integer book_id);
}
