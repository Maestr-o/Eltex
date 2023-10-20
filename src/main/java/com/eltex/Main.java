package com.eltex;
import org.jetbrains.annotations.*;

public class Main {
    public static void main(String[] args) {
        final var coords = new Coordinates.Builder()
                .setLat(55.58)
                .setLongVal(52.22)
                .build();
        final var attachment = new Attachment.Builder()
                .setType(Attachment.AttachmentType.AUDIO)
                .setUrl("https://a.com/1.ogg")
                .build();
        final var service = new WallService();
        service.setId(1);
        service.setAuthorId(1);
        service.setAuthor("Evgeniy");
        service.setAuthorJob("Eltex");
        service.setContent("Hello!");
        service.setPublished("20-10-2023 20:35:39");
        service.setMentionedMe(true);
        service.setLikedByMe(true);
        service.setCoors(coords);
        service.setAttachment(attachment);

        final var repost = new Post.Builder()
                .setOriginal(service.getPost())
                .build();
        System.out.println(getOriginal(repost));
    }

    public static Post getOriginal(final @NotNull Post post){
        final Post original;
        if (post.original() != null) {
            original = post.original();
        } else {
            original = post;
        }
        return original;
    }
}