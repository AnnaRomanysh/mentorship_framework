package com.epam.mentorship.data;


import com.epam.mentorship.core.models.User;
import com.epam.mentorship.utils.parsers.JsonReader;

import java.util.List;


public class UserData {

    public static final String USERS_FILE_NAME = "Users.json";

    public static List<User> getUsers() {
        return JsonReader.read(USERS_FILE_NAME, User.class);
    }

    public static User getUserById(int id) {
        List<User> users = getUsers();
        int size = users.size();
        if (id < 0 || id >= size) {
            throw new IllegalArgumentException("Can't get user by id: " + id + ". Available scope of id: >0 and <" + (size - 1));
        }
        return getUsers().get(id);
    }

    public static User getDefaultUser() {
        return getUserById(0);
    }

}
