package com.example.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint(value = "/websocket")
public class Websocket {

    public final Logger logger = LoggerFactory.getLogger(Websocket.class);

    @OnOpen
    public void onOpen(Session session) {
        logger.info("有新websocket连接:fd:" + session.getId());
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        try {
            session.getBasicRemote().sendText("from server:" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("接受到fd:" + session.getId() + "的消息：" + msg);
    }


    @OnClose
    public void onClose(Session session) {
        logger.info("websocket连接closed:" + session.getId());
    }
}
