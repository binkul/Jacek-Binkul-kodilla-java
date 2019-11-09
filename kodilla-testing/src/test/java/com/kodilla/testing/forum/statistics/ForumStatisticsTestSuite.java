package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.*;
import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {
    private static int testNr = 1;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: BEGIN");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: END");
    }

    @Before
    public void before() {
        System.out.println("Test number #" + testNr++);
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateFiveUsers();
        int postsCountMock = 0;
        int commentsCountMock = 5000;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of posts = 0");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(5, usersCount);
        Assert.assertEquals(0, postsCount);
        Assert.assertEquals(5000, commentsCount);
        Assert.assertEquals(0, avrPostOnUser, 0);
        Assert.assertEquals(1000, avrCommentOnUser, 0);
        Assert.assertEquals(0, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsThousandPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateFiveUsers();
        int postsCountMock = 1000;
        int commentsCountMock = 5000;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of posts = 1000");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(5, usersCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(5000, commentsCount);
        Assert.assertEquals(200, avrPostOnUser, 0);
        Assert.assertEquals(1000, avrCommentOnUser, 0);
        Assert.assertEquals(5, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComments() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateFiveUsers();
        int postsCountMock = 1000;
        int commentsCountMock = 0;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of comments = 0");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(5, usersCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(0, commentsCount);
        Assert.assertEquals(200, avrPostOnUser, 0);
        Assert.assertEquals(0, avrCommentOnUser, 0);
        Assert.assertEquals(0, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsMorePosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateFiveUsers();
        int postsCountMock = 1000;
        int commentsCountMock = 200;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of comments < posts");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(5, usersCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(200, commentsCount);
        Assert.assertEquals(200, avrPostOnUser, 0);
        Assert.assertEquals(40, avrCommentOnUser, 0);
        Assert.assertEquals(0.2, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsMoreComments() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateFiveUsers();
        int postsCountMock = 200;
        int commentsCountMock = 1000;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of comments > posts");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(5, usersCount);
        Assert.assertEquals(200, postsCount);
        Assert.assertEquals(1000, commentsCount);
        Assert.assertEquals(40, avrPostOnUser, 0);
        Assert.assertEquals(200, avrCommentOnUser, 0);
        Assert.assertEquals(5, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        int postsCountMock = 1000;
        int commentsCountMock = 5000;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of users = 0");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(0, usersCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(5000, commentsCount);
        Assert.assertEquals(0, avrPostOnUser, 0);
        Assert.assertEquals(0, avrCommentOnUser, 0);
        Assert.assertEquals(5, avrCommentOnPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsHundredUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesMock = generateHundredUsers();
        int postsCountMock = 1000;
        int commentsCountMock = 5000;
        when(statisticsMock.usersNames()).thenReturn(userNamesMock);
        when(statisticsMock.postsCount()).thenReturn(postsCountMock);
        when(statisticsMock.commentsCount()).thenReturn(commentsCountMock);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        System.out.println("Test for number of users = 100");

        //When
        int usersCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostCount();
        int commentsCount = forumStatistics.getCommentCount();
        double avrPostOnUser = forumStatistics.getAvrPostOnUser();
        double avrCommentOnUser = forumStatistics.getAvrCommentOnUser();
        double avrCommentOnPost = forumStatistics.getAvrCommentOnPost();

        //Then
        Assert.assertEquals(100, usersCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(5000, commentsCount);
        Assert.assertEquals(10, avrPostOnUser, 0);
        Assert.assertEquals(50, avrCommentOnUser, 0);
        Assert.assertEquals(5, avrCommentOnPost, 0);
    }

    private List<String> generateHundredUsers() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            result.add("Jacek");
        }
        return result;
    }

    private List<String> generateFiveUsers() {
        List<String> result = new ArrayList<>();

        result.add("Jacek");
        result.add("Placek");
        result.add("Michal");
        result.add("Zdzichu");
        result.add("Mirella");
        return result;
    }
}
