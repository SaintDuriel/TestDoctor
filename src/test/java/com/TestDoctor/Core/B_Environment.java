package com.TestDoctor.Core;

/**
 * Created by matjohns1 on 6/5/19 8:42 AM
 */


public class B_Environment extends A_Platform{
    public Environment env;

    public enum Environment {
        DEV,
        INT,
        QA,
        UAT,
        STAGE,
        PROD;
    }

    public void setTestEnvironment(String environment)
    {
        this.env = getTestEnvironmentEnum(environment);
    }

    public Environment getTestEnvironmentEnum(String environment)
    {
        for(Environment env : Environment.values())
        {
            if(environment.equalsIgnoreCase(env.toString()))
            {
                return env;
            }
        }
        return null;
    }



}
