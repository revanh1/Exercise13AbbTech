package org.abbtech.lesson2.exercises;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserActive(String name){
        User user = userRepository.findByUsername(name);
        return user != null && user.isActive();
    }
    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findUserId(id);
        if(user == null){
            throw new Exception("not found");
        }
        userRepository.delete(user);
    }

    public User getUser(Long id) throws Exception {
        User user = userRepository.findUserId(id);
        if(user == null){
            throw new Exception("not found");
        }
        return user;
    }
}
