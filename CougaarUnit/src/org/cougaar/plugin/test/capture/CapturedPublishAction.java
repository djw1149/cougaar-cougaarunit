package org.cougaar.plugin.test.capture;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CapturedPublishAction {
    public final static int ACTION_ADD = 1;
    public final static int ACTION_CHANGE =2 ;
    public final static int ACTION_REMOVE = 3;

    Object publishedObject;
    int action;
    Object publishingSource;

    public CapturedPublishAction(int action, Object publishedObject, Object publishingSource) {
        this.action = action;
        this.publishedObject = publishedObject;
        this.publishingSource = publishingSource;
    }
}