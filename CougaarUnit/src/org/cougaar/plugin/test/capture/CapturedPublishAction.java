package org.cougaar.plugin.test.capture;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CapturedPublishAction implements Serializable {
    public final static int ACTION_ADD = 1;
    public final static int ACTION_CHANGE =2 ;
    public final static int ACTION_REMOVE = 3;
    public final static int ACTION_OPEN_TRANSACTION = 4;
    public final static int ACTION_CLOSE_TRANSACTION = 5;
    public final static int ACTION_INTERAGENT_TRANSFER = 6;

    public String publishedObject;
    public int action;
    public String publishingSource;
    public long timeStamp;

    public CapturedPublishAction(int action, String publishedObject, String publishingSource) {
        this.action = action;
        this.publishedObject = publishedObject;
        this.publishingSource = publishingSource;
        this.timeStamp = System.currentTimeMillis();
    }
    /**
     * Get the string representation of an action
     * @param actionID
     * @return
     */
    public String getActionString() {
     switch (action) {
         case ACTION_ADD: return "ADD";
         case ACTION_REMOVE: return "REMOVE";
         case ACTION_CHANGE: return "CHANGE";
         case ACTION_OPEN_TRANSACTION: return "OPEN TRANSACTION";
         case ACTION_CLOSE_TRANSACTION: return "CLOSE TRANSACTION";
         case ACTION_INTERAGENT_TRANSFER: return "INTERAGENT TRANSFER";
     }
     return "";
    }
}