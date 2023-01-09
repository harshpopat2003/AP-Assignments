import java.util.Scanner;

public class Main {
    private static final admin a = new admin();
    private static final customer c = new customer();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("WELCOME TO FLIPZONE");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Explore the product Catalog");
            System.out.println("3. Show Available Deals");
            System.out.println("4. Enter as Customer");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
//                admin a = new admin();
                    a.adminmain();
                    break;
                case 2:
                    productcatelog();
                    break;
                case 3:
                    getdeals();
                    break;
                case 4:
                    c.customermain();
                    break;
            }
        }
        while (choice != 5);
        {
            System.out.println("Thank you");
            System.exit(0);
        }
    }

    public static void productcatelog() {
        System.out.println("Browsing Products");
        if (admin.productlist.isEmpty()) {
            System.out.println("No products available right now");
        } else {
            for (int i = 0; i < admin.categorylist.size(); i++) {
                System.out.println("Category ID: " + admin.categorylist.get(i).categoryid);
                System.out.println("Category Name: " + admin.categorylist.get(i).categoryname);
                for (int j = 0; j < admin.productlist.size(); j++) {
                    if (admin.productlist.get(j).productcategoryid.equals(admin.categorylist.get(i).categoryid)) {
                        System.out.println("Product Name: " + admin.productlist.get(j).productname);
                        System.out.println("Product ID: " + admin.productlist.get(j).productid);
                        System.out.println("Product Info: " + admin.productlist.get(j).productinfo);
                        System.out.println("Product Price: " + admin.productlist.get(j).productprice);
                        System.out.println("Product Quantity: " + admin.productlist.get(j).productquantity);
                        System.out.println("========================================================");
                    }
                }
            }
        }
    }

    public static void getdeals() {
        System.out.println("Browsing Deals");
        if (admin.giveawaydealslist.isEmpty()) {
            System.out.println("Dear Customer, there are no deals available at the moment !! Please check regularly for new deals");
        } else {
            for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                System.out.println("Deal ID: " + admin.giveawaydealslist.get(i).giveawayid);
                System.out.println("Deal Product 1 ID: " + admin.giveawaydealslist.get(i).giveawayprdid1);
                //get the name of the product
                for (int j = 0; j < admin.productlist.size(); j++) {
                    if (admin.productlist.get(j).productid.equals(admin.giveawaydealslist.get(i).giveawayprdid1)) {
                        System.out.println("Deal Product 1 Name: " + admin.productlist.get(j).productname);
                        System.out.println("Deal Product 1 Info: " + admin.productlist.get(j).productinfo);
                    }
                }
                System.out.println("Deal Product 2 ID: " + admin.giveawaydealslist.get(i).giveawayprdid2);
                //get the name of the product
                for (int j = 0; j < admin.productlist.size(); j++) {
                    if (admin.productlist.get(j).productid.equals(admin.giveawaydealslist.get(i).giveawayprdid2)) {
                        System.out.println("Deal Product 2 Name: " + admin.productlist.get(j).productname);
                        System.out.println("Deal Product 2 Info: " + admin.productlist.get(j).productinfo);
                    }
                }
                System.out.println("Deal Price: " + admin.giveawaydealslist.get(i).giveawayprice);
                System.out.println("Deal Quantity: " + admin.giveawaydealslist.get(i).giveawayquantity);
                System.out.println("========================================================");
            }
        }
    }
}
