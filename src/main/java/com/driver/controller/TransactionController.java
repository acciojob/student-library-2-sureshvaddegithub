package com.driver.controller;

import com.driver.models.Transaction;
import com.driver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
@RequestMapping("/transaction")

public class TransactionController {

    @Autowired
    TransactionService transactionService;

    //Add required annotations
    @PostMapping("issueBook")
    public ResponseEntity<String> issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
         String transactionId = transactionService.issueBook(cardId,bookId);
       return new ResponseEntity<>("transaction completed "+transactionId, HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @PostMapping("returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        Transaction transaction =  transactionService.returnBook(cardId,bookId);
        return new ResponseEntity<>("transaction completed "+transaction.getTransactionId(), HttpStatus.ACCEPTED);
    }
}
