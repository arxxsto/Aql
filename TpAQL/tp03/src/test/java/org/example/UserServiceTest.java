package org.example;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class UserServiceTest {
    @Mock
    private UserRepository mockUserRepository;
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(mockUserRepository);
    }

    @Test
    public void testGetUserById() {
        long userId = 1L;
        User mockUser = new User(userId, "John Doe", "jeandupont@email.com");
        when(mockUserRepository.findUserById(userId)).thenReturn(mockUser);
        User returnedUser = userService.getUserById(userId);
        verify(mockUserRepository).findUserById(userId);
        assertNotNull(returnedUser);
        assertEquals(userId, returnedUser.getId());
        assertEquals("John Doe", returnedUser.getUsername());
        assertEquals("jeandupont@email.com", returnedUser.getEmail());
    }


}