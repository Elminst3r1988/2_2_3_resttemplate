package org.example.resttemplate;

import org.example.resttemplate.model.Car;
import org.example.resttemplate.model.User;
import org.example.resttemplate.repository.CarRepository;
import org.example.resttemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class DataLoad {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public DataLoad(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setFirstName("UserName" + i);
            user.setLastName("LastName" + i);
            userRepository.save(user);

            Car car = new Car();
            car.setModel("Model" + i);
            car.setPrice(Math.round(random.nextDouble() * 2500000));
            car.setUser(user);
            carRepository.save(car);
        }
    }
}

