package com.example.exam_crud_app;

import com.example.exam_crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
