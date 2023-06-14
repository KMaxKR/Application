package ms.kx.Application.service;


import ms.kx.Application.entity.User;
import ms.kx.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long user_id){
        return userRepository.findById(user_id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long user_id){
        userRepository.deleteById(user_id);
    }
}
