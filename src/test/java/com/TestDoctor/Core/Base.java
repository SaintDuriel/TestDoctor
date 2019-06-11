package com.TestDoctor.Core;

import org.testng.annotations.AfterClass;

import com.TestDoctor.Interactions.ActionModule;

/**
 * Created by matjohns1 on 6/5/19 8:40 AM
 */
public class Base extends D_Driver {


    public ActionModule<?,?> returnDriver() {
        return super.actions;
    }

    @AfterClass(alwaysRun = true)
    public void Teardown()
    {
        actions.Teardown();
    }

}
