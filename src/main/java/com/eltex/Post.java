package com.eltex;
public record Post(String content, String author, int likes) {
    Builder builder() {
        return new Builder()
                .setAuthor(author)
                .setContent(content)
                .setLikes(likes);
    }
    static class Builder {
        // Обязательно указываем начальные значения полей
        private String content = "";
        private String author = "";
        private int likes = 0;
        // Каждый метод строителя запоминает данные и возвращает сам себя
        public Builder setContent(final String content) {
            this.content = content;
            return this;
        }
        public Builder setAuthor(final String author) {
            this.author = author;
            return this;
        }
        public Builder setLikes(final int likes) {
            this.likes = likes;
            return this;
        }
        // В финале вызываем build, чтобы получить результат
        public Post build() {
            return new Post(content, author, likes);
        }
    }
}