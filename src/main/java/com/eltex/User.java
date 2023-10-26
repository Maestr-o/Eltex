package com.eltex;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record User(
        @NotNull long id,
        @NotNull String name,
        @NotNull String login,
        @Nullable String avatar) {

    Builder builder() {
        return new Builder()
                .setId(id)
                .setName(name)
                .setLogin(login)
                .setAvatar(avatar);
    }

    static class Builder {
        @NotNull long id = 0;
        @NotNull String name = "";
        @NotNull String login = "";
        @Nullable String avatar = "";

        Builder setId(@NotNull final long id) {
            this.id = id;
            return this;
        }

        Builder setName(@NotNull final String name) {
            this.name = name;
            return this;
        }

        Builder setLogin(@NotNull final String login) {
            this.login = login;
            return this;
        }

        Builder setAvatar(@Nullable final String avatar) {
            this.avatar = avatar;
            return this;
        }

        public User build() {
            return new User(id, name, login, avatar);
        }
    }
}
