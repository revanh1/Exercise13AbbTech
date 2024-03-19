package org.abbtech.lesson2.exercises;

public interface UserRepository {
    User findByUsername(String name);

    User findUserId(Long id);
    void delete(User user);
}
