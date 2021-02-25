package br.com.mleitejunior.mongodbcrud.repository;

import br.com.mleitejunior.mongodbcrud.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface UserRepository extends MongoRepository<User, BigInteger> {
}
