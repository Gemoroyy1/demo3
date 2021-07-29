package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers(){
        return (List<UserEntity>) userRepository.findAll();
    }

    public void addNewUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.country = "USA";
        userEntity.name = "Иван";
        Random rnd = new Random();
        userEntity.id = rnd.nextInt(1000);
        userRepository.save(userEntity);
    }

    public void addNewUser(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "country") String country) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = Integer.parseInt(id);
        userEntity.name = name;
        userEntity.country = country;
        userRepository.save(userEntity);
    }

    public void addNewUser(@RequestParam(name = "count") String count) {
        for (int i = 0; i < Integer.parseInt(count); i++) addNewUser();
    }

    public void deleteTheUser(@RequestParam(name = "id") String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }
}
