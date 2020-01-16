package com.kodilla.patterns.startegy.social;

import com.kodilla.patterns.strategy.social.Millenials;
import com.kodilla.patterns.strategy.social.User;
import com.kodilla.patterns.strategy.social.YGeneration;
import com.kodilla.patterns.strategy.social.ZGeneration;
import com.kodilla.patterns.strategy.social.media.FacebookPublisher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTestSuite {

    @Before
    public void printStart() {
        System.out.println("\nStart new user tests.");
    }

    @After
    public void printEnd() {
        System.out.println("End test.");
    }

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User mark = new Millenials("Mark Zuckerberg");
        User krycha = new YGeneration("Krystynka P.");
        User steve = new ZGeneration("Greta Thun");

        //When
        String markUse = mark.useMedia();
        System.out.println(markUse);
        String krychaUse = krycha.useMedia();
        System.out.println(krychaUse);
        String steveUse = steve.useMedia();
        System.out.println(steveUse);

        //Then
        Assert.assertEquals("Mark Zuckerberg is using FaceBook as social media.", markUse);
        Assert.assertEquals("Krystynka P. prefers to use Twitter to chat with friends.", krychaUse);
        Assert.assertEquals("Greta Thun likes to use Snapchat to communicate with his friends.", steveUse);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User kristin = new YGeneration("Kristin Stuart");

        //When
        String kristinUse = kristin.useMedia();
        System.out.println(kristinUse);
        kristin.setSocialPublisher(new FacebookPublisher());
        kristinUse = kristin.useMedia();
        System.out.println(kristinUse + " She changed her mind.");

        //Then
        Assert.assertEquals("Kristin Stuart is using FaceBook as social media.", kristinUse);

    }
}
