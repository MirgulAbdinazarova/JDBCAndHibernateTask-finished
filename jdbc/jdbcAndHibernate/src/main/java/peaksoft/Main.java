package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
     //   userService.saveUser("Asan","Kadyrov", (byte) 25);
     //   userService.saveUser("Asan","Kadyrov", (byte) 25);
      //  userService.saveUser("Asan","Kadyrov", (byte) 25);
     //   userService.removeUserById(1);
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("testName", "testLastName", (byte) 11);
        List<User> userList = userService.getAllUsers();
        System.out.println(userList.size());


    }
}
