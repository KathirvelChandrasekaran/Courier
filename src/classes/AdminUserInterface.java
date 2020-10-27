package classes;

import java.util.Scanner;

public class AdminUserInterface {
    void PickAdminChoices(int userID) {
        Scanner in = new Scanner(System.in);
        int con = 0;
        do {
            System.out.println("1 -> View Users\n2 -> Delete Users\n" +
                    "3 -> Update User Credentials\n4 -> View All Courier informations\n5 -> Update Courier Informations");
            int ch = in.nextInt();
            AdminRights ar = new AdminRights();
            if (ch == 1)
                ar.viewUsers();
            else if (ch == 2) {
                System.out.println("List of Users\nSelect the user ID");
                ar.viewUsers();
                int chUserID = in.nextInt();
                ar.deleteUser(chUserID);
            } else if (ch == 3) {
                System.out.println("List of Users\nSelect the user ID");
                ar.viewRequests();
                int chUserID = in.nextInt();
                ar.updateCredentials(chUserID);
            } else if (ch == 4)
                ar.viewCouriers();
            else if (ch == 5) {
                System.out.println("List of Couriers\nSelect the parcel ID");
                ar.viewCouriers();
                int parcelID = in.nextInt();
                ar.updateCourierDetails(parcelID);
            }

            System.out.println("Non zero value to continue!!!");
            con = in.nextInt();
        } while (con != 0);
        in.close();
    }
}
