package pro.marvinhosea.movielist.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lpro/marvinhosea/movielist/repository/UserSharedPrefRepository;", "Lpro/marvinhosea/movielist/repository/UserRepository;", "()V", "USERNAME", "", "USER_IS_LOGGED_IN", "USER_PASSWORD", "applicationContext", "Landroid/content/Context;", "getUserName", "init", "", "context", "isUserLoggedIn", "", "loginUser", "username", "password", "logoutUser", "registerUser", "sharedPreps", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "app_debug"})
public final class UserSharedPrefRepository implements pro.marvinhosea.movielist.repository.UserRepository {
    private static android.content.Context applicationContext;
    private static final java.lang.String USERNAME = "USERNAME";
    private static final java.lang.String USER_PASSWORD = "USER_PASSWORD";
    private static final java.lang.String USER_IS_LOGGED_IN = "USER_IS_LOGGED_IN";
    public static final pro.marvinhosea.movielist.repository.UserSharedPrefRepository INSTANCE = null;
    
    private final android.content.SharedPreferences sharedPreps() {
        return null;
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * Register user on shared preference
     */
    @java.lang.Override()
    public void registerUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    /**
     * Login in user by checking user validity
     */
    @java.lang.Override()
    public boolean loginUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return false;
    }
    
    /**
     * Logout user and remove user from shared preference
     */
    @java.lang.Override()
    public void logoutUser() {
    }
    
    /**
     * Check if user is logged in by checking if @param{USER_IS_LOGGED_IN} is true
     */
    @java.lang.Override()
    public boolean isUserLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    private UserSharedPrefRepository() {
        super();
    }
}