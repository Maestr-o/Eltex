package com.eltex;
public class Main {
    public static void main(String[] args) {
        final var service = new WallService();
        service.like();
        System.out.println(service.getPost()); // Post[content=, author=Anonymous, likes=1]
    }
}