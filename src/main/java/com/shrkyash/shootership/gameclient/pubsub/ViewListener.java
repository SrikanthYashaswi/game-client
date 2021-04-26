package com.shrkyash.shootership.gameclient.pubsub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shrkyash.shootership.gameclient.config.Properties;
import com.shrkyash.shootership.gameclient.services.EnvironmentPlayer;
import com.shrkyash.shootership.gameclient.utils.TypeConverter;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
@Component
public class ViewListener {
    private final TypeConverter typeConverter;
    private final EnvironmentPlayer environmentPlayer;
    private final Properties properties;

    public ViewListener(TypeConverter typeConverter, EnvironmentPlayer environmentPlayer, Properties properties) {
        this.typeConverter = typeConverter;
        this.environmentPlayer = environmentPlayer;
        this.properties = properties;
    }

    @StreamListener(target = Sink.INPUT)
    public void receiveMessage(String unParsedFrames) throws JsonProcessingException {
        final var frame = this.typeConverter.getFrame(unParsedFrames);
        if (frame.userId.equals(properties.getId())) {
            this.environmentPlayer.setLastFrame(frame.baseFrame);
        }
    }
}
