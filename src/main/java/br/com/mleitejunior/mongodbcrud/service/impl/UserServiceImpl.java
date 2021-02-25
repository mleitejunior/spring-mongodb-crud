package br.com.mleitejunior.mongodbcrud.service.impl;

import br.com.mleitejunior.mongodbcrud.entity.User;
import br.com.mleitejunior.mongodbcrud.repository.UserRepository;
import br.com.mleitejunior.mongodbcrud.service.SequenceGeneratorService;
import br.com.mleitejunior.mongodbcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public User saveUser(User user) {
        User newUser = new User();

        user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));

        newUser.setName(user.getName());
        newUser.setAge(user.getAge());

        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(BigInteger id, User user) {
        Optional<User> findById = userRepository.findById(id);
        if (findById.isPresent()) {
            User userEntity = findById.get();
            if(Objects.nonNull(user.getName()) && !user.getName().isEmpty()){
                userEntity.setName(user.getName());
            }
            if(Objects.nonNull(user.getAge())){
                userEntity.setAge(user.getAge());
            }

            return userRepository.save(userEntity);
        }

        return null;
    }

    @Override
    public void deleteUser(BigInteger id) {
        userRepository.deleteById(id);
    }
}
