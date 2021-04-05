package com.mediator;

import lombok.Builder;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RESTMediator {

    public RESTMediator() {
    }

    public String getUrlContents(String theUrl) throws IOException {
        StringBuilder content = new StringBuilder();

        URL url = new URL(theUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream())
        );
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line + "\n");
        }
        bufferedReader.close();
        return content.toString();
    }
}
