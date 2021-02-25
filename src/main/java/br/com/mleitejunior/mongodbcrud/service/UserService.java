package br.com.mleitejunior.mongodbcrud.service;

import br.com.mleitejunior.mongodbcrud.entity.User;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getUsers();

    public User updateUser(BigInteger id, User user);

    public void deleteUser(BigInteger id);
}
