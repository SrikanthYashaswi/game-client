package com.shrkyash.shootership.gameclient.pubsub;

import com.shrkyash.shootership.gameclient.config.Properties;
import com.shrkyash.shootership.gameclient.models.base.GameInput;
import com.shrkyash.shootership.gameclient.models.base.UserInput;
import com.shrkyash.shootership.gameclient.pubsub.userinput.UserInputSource;
import com.shrkyash.shootership.gameclient.pubsub.userregistration.UserRegistrationSource;
import com.shrkyash.shootership.gameclient.utils.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageDispatcher implements ApplicationRunner {

    private final UserRegistrationSource userRegistrationSource;
    private final UserInputSource userInputSource;
    private final Properties properties;
    private final Logger logger = LoggerFactory.getLogger(MessageDispatcher.class);

    public MessageDispatcher(UserRegistrationSource userRegistrationSource,
                             UserInputSource userInputSource,
                             Properties properties) {
        this.userRegistrationSource = userRegistrationSource;
        this.userInputSource = userInputSource;
        this.properties = properties;
    }

    public void registerClient() {
        this.userRegistrationSource.getChannel().send(MessageBuilder.withPayload(properties.getUser()).build());
        this.logger.info("Wooh! Registered with game server");
    }

    public void dispatchGameInput(GameInput gameInput) {
        final var userInput = new UserInput(properties.getId(), gameInput);
        this.userInputSource.getChannel().send(MessageBuilder.withPayload(userInput).build());
    }

    @Override
    public void run(ApplicationArguments args) {
        this.registerClient();
    }
}
