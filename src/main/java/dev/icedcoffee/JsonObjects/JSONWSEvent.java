package dev.icedcoffee.JsonObjects;

import dev.icedcoffee.*;

public class JSONWSEvent {
    public WebSocketEvent type;
    public Object data;

    public JSONWSEvent(WebSocketEvent type, Object data) {
        this.type = type;
        this.data = data;
    }
}
