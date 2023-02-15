package com.example.springCrud1.repository;

import com.example.springCrud1.model.JsonTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<JsonTable, Long> {
}
