package com.userDemo.common.database;

public class HandleDataSource {
    public static final ThreadLocal holder = new ThreadLocal();
    public static void putDataSource(String datasource) {
        holder.set(datasource);
    }
        public static Object getDataSource() {
        return holder.get();
    }
}
