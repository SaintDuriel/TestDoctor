package com.TestDoctor.API;

import java.net.MalformedURLException;
import java.net.URL;

import com.TestDoctor.Core.A_Platform.CloudPlatform;
import com.TestDoctor.Core.B_Environment.Environment;

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
        }
        return cloudURL;
    }

}
