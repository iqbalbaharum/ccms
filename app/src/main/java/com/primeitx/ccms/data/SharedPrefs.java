package com.primeitx.ccms.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by iQBAL on 1/1/2016.
 */
public class SharedPrefs {

    private static final String PREFS_NAME = "com.primeitx.prefs";

    private SharedPreferences mPrefs;

    // Stored information
    public enum Type {
        // STRING
        USERNAME("username");

        private final String mPrefsName;

        Type(String text) {
            mPrefsName = text;
        }

        @Override
        public String toString() {
            return mPrefsName;
        }
    }

    /***
     * Constructor
     *
     * @param context
     */
    public SharedPrefs(Context context) {
        mPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /***
     * Set preferences setting (string)
     *
     * @param type
     * @param prefs
     */
    public void setPreferences(Type type, String prefs) {

        if (isStringType(type)) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(type.toString(), prefs);
            editor.apply();
        }
    }

    /***
     * Set preference (int)
     *
     * @param type
     * @param figure
     */
    public void setPreferences(Type type, long figure) {
        if (isBooleanType(type)) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putLong(type.toString(), figure);
            editor.apply();
        }
    }

    /***
     * Set preference (bool)
     *
     * @param type
     * @param bool
     */
    public void setPreferences(Type type, boolean bool) {
        if (isBooleanType(type)) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean(type.toString(), bool);
            editor.apply();
        }
    }

    /***
     * Get preference (string)
     *
     * @param type
     * @return
     */
    public String getString(Type type) {

        if (isStringType(type)) {
            return mPrefs.getString(type.toString(), "");
        }

        return null;
    }

    /***
     * Get preference (long)
     * @param type
     * @return
     */
    public long getLong(Type type) {

        if(isLongType(type)) {
            return mPrefs.getLong(type.toString(), 0);
        }

        return 0;
    }

    /***
     * Get preference (boolean)
     *
     * @param type
     * @return
     */
    public boolean getBoolean(Type type) {

        if (isBooleanType(type)) {
            return mPrefs.getBoolean(type.toString(), false);
        }

        return false;
    }

    public void clearPreference() {
        mPrefs.edit().clear().apply();
    }

    /***
     * Preference key with String type
     *
     * @param type
     * @return
     */
    private boolean isStringType(Type type) {

        boolean bRet = false;

        switch (type) {
            case USERNAME:
                bRet = true;
        }

        return bRet;
    }

    /***
     * Preference key with Long type
     * @param type
     * @return
     */
    private boolean isLongType(Type type) {

        boolean bRet = false;

        switch (type) {
            default:
                bRet = true;
        }

        return bRet;
    }

    /***
     * Preference key with bool type
     *
     * @param type
     * @return
     */
    private boolean isBooleanType(Type type) {

        boolean bRet = false;

        switch (type) {
            default:
                bRet = true;
        }

        return bRet;

    }
}
