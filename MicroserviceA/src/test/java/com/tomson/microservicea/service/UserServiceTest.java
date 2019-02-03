package com.tomson.microservicea.service;

import com.tomson.microservicea.dto.CreateUserDto;
import com.tomson.microservicea.dto.UpdateUserDto;
import com.tomson.microservicea.model.User;
import com.tomson.microservicea.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository, null);
    }

    @Test
    public void getUserTest() {
        final Long userId = 1L;

        User user = new User();
        user.setId(userId);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userService.getUser(userId);

        Assert.assertEquals(user.getId(), result.getId());

        Mockito.verify(userRepository, Mockito.times(1)).findById(userId);
    }

    @Test
    public void createUserTest(){
        User user = new User();
        user.setFirstName("Tomasz");
        user.setLastName("Banaszuk");
        user.setEmail("tbanaszuk@gmail.com");
        user.setPhone("123");

        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setFirstName("Tomasz");
        createUserDto.setLastName("Banaszuk");
        createUserDto.setEmail("tbanaszuk@gmail.com");
        createUserDto.setPhone("123");

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User result = userService.createUser(createUserDto);

        Assert.assertEquals(createUserDto.getEmail(), result.getEmail());
        Assert.assertEquals(createUserDto.getFirstName(), result.getFirstName());
        Assert.assertEquals(createUserDto.getLastName(), result.getLastName());
        Assert.assertEquals(createUserDto.getPhone(), result.getPhone());
    }

    @Test
    public void updateUserTest() {
        final Long userId = 1L;

        User user = new User();
        user.setId(userId);

        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setId(1L);
        updateUserDto.setFirstName("Tomasz");
        updateUserDto.setLastName("Banaszuk");
        updateUserDto.setEmail("tbanaszuk@gmail.com");
        updateUserDto.setPhone("123");

        Mockito.when(userRepository.findById(updateUserDto.getId())).thenReturn(Optional.of(user));

        User result = userService.updateUser(updateUserDto);

        Assert.assertEquals(updateUserDto.getId(), result.getId());
        Assert.assertEquals(updateUserDto.getFirstName(), result.getFirstName());
        Assert.assertEquals(updateUserDto.getLastName(), result.getLastName());
        Assert.assertEquals(updateUserDto.getEmail(), result.getEmail());
        Assert.assertEquals(updateUserDto.getPhone(), result.getPhone());
    }

    @Test(expected = NullPointerException.class)
    public void updateUserTestShouldThrowNullPointerException() {
        Mockito.when(userRepository.findById(Matchers.anyLong())).thenReturn(null);

        userService.updateUser(new UpdateUserDto());
    }
    @Test
    public void getUsersTest(){
        List<User> list= new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);

        list.add(user1);
        list.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(list);

        List<User> result = userService.getUsers();

        Assert.assertTrue(!result.isEmpty());
        Assert.assertEquals(2, result.size());

        Assert.assertEquals(new Long(1), result.get(0).getId());
        Assert.assertEquals(new Long(2), result.get(1).getId());
    }
    @Test
    public void deleteUserTest(){
        final Long userId = 1L;

        Mockito.doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId);
    }
}
