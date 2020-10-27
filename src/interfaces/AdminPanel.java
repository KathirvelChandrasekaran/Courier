package interfaces;

public interface AdminPanel {
    void viewUsers();
    void deleteUser(int userID);
    void updateCredentials(int userID);
    void viewCouriers();
    void updateCourierDetails(int parcelID);
    void viewRequests();
}
