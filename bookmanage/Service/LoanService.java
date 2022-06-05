package com.example.bookmanage.Service;


import java.util.List;

import com.example.bookmanage.Exceptions.MessageExceptions;
import com.example.bookmanage.Repository.*;
import com.example.bookmanage.model.Books;
import com.example.bookmanage.model.Loan;
import com.example.bookmanage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookmanage.Repository.BooksRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private  final BooksRepository booksRepository;
    @Autowired
    private final UserRepository userRepository;

    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void addLoan(Loan myloan) {
        loanRepository.save(myloan);
    }

    public int addUserToLoan(Integer user_id,Integer book_id)
    {
        User usr=userRepository.findById(user_id).orElseThrow(()->{
            throw new MessageExceptions("user id is worng");
        });

        Books book=booksRepository.findById(book_id).orElseThrow(()->{
            throw new MessageExceptions("user id is worng");
        });

        if(usr==null)
            return -1;
        if(book==null)
            return 0;
        Loan myloan=new Loan(book,usr);
        loanRepository.save(myloan);
        getLoans();
        return 1;
    }
    public List<Loan> ShowLoanedBooks(Integer book_id)
    {

        Books book=booksRepository.findById(book_id).orElseThrow(()->{
            throw new MessageExceptions("user id is worng");
        });

        List<Loan> lons=loanRepository.findByBookId(book_id);
        return lons;
    }
}
