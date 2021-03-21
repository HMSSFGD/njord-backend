package dev.icedcoffee;

import dev.icedcoffee.JsonObjects.*;
import java.util.*;
import java.util.concurrent.*;
import javax.json.bind.Jsonb;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint("/ws")
@ApplicationScoped
public class FrontendSocket {

    @Inject
    Jsonb om;

    private List<Session> sessions = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        JSONWSEvent e = new JSONWSEvent(WebSocketEvent.CONNECTIONOK, "All good bruh");
        sendMessage(session, om.toJson(e));
    }

    @OnMessage
    public void onMessage(String message, Session session) {
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable cause) {
        sessions.remove(session);
        cause.printStackTrace();
    }

    public void broadcast(WebSocketEvent e, Report r) {
        String msg = om.toJson(new JSONWSEvent(e, r));
        broadcast(msg);
    }

    private void broadcast(String message) {
        sessions.forEach(s -> {
            sendMessage(s, message);
        });
    }

    private void sendMessage(Session s, String message) {
        s.getAsyncRemote().sendObject(message, result -> {
            if (result.getException() != null) {
                System.err.println("Unable to send message: " + result.getException());
            }
        });
    }
}
