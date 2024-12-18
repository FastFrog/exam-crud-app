package com.example.exam_crud_app.service;

import com.example.exam_crud_app.repository.UserRepository;
import com.example.exam_crud_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) { // Проверка на существование пользователя
            userRepository.deleteById(id);
            return true; // Удаление прошло успешно
        }
        return false; // Пользователь не найден
    }

    public User updateUserById(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Динамическое обновление: проверка на null
            if (updatedUser.getName() != null) {
                existingUser.setName(updatedUser.getName());
            }
            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }

            // Сохранение обновленного пользователя
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }




}

