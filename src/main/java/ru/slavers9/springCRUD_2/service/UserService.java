package ru.slavers9.springCRUD_2.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.slavers9.springCRUD_2.models.UserModel;
import ru.slavers9.springCRUD_2.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModel> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserModel getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void editUser(@Valid UserModel user, Long id) {
        userRepository.editUser(user, id);
    }

    public void addUser(UserModel user) {
        userRepository.addUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
