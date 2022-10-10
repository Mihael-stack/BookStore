package com.mihael.bookStore.representations;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientErrorInformation {
    private String message;

    public ClientErrorInformation(){} //NOTE: The httpMessageConvertor for xml needs an empty no-args constructor.
    public ClientErrorInformation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
