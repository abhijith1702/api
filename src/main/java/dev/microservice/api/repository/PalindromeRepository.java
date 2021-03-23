package dev.microservice.api.repository;

import dev.microservice.api.model.Palindrome;
import org.springframework.data.repository.CrudRepository;

public interface PalindromeRepository extends CrudRepository<Palindrome,Long> {
}
