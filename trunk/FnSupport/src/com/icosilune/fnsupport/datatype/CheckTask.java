/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import com.icosilune.fnsupport.api.FnDataResult;
import com.icosilune.fnsupport.api.FnProvider;
import org.openide.util.RequestProcessor;

/**
 *
 * @author Calvin Ashmore
 */
public class CheckTask {

    // Make this a lookup on FnDataObject
    private static RequestProcessor RP = new RequestProcessor("findError"); // NOI18N
    private final RequestProcessor.Task findError;
    private FnDataObject dataObject;

    public CheckTask(FnDataObject obj) {
        this.dataObject = obj;

        findError = RP.create(new MyRunnable(), true);
        findError.setPriority(Thread.MIN_PRIORITY);
    }

    public void schedule(int delay) {
        findError.schedule(delay);
        
        //System.out.println("=== Scheduling update ===");
        //Thread.dumpStack();
    }

    private class MyRunnable implements Runnable {

        // get the FnProvider, construct a FnDataResult from this, and then 
        // pass the result to its listeners.
        public void run() {
            FnProvider provider = dataObject.getLookup().lookup(FnProvider.class);
            if(provider == null)
                return; // report error, warning?
            
            FnDataResult result = provider.getResult();

            for (FnResultListener listener : dataObject.getLookup().lookupAll(FnResultListener.class)) {
                listener.onResult(result);
            }
        }
    }
}
