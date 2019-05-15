package com.demo.dingsheng.task.frame;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hl on 21/12/17.
 */

public class WinFrameHelper {
    private static Constructor sConstructor;

    static {
        try {
            Class<?> clsFrameImpl = Class.forName("com.demo.dingsheng.task.frame.WinFrameImpl");
            sConstructor = clsFrameImpl.getConstructor();
        } catch (ClassNotFoundException ex) {
            Log.e("",ex.toString());
        } catch (NoSuchMethodException ex) {
            Log.e("",ex.toString());
        }
    }

    /**
     * .
     */
    public static IFrame getFrameImpl() {
        if (sConstructor != null) {
            try {
                return (IFrame) sConstructor.newInstance();
            } catch (IllegalAccessException ex) {
                Log.e("",ex.toString());
            } catch (InstantiationException ex) {
                Log.e("",ex.toString());
            } catch (InvocationTargetException ex) {
                Log.e("",ex.toString());
            }
        }
        return null;
    }
}
