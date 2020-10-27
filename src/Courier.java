
import classes.Authentication;
import classes.UserRequests;

import java.util.*;

public class Courier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Authentication auth = new Authentication();
        UserRequests req = new UserRequests();
        System.out.println("1 -> Register\n2 -> Login\n3 -> Admin Login\n4 -> Request for password reset");
        int authChoice = in.nextInt();
        if (authChoice == 1)
            auth.register();
        else if (authChoice == 2)
            auth.login();
        else if (authChoice == 3)
            auth.adminLogin();
        else if (authChoice == 4)
            req.createRequest();
        in.close();
    }
}
