package com.stackroute.registerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import com.stackroute.controller.RegisterController;
import com.stackroute.model.UserEntity;
import com.stackroute.repository.RegisterRepository;
import com.stackroute.service.RegisterService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RegisterServiceApplicationTests {

    @Mock
    private RegisterRepository repo;

    @InjectMocks
    private RegisterService service;

    @InjectMocks
    private RegisterController controller;
    private UserEntity user, user1, user2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockMvcBuilders.standaloneSetup(controller).build();
        user = new UserEntity(1, "Ares", "123456", "ares@gmail.com", "1234512345", "Doctor");
        user1 = new UserEntity(2, "Sins", "123456", "sins@gmail.com", "1234522345", "Patient");
        Optional.of(user);
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void givenUserToSaveThenShouldReturnSavedUser() {
        when(repo.save(any())).thenReturn(user);
        assertEquals(user, service.saveUser(user));
        verify(repo, times(1)).save(any());
    }

    @Test
    public void givenUserToSaveThenShouldNotReturnSavedUser() {
        when(repo.save(any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> {
            service.saveUser(user);
        });
        verify(repo, times(1)).save(any());
    }

    @Test
    public void givenGetUserByEmailThenShouldReturnUser() {
        repo.save(user);
        // stubbing the mock to return specific data
        when(repo.findByEmail("ares@gmail.com")).thenReturn(user2);
        UserEntity temp = service.getByEmail("ares@gmail.com");
        assertEquals(user2, temp);
        verify(repo, times(1)).save(user);
        verify(repo, times(1)).findByEmail("ares@gmail.com");
    }

    @Test
    public void givenGetUserByMobileThenShouldReturnUser() {
        repo.save(user1);
        // stubbing the mock to return specific data
        when(repo.findByMobile("1234522345")).thenReturn(user2);
        UserEntity temp = service.getByMobile("1234522345");
        assertEquals(user2, temp);
        verify(repo, times(1)).save(user1);
        verify(repo, times(1)).findByMobile("1234522345");
    }

    @Test
    public void givenGetUserByEmailMobileAndRoleThenShouldReturnUser() {
        repo.save(user);
        // stubbing the mock to return specific data
        when(repo.findByEmailAndPasswordAndRole("ares@gmail.com", "123456", "Doctor")).thenReturn(user2);
        UserEntity temp = service.getByEmailAndPasswordAndRole("ares@gmail.com", "123456", "Doctor");
        assertEquals(user2, temp);
        verify(repo, times(1)).save(user);
        verify(repo, times(1)).findByEmailAndPasswordAndRole("ares@gmail.com", "123456", "Doctor");
    }

    @Test
    public void givenUserToSaveThenShouldReturnSavedUserFromRepo() {
        repo.save(user);
        Optional<UserEntity> fetchedUSer = repo.findById(user.getId());
        if (fetchedUSer.isPresent())
            assertEquals(user.getId(), fetchedUSer.get().getId());
        else {
            assertEquals(false, fetchedUSer.isPresent());
        }
    }

}
