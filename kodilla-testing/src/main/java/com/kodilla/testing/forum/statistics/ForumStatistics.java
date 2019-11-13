package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private Statistics statistics;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getUserCount() {
        return statistics.usersNames().size();
    }

    public int getPostCount() {
        return statistics.postsCount();
    }

    public int getCommentCount() {
        return statistics.commentsCount();
    }

    public double getAvrPostOnUser() {
        return getUserCount() != 0 ? (double)getPostCount() / getUserCount() : 0;
    }

    public double getAvrCommentOnUser() {
        return getUserCount() != 0 ? (double)getCommentCount() / getUserCount() : 0;
    }

    public double getAvrCommentOnPost() {
        return getPostCount() != 0 ? (double)getCommentCount() / getPostCount() : 0;
    }
}
