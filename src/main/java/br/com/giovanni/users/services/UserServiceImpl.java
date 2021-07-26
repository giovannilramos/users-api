package br.com.giovanni.users.services;

import br.com.giovanni.users.entities.User;
import br.com.giovanni.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public User insert(User objUser) throws Exception {
        if (objUser == null) {
            throw new Exception("Usuário não fornecido!");
        }
        try {
            return this.userRepository.save(objUser);
        } catch (DataAccessException e) {
            throw new Exception("Erro ao realizar o registro!");
        }
    }

    @Override
    public List<User> getTodos() throws Exception {
        return userRepository.findAll();
    }
}
