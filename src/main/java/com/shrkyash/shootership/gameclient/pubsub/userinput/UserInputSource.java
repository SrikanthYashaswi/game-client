package com.shrkyash.shootership.gameclient.pubsub.userinput;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserInputSource {
    @Output("userInputChannel")
    MessageChannel getChannel();
}
