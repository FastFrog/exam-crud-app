package com.example.exam_crud_app.repository;

import com.example.exam_crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
