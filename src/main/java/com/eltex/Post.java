package com.eltex;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public record Post(
        @NotNull long id,
        @NotNull long authorId,
        @NotNull String author,
        @Nullable String authorJob,
        @Nullable String authorAvatar,
        @NotNull String content,
        @NotNull String published,
        @Nullable String link,
        @NotNull boolean mentionedMe,
        @NotNull boolean likedByMe,
        @Nullable Coordinates coords,
        @Nullable Attachment attachment,
        @NotNull List<Long> likeOwnerIds,
        @NotNull Map<Long, UserPreview> users,
        @NotNull List<Long> mentionIds,
        Post original) {
    public boolean isOriginal() {
        return original == null;
    }

    Builder builder() {
        return new Builder()
                .setId(id)
                .setAuthorId(authorId)
                .setAuthor(author)
                .setAuthorJob(authorJob)
                .setAuthorAvatar(authorAvatar)
                .setContent(content)
                .setPublished(published)
                .setLink(link)
                .setMentionedMe(mentionedMe)
                .setLikedByMe(likedByMe)
                .setCoords(coords)
                .setAttachment(attachment)
                .setLikeOwnerIds(likeOwnerIds)
                .setUsers(users)
                .setMentionIds(mentionIds)
                .setOriginal(original);
    }
    static class Builder {
        // Обязательно указываем начальные значения полей
        @NotNull private long id = 0;
        @NotNull private long authorId = 0;
        @NotNull private String author = "";
        @Nullable private String authorJob = null;
        @Nullable private String authorAvatar = null;
        @NotNull private String content = "";
        @NotNull private String published = "01-01-1980 00:00:00";
        @Nullable private String link = null;
        @NotNull private boolean mentionedMe = false;
        @NotNull private boolean likedByMe = false;
        @Nullable private Coordinates coords = null;
        @Nullable private Attachment attachment = null;
        @NotNull private List<Long> likeOwnerIds = Collections.emptyList();
        @NotNull private Map<Long, UserPreview> users = Collections.emptyMap();
        @NotNull private List<Long> mentionIds = Collections.emptyList();
        @Nullable private Post original = null;

        // Каждый метод строителя запоминает данные и возвращает сам себя
        public Builder setId(@NotNull long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(@NotNull long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthor(@NotNull final String author){
            this.author = author;
            return this;
        }

        public Builder setAuthorJob(@Nullable String authorJob) {
            this.authorJob = authorJob;
            return this;
        }

        public Builder setAuthorAvatar(@Nullable String authorAvatar) {
            this.authorAvatar = authorAvatar;
            return this;
        }

        public Builder setContent(@NotNull final String content){
            this.content = content;
            return this;
        }

        public Builder setPublished(@NotNull String published) {
            this.published = published;
            return this;
        }

        public Builder setLink(@Nullable String link) {
            this.link = link;
            return this;
        }

        public Builder setMentionedMe(@NotNull boolean mentionedMe) {
            this.mentionedMe = mentionedMe;
            return this;
        }

        public Builder setLikedByMe(@NotNull boolean likedByMe) {
            this.likedByMe = likedByMe;
            return this;
        }

        public Builder setCoords(@Nullable Coordinates coords) {
            this.coords = coords;
            return this;
        }

        public Builder setAttachment(@Nullable Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder setLikeOwnerIds(@NotNull List<Long> likeOwnerIds) {
            this.likeOwnerIds = likeOwnerIds;
            return this;
        }

        public Builder setUsers(@NotNull Map<Long, UserPreview> users) {
            this.users = users;
            return this;
        }

        public Builder setMentionIds(@NotNull List<Long> mentionIds) {
            this.mentionIds = mentionIds;
            return this;
        }

        public Builder setOriginal(Post original) {
            this.original = original;
            return this;
        }

        // В финале вызываем build, чтобы получить результат
        public Post build() {
            return new Post(id, authorId, author, authorJob, authorAvatar, content, published, link, mentionedMe,
                    likedByMe, coords, attachment, likeOwnerIds, users, mentionIds, original);
        }
    }
}