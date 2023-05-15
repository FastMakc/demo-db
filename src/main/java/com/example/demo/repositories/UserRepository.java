package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u.* FROM user_table u WHERE u.name=:name", nativeQuery = true)
    List<User> findUserByName( @Param("name") String name);

    @Query(value = "select u from userTable u where u.name=:name")
    List<User> findUserByNameSorted(Sort sort, @Param("name") String name);
}

