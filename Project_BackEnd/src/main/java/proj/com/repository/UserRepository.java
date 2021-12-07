package proj.com.repository;

import proj.com.entity.User;

public interface UserRepository {

    void save(User user);
    User findByEmail(String email);


}
