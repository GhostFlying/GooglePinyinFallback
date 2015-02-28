package com.ghostflying.googlepinyinfallback;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.setStaticIntField;

/**
 * Created by ghostflying on 2/28/15.
 */
public class XposedMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.google.android.inputmethod.pinyin"))
            return;
        try{
            setStaticIntField(Build.VERSION.class, "SDK_INT", Build.VERSION_CODES.KITKAT);
        }
        catch (Throwable t){
            XposedBridge.log(t);
        }
    }
}
