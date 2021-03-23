package dev.microservice.api.controller;

import dev.microservice.api.model.Palindrome;
import dev.microservice.api.request.PalindromeRequest;
import dev.microservice.api.service.PalindromeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")
public class PalindromeController {


    private final PalindromeService palindromeService;

    PalindromeController(PalindromeService service){
        this.palindromeService = service;
    }

    @GetMapping(value = "getAllPalindromes")
    public ResponseEntity<Iterable<Palindrome>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(palindromeService.getAll());
    }

    @PostMapping(value = "addPalindrome")
    public ResponseEntity<Palindrome> create(@RequestBody PalindromeRequest palindromeRequest){
        Palindrome  palindrome1 =  palindromeService.create(palindromeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(palindrome1);
    }



}
