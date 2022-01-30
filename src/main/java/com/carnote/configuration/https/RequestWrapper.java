package com.carnote.configuration.https;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class RequestWrapper extends HttpServletRequestWrapper {
    private boolean isSecure;

    public RequestWrapper(HttpServletRequest request) throws IOException
    {
        //So that other request method behave just like before
        super(request);
        this.isSecure = request.isSecure();
    }

    //Use this method to read the request isSecure N times
    public boolean isSecure() {
        return this.isSecure;
    }
}