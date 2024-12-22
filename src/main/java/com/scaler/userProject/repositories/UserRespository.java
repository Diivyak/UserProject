package com.scaler.userProject.repositories;

import com.scaler.userProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    List<User> findAll();

    void deleteById(Long id);

    Optional<User> findById(Long id);

    User save(User user);



}
