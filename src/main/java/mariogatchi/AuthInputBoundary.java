package mariogatchi;

public interface AuthInputBoundary {
    void loginRequest(String username, String password);

    void signupRequest(String username, String password);

    void logoutRequest();

    void deleteRequest();
}
