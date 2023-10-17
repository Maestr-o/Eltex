package com.eltex;

public class Main {
    public static void main(String[] args) {
        final var service = new WallService();
        service.setId(1);
        service.setAuthorId(1);
        service.setAuthor("Evgeniy");
        service.setAuthorJob("Eltex");
        service.setAuthorAvatar("dart_vader.png");
        service.setContent("Hello!");
        service.setPublished("17-10-2023 15:23:38");
        service.setLink("qwertyuiop.com/index.html");
        service.setMentionedMe(true);
        service.setLikedByMe(true);
        System.out.println(service.getPost());
    }
}