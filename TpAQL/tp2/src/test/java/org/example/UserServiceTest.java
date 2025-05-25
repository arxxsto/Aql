package org.example;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
public class UserServiceTest {
    @Mock
    private UserApi UserApiMock;
    @Test
    public void testCreerUser() throws ServiceException {

        User user = new User("Jean", "Dupont", "jeandupont@email.com");
        when( UserApiMock.creerUser(user) ).thenReturn(Boolean.TRUE);

        UserService ServiceMock = mock(UserService.class);

        ServiceMock.creerUser(user);

        verify(ServiceMock).creerUser(user);

        // Exo 03 :

        verify(ServiceMock,never()).creerUser(null);


        int idUser = 123;
        when(ServiceMock.creerUser(user)).thenReturn(idUser);
        int nb =  ServiceMock.creerUser(user);
        assertEquals(123, nb);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        when(UserApiMock.creerUser(any(User.class))).thenReturn(true);
        UserApiMock.creerUser(user);

        verify(UserApiMock).creerUser(argumentCaptor.capture());
        User UserCapture = argumentCaptor.getValue();

        assertEquals(user.Prenom, UserCapture.Prenom);
        assertEquals(user.Nom, UserCapture.Nom);
        assertEquals(user.Adresse, UserCapture.Adresse);
    }
}
