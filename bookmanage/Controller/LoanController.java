package com.example.bookmanage.Controller;

import java.util.List;
import com.example.bookmanage.DTO.API;
import com.example.bookmanage.Service.LoanService;
import com.example.bookmanage.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("management/loans")
@RequiredArgsConstructor
public class LoanController {

    Logger logger=LoggerFactory.getLogger(LoanController.class);

    private final LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("getLoan =>called");
        List<Loan> loan=loanService.getLoans();
        return ResponseEntity.status(HttpStatus.OK).body(loan);
    }


    @PostMapping("/addloan/{user_id}/{book_id}")
    public ResponseEntity<API> addUserToLoan(@RequestParam Integer user_id, @RequestParam Integer book_id){
        logger.info("addUserToLoan =>called");
        int statfunc= 	loanService.addUserToLoan(user_id,book_id);
        switch (statfunc){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API("user_id is valid",200));
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API("book_id is valid",200));
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body(new API("Ok Add User and Book to Loan :",200));
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("Error Server",200));

        }
    }
    @PostMapping("/getbook/{book_id}")
    public ResponseEntity<API> ShowLoanedBooks(@RequestParam Integer book_id){
        logger.info("addUserToLoan =>called");
        List<Loan> loan=loanService.ShowLoanedBooks(book_id);
        if(loan.size()==0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API("book_id is valid",200));
        else
            return ResponseEntity.status(HttpStatus.OK).body(new API("Ok show Loaned Books :"+loan,200));
    }

}
