package org.example.resttemplate.dao;

import org.example.resttemplate.model.Car;
import org.example.resttemplate.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {

    void addUser(User user);
    void addCar(Car car);
    List<User> getAllUsers();

    User getUserById(Long id);

}
