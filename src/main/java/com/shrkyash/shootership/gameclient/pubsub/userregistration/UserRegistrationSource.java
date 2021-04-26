package com.shrkyash.shootership.gameclient.pubsub.userregistration;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@EnableIntegration
public interface UserRegistrationSource {
    @Output("userRegistrationChannel")
    MessageChannel getChannel();
}
