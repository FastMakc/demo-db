package com.example.demo.repositories;

import com.example.demo.model.Pollution;
import org.springframework.data.repository.CrudRepository;

public interface PollutionRepository extends CrudRepository<Pollution, String> {
}
