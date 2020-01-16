package com.kodilla.patterns.strategy.social.media;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return " prefers to use Twitter to chat with friends.";
    }
}
