package dev.microservice.api.request;

public class PalindromeRequest {
    String word;

    public PalindromeRequest(){

    }
    public PalindromeRequest(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
