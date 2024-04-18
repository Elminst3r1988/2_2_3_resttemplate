package org.example.resttemplate;

import org.example.resttemplate.dao.UserDao;
import org.example.resttemplate.model.Car;
import org.example.resttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataLoad {

    private final UserDao userDao;

    @Autowired
    public DataLoad(UserDao userDao) {
        this.userDao = userDao;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setFirstName("UserName" + i);
            user.setLastName("LastName" + i);
            userDao.addUser(user);

            Car car = new Car();
            car.setModel("Model" + i);
            car.setPrice(Math.round(random.nextDouble() * 2500000));
            car.setUser(user);
            userDao.addCar(car);
        }
    }
}

