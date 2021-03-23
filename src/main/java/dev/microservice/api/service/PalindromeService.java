package dev.microservice.api.service;

import dev.microservice.api.model.Palindrome;
import dev.microservice.api.repository.PalindromeRepository;
import dev.microservice.api.request.PalindromeRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PalindromeService {

    private final PalindromeRepository palindromeRepository;

    public PalindromeService(PalindromeRepository palindromeRepository) {
        this.palindromeRepository = palindromeRepository;
    }

    @Transactional
    public Palindrome create(PalindromeRequest request) {
        String longestPalindrome = getLongestPalindromeSubString(request.getWord());
        Palindrome palindrome1 = palindromeRepository.save(new Palindrome(longestPalindrome));
        return palindrome1;
    }

    public Iterable<Palindrome> getAll(){
        return  palindromeRepository.findAll();
    }

    private String getLongestPalindromeSubString(String str){
        int max = 1;
        int start = 0;
        int length = str.length();
        int low, high;
        for (int i = 1; i < length; ++i) {

            low = i - 1;
            high = i;
            while (low >= 0 && high < length  && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > max) {
                    start = low;
                    max = high - low + 1;
                }
                --low;
                ++high;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < length  && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > max) {
                    start = low;
                    max = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        //System.out.println("start " + start+ "maxlength "+ maxLength);
        return str.substring(start, start+max);
    }
}


