package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUser;

    public Forum(final List<ForumUser> forumUser) {
        this.forumUser = forumUser;
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUser);
    }
}
