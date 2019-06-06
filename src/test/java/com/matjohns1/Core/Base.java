package com.matjohns1.Core;

import com.matjohns1.Interactions.ActionModule;
import org.testng.annotations.AfterClass;

/**
 * Created by matjohns1 on 6/5/19 8:40 AM
 */
public class Base extends D_Driver {


    public ActionModule<?> returnDriver() {
        return super.actions;
    }

    @AfterClass(alwaysRun = true)
    public void Teardown()
    {
        actions.Teardown();
    }

}
