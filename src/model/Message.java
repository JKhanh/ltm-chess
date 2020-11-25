/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author khanh
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    
    private Object object;
    private MessageType type;

    public Message() {
    }

    public Message(Object object, MessageType type) {
        this.object = object;
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
    
    public enum MessageType{
        LOGIN, SIGNUP, GETFRIEND, CHALLENGE, CHALLENGED, LOADGAME, ENDGAME, REPLAY
    }
}
