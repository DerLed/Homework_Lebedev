package com.lebedev;

import com.lebedev.dao.UserDaoImpl;
import com.lebedev.entity.UserEntity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl ud = UserDaoImpl.getInstance();

        //save
        UserEntity user3 = new UserEntity("Василий", "888@mail.ru");
        ud.saveUser(user3);

        //find one
        UserEntity user2 = ud.findUserByName("Антон").get();
        UserEntity user1 = ud.findUserById(4L).get();

        //update
        user1.setName("Дмитрий");
        ud.updateUser(user1);

        //delete
        ud.deleteUser(user2);

        //find all
        List<UserEntity> users = ud.findAllUser();

        users.forEach(System.out::println);

        System.out.println(user2);
    }
}
