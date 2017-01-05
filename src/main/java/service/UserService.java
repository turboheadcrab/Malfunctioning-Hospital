package service;


import model.User;

import java.util.List;

public interface UserService {

    void delete(String username);

    User find(String username);

    List<User> findAll();

    long save(User doctor);

    void update(User doctor);

}
