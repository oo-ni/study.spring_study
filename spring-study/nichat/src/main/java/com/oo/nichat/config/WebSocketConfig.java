package com.oo.nichat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        // enableSimpleBroker -> 특정 경로로 시작하는 메시지를 클라이언트에게 바로 전달할 수 있게 함.
        messageBrokerRegistry.enableSimpleBroker("/topic");
        // setApplicationDestinationPrefixes -> 클라이언트가 전송하는 메시지를 해당 경로로 전송하게 하고, 처리할 핸들러에 연결.
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // "/ws"로 WebSocket 엔드포인트를 설정하고, SockJS를 사용
        stompEndpointRegistry.addEndpoint("/ws").withSockJS();
    }
}
