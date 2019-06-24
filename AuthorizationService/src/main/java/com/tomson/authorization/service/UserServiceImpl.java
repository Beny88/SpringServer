package com.tomson.authorization.service;

import com.tomson.authorization.dto.CreateUserDto;
import com.tomson.authorization.model.User;
import com.tomson.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new NullPointerException("Not Found " + username));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User createUser(final CreateUserDto createUserDto){
        final User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(encoder.encode(createUserDto.getPassword()));
        user.setAccountNotExpired(true);
        user.setCredentialNotExpired(true);
        user.setAccountNotLocked(true);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(final Long userId){
        userRepository.deleteById(userId);
    }
}