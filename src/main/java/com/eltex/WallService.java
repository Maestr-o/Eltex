package com.eltex;

import java.util.*;

public class WallService {
    private long nextId = 0;
    private final List<Post> posts = new ArrayList<>();

    public void addPost(String content) {
        posts.add(
                new Post.Builder()
                        .setId(++nextId)
                        .setContent(content)
                        .build()
        );
    }

    public void updatePost(final Post newPost) {
        for (int i = 0; i < posts.size(); i++) {
            final Post post = posts.get(i);
            if (newPost.id() == post.id()) {
                posts.set(i, newPost);
                break;
            }
        }
    }

    public void setAuthor(final String author, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setAuthor(author)
                        .build()
        );
    }

    public void setAuthorId(final long authorId, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setAuthorId(authorId)
                        .build()
        );
    }

    public void setAuthorJob(final String authorJob, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setAuthorJob(authorJob)
                        .build()
        );
    }

    public void setAuthorAvatar(final String authorAvatar, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setAuthorAvatar(authorAvatar)
                        .build()
        );
    }

    public void setContent(final String content, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setContent(content)
                        .build()
        );
    }

    public void setPublished(final String published, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setPublished(published)
                        .build()
        );
    }

    public void setLink(final String link, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setLink(link)
                        .build()
        );
    }

    public void setMentionedMe(final boolean mentionedMe, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setMentionedMe(mentionedMe)
                        .build()
        );
    }

    public void setLikedByMe(final boolean likedByMe, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setLikedByMe(likedByMe)
                        .build()
        );
    }

    public void setCoords(final Coordinates coords, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setCoords(coords)
                        .build()
        );
    }

    public void setAttachment(final Attachment attachment, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setAttachment(attachment)
                        .build()
        );
    }

    public void setUsers(final Map<Long, UserPreview> users, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setUsers(users)
                        .build()
        );
    }

    public void setMentionIds(final List<Long> mentionIds, final long postId) {
        updatePost(
                getById(postId)
                        .builder()
                        .setMentionIds(mentionIds)
                        .build()
        );
    }

    public void like(final long postId, final long userId){
        final Post post = getById(postId);
        final var mutableLikeOwnerIds = new ArrayList<>(post.likeOwnerIds());
        if (mutableLikeOwnerIds.contains(userId))
            mutableLikeOwnerIds.remove(userId);
        else
            mutableLikeOwnerIds.add(userId);
        final var allUserIds = new HashSet<>(post.mentionIds());
        allUserIds.addAll(mutableLikeOwnerIds);
        final var users = new HashMap<Long, UserPreview>();
        for (final long id : allUserIds) {
            users.put(id, new UserPreview("User " + id, null));
        }
        updatePost(
                post.builder()
                        .setLikeOwnerIds(Collections.unmodifiableList(mutableLikeOwnerIds))
                        .setUsers(Collections.unmodifiableMap(users))
                        .build()
        );
    }

    public Post getById(final long postId) {
        for (Post post : posts) {
            if (post.id() == postId)
                return post;
        }
        throw new NotFoundException("Post not found!");
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts);
    }
}
