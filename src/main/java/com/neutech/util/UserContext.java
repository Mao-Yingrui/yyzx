package com.neutech.util;

public class UserContext {
    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setCurrentIdCard(String idCard) {
        currentUser.set(idCard);
    }

    public static String getCurrentIdCard() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
