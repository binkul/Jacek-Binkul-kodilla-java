package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int userCount;
    private int postCount;
    private int commentCount;
    private double avrPostOnUser;
    private double avrCommentOnUser;
    private double avrCommentOnPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.userCount = statistics.usersNames().size();
        this.postCount = statistics.postsCount();
        this.commentCount = statistics.commentsCount();
        this.avrPostOnUser = this.userCount != 0 ? (double)this.postCount / this.userCount : 0;
        this.avrCommentOnUser = this.userCount != 0 ? (double)this.commentCount / this.userCount : 0;
        this.avrCommentOnPost = this.postCount != 0 ? (double)this.commentCount / this.postCount : 0;
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAvrPostOnUser() {
        return avrPostOnUser;
    }

    public double getAvrCommentOnUser() {
        return avrCommentOnUser;
    }

    public double getAvrCommentOnPost() {
        return avrCommentOnPost;
    }
}
