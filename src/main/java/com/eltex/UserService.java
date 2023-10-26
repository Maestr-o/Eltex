package com.eltex;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private long nextId = 0;
    private final List<User> users = new ArrayList<>();

    public void addUser(final String name, final String login) {
        users.add(
                new User.Builder()
                        .setId(++nextId)
                        .setName(name)
                        .setLogin(login)
                        .build()
        );
    }

    public void save(final User user) {
        if (user.id() == 0)
            users.add(user);
        else
            users.set((int)user.id(), user);
    }

    public void removeById(final long userId) {
        final User user = getById(userId);
        users.remove(user);
    }

    public void updateUser(final User newUser) {
        for (int i = 0; i < users.size(); i++) {
            final User user = users.get(i);
            if (user.id() == newUser.id()) {
                users.set(i, newUser);
                break;
            }
        }
    }

    public void setName(String name, final long userId) {
        updateUser(
                getById(userId)
                        .builder()
                        .setName(name)
                        .build()
        );
    }

    public void setLogin(String login, final long userId) {
        updateUser(
                getById(userId)
                        .builder()
                        .setLogin(login)
                        .build()
        );
    }

    public void setAvatar(String avatar, final long userId) {
        updateUser(
                getById(userId)
                        .builder()
                        .setAvatar(avatar)
                        .build()
        );
    }

    public User getById(final long userId) {
        for (final User user : users) {
            if (userId == user.id()) {
                return user;
            }
        }
        throw new NotFoundException("User not found!");
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
