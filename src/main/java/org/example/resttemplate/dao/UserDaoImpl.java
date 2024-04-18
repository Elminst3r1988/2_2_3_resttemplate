package org.example.resttemplate.dao;

import org.example.resttemplate.model.Car;
import org.example.resttemplate.model.User;
import org.example.resttemplate.repository.CarRepository;
import org.example.resttemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }
}
