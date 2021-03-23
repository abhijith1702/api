package dev.microservice.api.model;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Palindrome {

    @Id
    @GeneratedValue
    private Long id;
    private String word;

    public Palindrome() {
    }

    public Palindrome(String word){
        this.word=word;
    }
}
