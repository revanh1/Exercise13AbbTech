package org.abbtech.lesson2.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


public class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImp userServiceImp;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        userServiceImp = new UserServiceImp(userRepository);
    }

    @Test
    void testIsUserActive_userExistsAndActive() {

        String username = "revan";
        User activeUser = new User(1L, username, true);
        when(userRepository.findByUsername(username)).thenReturn(activeUser);

        boolean isActive = userServiceImp.isUserActive(username);

        Assertions.assertTrue(isActive);
        verify(userRepository).findByUsername(username);
    }

    @Test
    void testIsUserActive_userExistsAndDoesntActive() {

        String username = "revan";
        User activeUser = new User(1L, username, false);
        when(userRepository.findByUsername(username)).thenReturn(activeUser);

        boolean isActive = userServiceImp.isUserActive(username);

        Assertions.assertFalse(isActive);
        verify(userRepository).findByUsername(username);
    }

    @Test
    void testIsUserActive_userDoesntExist(){
        String username = "kenan";
        when(userRepository.findByUsername(username)).thenReturn(null);

        boolean isActive = userServiceImp.isUserActive(username);

        Assertions.assertFalse(isActive);
        verify(userRepository).findByUsername(username);
    }

    @Test
    void testDeleteUser_userDoesntFound() throws Exception {
        Long id = 1L;
        when(userRepository.findUserId(id)).thenReturn(null);

        userServiceImp.deleteUser(id);

        verify(userRepository).findUserId(id);
    }


    @Test
    void testDeleteUser_userFound() throws Exception {
        Long id = 1L;
        User user = new User(id, "revan", true);
        when(userRepository.findUserId(id)).thenReturn(user);

        userServiceImp.deleteUser(id);

        verify(userRepository).findUserId(id);
        verify(userRepository).delete(user);
    }

    @Test
    void testGetUser_userDoesntFound() throws Exception {
        Long id = 2L;
        when(userRepository.findUserId(id)).thenReturn(null);

        userServiceImp.getUser(id);

        verify(userRepository).findUserId(id);
    }

    @Test
    void testGetUser_userFound() throws Exception {
        Long id = 2L;
        User user = new User(id, "revan", true);
        when(userRepository.findUserId(id)).thenReturn(user);

        var retrievedUser = userServiceImp.getUser(id);

        Assertions.assertEquals(user, retrievedUser);
        verify(userRepository).findUserId(id);
    }
}
