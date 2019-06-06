package com.matjohns1.API;

import com.matjohns1.Core.B_Environment.Environment;
import com.matjohns1.Core.A_Platform.CloudPlatform;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by matjohns1 on 6/5/19 9:34 AM
 */
public class Environment_Handler {

    public URL getEnvironmentAPIURL(Environment env) throws MalformedURLException
    {
        URL environmentURL = null;

        switch(env) {

            case DEV:
                environmentURL = new URL("https://someAPIDomain.com");
                break;
            case INT:
                break;
            case QA:
                break;
            case UAT:
                break;
            case STAGE:
                break;
            case PROD:
                break;
        }
        return environmentURL;
    }

    public URL getDriverHubURL(CloudPlatform cloudPlatform) throws MalformedURLException
    {
        URL cloudURL = null;
        switch (cloudPlatform) {

            case LOCAL:
                cloudURL = new URL("https://127.0.0.1/");
                break;
            case BROWSERSTACK:
                break;
            case SAUCELABS:
                break;
            case EXPERITEST:
                break;
            case MOBILELABS:
                break;
        }
        return cloudURL;
    }

}
