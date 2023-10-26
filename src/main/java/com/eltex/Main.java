package com.eltex;
import org.jetbrains.annotations.*;

public class Main {
    public static void main(String[] args) {
        final var wallService = new WallService();
        wallService.addPost("Content");
        wallService.setAuthor("Evgeniy", 1);
        wallService.setAuthorId(1, 1);
        wallService.like(1, 1);
        wallService.like(1, 2);
        wallService.like(1, 1);
        System.out.println(wallService.getAll());

        try {
            final var userService = new UserService();
            userService.addUser("Ivan", "ivan02");
            userService.setAvatar("darth_vader.png", 1);
            System.out.println(userService.getAll());
            userService.removeById(1);
            System.out.println(userService.getAll());
            userService.removeById(1); // exception
        } catch (final NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Post getOriginal(final @NotNull Post post) {
        final Post original;
        if (post.original() != null)
            original = post.original();
        else
            original = post;
        return original;
    }
}