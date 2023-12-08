package com.api.rest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Jr extends JpaRepository<Person,Integer> {
}
