package br.com.giovanni.users.services;

import br.com.giovanni.users.entities.User;

import java.util.List;

public interface UserService {
    User insert(User objUser) throws Exception;

    List<User> getTodos() throws Exception;
}
