package me.dio.santander_dev_week_2025.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import me.dio.santander_dev_week_2025.model.User;
import me.dio.santander_dev_week_2025.repository.UserRepository;
import me.dio.santander_dev_week_2025.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.UserRepository = userRepository;
    }
    
    @Override
    public User findById(Long id){
        return UserRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate){
        if(UserRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return UserRepository.save(userToCreate);
    }
}
