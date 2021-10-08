package com.cube007.JavaPlus.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User user = new User();
        user.setAge(18);

        User user1 = new User();
        user1.setAge(22);

        userList.add(user);
        userList.add(user1);

        remove(userList);
        System.out.println(userList);
    }

    public static void remove(List<User> userList) {
        userList.removeIf(user -> user.getAge() > 20);

    }
}
