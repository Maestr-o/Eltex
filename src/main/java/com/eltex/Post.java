package com.eltex;
public record Post(long id, long authorId, String author, String authorJob, String authorAvatar, String content,
                   String published, String link, boolean mentionedMe, boolean likedByMe) {
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
                .setLikedByMe(likedByMe);
    }
    static class Builder {
        // Обязательно указываем начальные значения полей
        private long id = 0;
        private long authorId = 0;
        private String author = "";
        private String authorJob = "";
        private String authorAvatar = "";
        private String content = "";
        private String published = "01-01-1980 00:00:00";
        private String link = "";
        private boolean mentionedMe = false;
        private boolean likedByMe = false;

        // Каждый метод строителя запоминает данные и возвращает сам себя
        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthor(final String author){
            this.author = author;
            return this;
        }

        public Builder setAuthorJob(String authorJob) {
            this.authorJob = authorJob;
            return this;
        }

        public Builder setAuthorAvatar(String authorAvatar) {
            this.authorAvatar = authorAvatar;
            return this;
        }

        public Builder setContent(final String content){
            this.content = content;
            return this;
        }

        public Builder setPublished(String published) {
            this.published = published;
            return this;
        }

        public Builder setLink(String link) {
            this.link = link;
            return this;
        }

        public Builder setMentionedMe(boolean mentionedMe) {
            this.mentionedMe = mentionedMe;
            return this;
        }

        public Builder setLikedByMe(boolean likedByMe) {
            this.likedByMe = likedByMe;
            return this;
        }

        // В финале вызываем build, чтобы получить результат
        public Post build(){
            return new Post(id, authorId, author, authorJob, authorAvatar, content, published, link, mentionedMe,
                    likedByMe);
        }
    }
}