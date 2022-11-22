package mariogatchi;

public interface GameInputBoundary {

    void createRequest(String name);

    void loadRequest(String name);

    void saveRequest();

    void exitRequest();

    void deleteRequest(String name);
}
