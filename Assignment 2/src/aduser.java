import java.util.Scanner;

public class aduser extends admin {
    //String[] username = new String[]{"Beff Jezos", "Gill Bates"};
    //String[] password = new String[]{"1234", "5678"};

    public static boolean checkpassanduser() {
        System.out.println("Dear Admin");
        System.out.println("Please Enter your Username and Password");
        System.out.println("Username: ");
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        System.out.println("Password: ");
        String pass = sc.nextLine();
        for (int i = 0; i < username.length; i++) {
            if (username[i].equals(user) && password[i].equals(pass)) {
                return true;
            }
        }
        return false;
    }
}