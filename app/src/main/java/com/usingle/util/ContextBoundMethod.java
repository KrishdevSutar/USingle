/**
 * Class: ContextBoundMethod
 * Author: Robert Ciborowski
 * Date: 03/06/2018
 * Description: A class which is runnable. It also stores a reference to some Context object.
 */

package com.usingle.util;

import android.content.Context;

public abstract class ContextBoundMethod {
    // This the the context and data.
    private Context context = null;
    private Object data;

    // This should be implemented by the user.
    public abstract void run();

    // These are getters and setters.
    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
