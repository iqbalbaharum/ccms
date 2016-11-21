package com.primeitx.ccms.util.database;

/**
 * Created by iQBAL on 14/6/2016.
 */
public abstract class BaseTable {

    // DEFINE "WHERE"
    public static final String DB_ARGS_WHERE = " = ? ";
    public static final String DB_WHERE_AND = " AND ";

    // list of database related action
    public static enum DBAction {
        NONE("NONE"),
        CREATE("CREATE"),
        UPDATE("UPDATE"),
        DELETE("DELETE");

        private String action;

        private DBAction(String s) {
            this.action = s;
        }

        public String toString(){
            return this.action;
        }
    }
}
