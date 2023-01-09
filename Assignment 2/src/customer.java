import java.util.*;

public class customer {
    private String Customername;
    private String Customerpassword;
    private String CustomerType;
    private double CustomerAccountBalance;

    public HashMap<String, Integer> getCart() {
        return cart;
    }

    public HashMap<Integer, Integer> getCoupons() {
        return coupons;
    }
    private HashMap<String,Integer> cart=new HashMap<String,Integer>();
    private HashMap<Integer,Integer> coupons=new HashMap<Integer,Integer>();

    public customer(String Customername, String Customerpassword, String CustomerType, double CustomerAccountBalance) {
        this.Customername = Customername;
        this.Customerpassword = Customerpassword;
        this.CustomerType = CustomerType;
        this.CustomerAccountBalance = CustomerAccountBalance;
    }

    public ArrayList<customer> getCustomerlist() {
        return customerlist;
    }

    static ArrayList<customer>customerlist= new ArrayList<>();

    public customer() {}

    //public customer implements void customertype;
    public void customermain() {
        int choice;
        do {
            System.out.println("Welcome Customer");
            System.out.println("1.Sign Up");
            System.out.println("2.Log In");
            System.out.println("3.Back");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    signup();
                    break;
                case 2:
                    login();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while (choice != 3);
    }
    public void signup(){
        System.out.println("Enter Name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter Password:");
        String pass = sc.nextLine();
        String type = "NORMAL";
        double balance = 1000.0;
        customer c = new customer(name,pass,type,balance);
        customerlist.add(c);
        System.out.println("Customer Successfully registered");
    }
    public void login() {
        System.out.println("Enter Name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter Password:");
        String pass = sc.nextLine();
        int choice;
        choice = 0;
        for (int i = 0; i < customerlist.size(); i++) {
            if (customerlist.get(i).Customername.equals(name) && customerlist.get(i).Customerpassword.equals(pass)) {
                do {
                    System.out.println("Welcome " + name);
                    System.out.println("1. Browse Products");
                    System.out.println("2. Browse Deals");
                    System.out.println("3. Add a product to cart");
                    System.out.println("4. Add product in deal to cart");
                    System.out.println("5. View Coupons");
                    System.out.println("6. Check account Balance");
                    System.out.println("7. View Cart");
                    System.out.println("8. Empty Cart");
                    System.out.println("9. Checkout Cart");
                    System.out.println("10. Upgrade Customer Status");
                    System.out.println("11. Add amount to wallet");
                    System.out.println("12. Back");
                    System.out.println("Enter your choice");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            browseproducts();
                            break;
                        case 2:
                            browsedeals();
                            break;
                        case 3:
                            addtocart();
                            break;
                        case 4:
                            addtodealcart();
                            break;
                        case 5:
                            viewcoupons();
                            break;
                        case 6:
                            checkbalance(i);
                            break;
                        case 7:
                            viewcart();
                            break;
                        case 8:
                            emptycart();
                            break;
                        case 9:
                            checkoutcart(i);
                            break;
                        case 10:
                            upgradestatus(i);
                            break;
                        case 11:
                            addamount(i);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            cart.clear();
                    }

                }
                while (choice != 12);
            }
        }

    }
        public void browseproducts () {
            System.out.println("Browsing Products");
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
        public void browsedeals () {
            System.out.println("Browsing Deals");
            for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                System.out.println("Deal ID: " + admin.giveawaydealslist.get(i).giveawayid);
                System.out.println("Deal Product 1: " + admin.giveawaydealslist.get(i).giveawayprdid1);
                //get the name of the product
                for (int j = 0; j < admin.productlist.size(); j++) {
                    if (admin.productlist.get(j).productid.equals(admin.giveawaydealslist.get(i).giveawayprdid1)) {
                        System.out.println("Deal Product 1 Name: " + admin.productlist.get(j).productname);
                        System.out.println("Deal Product 1 Info: " + admin.productlist.get(j).productinfo);
                    }
                }
                System.out.println("Deal Product 2: " + admin.giveawaydealslist.get(i).giveawayprdid2);
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
        public void addtocart () {
            System.out.println("Add to Cart");
            System.out.println("Enter product ID:");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            for (int i = 0; i < admin.productlist.size(); i++) {
                if (admin.productlist.get(i).productid.equals(id)) {
//                System.out.println("Product Name: " + admin.productlist.get(i).productname);
//                System.out.println("Product ID: " + admin.productlist.get(i).productid);
//                System.out.println("Product Info: " + admin.productlist.get(i).productinfo);
//                System.out.println("Product Price: " + admin.productlist.get(i).productprice);
//                System.out.println("========================================================");
                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();
                    if (quantity > admin.productlist.get(i).productquantity) {
                        System.out.println("Not enough quantity in stock");
                    } else {
                        admin.productlist.get(i).productquantity = admin.productlist.get(i).productquantity - quantity;
                        //add to cart
                        cart.put(admin.productlist.get(i).productid, quantity);
                        System.out.println("Product added to cart");
                    }
                }
            }
        }
        public void addtodealcart () {
            System.out.println("Add to Deal Cart");
            System.out.println("Enter Deal ID:");
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                if (admin.giveawaydealslist.get(i).giveawayid.equals(id)) {
                    System.out.println("Deal ID: " + admin.giveawaydealslist.get(i).giveawayid);
                    System.out.println("Deal Product 1: " + admin.giveawaydealslist.get(i).giveawayprdid1);
                    System.out.println("Deal Product 2: " + admin.giveawaydealslist.get(i).giveawayprdid2);
                    System.out.println("Deal Price: " + admin.giveawaydealslist.get(i).giveawayprice);
                    System.out.println("========================================================");
                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();
                    //add to cart
                    cart.put(admin.giveawaydealslist.get(i).giveawayid, quantity);
                    System.out.println("Deal added to cart");
                }
            }
        }
        public void viewcoupons () {
            System.out.println("View Coupons");
            if (coupons.isEmpty()) {
                System.out.println("No coupons available");
            } else {
                for (Map.Entry<Integer,Integer> entry : coupons.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.println("Coupon Number: " + key);
                    System.out.println("Coupon Discount: " + value);
                    System.out.println("========================================================");
                }
            }
        }
        public void checkbalance ( int i){
            System.out.println("Current Account Balance is ");
            System.out.println(customerlist.get(i).CustomerAccountBalance + " Rs");
        }
        public void viewcart () {
            System.out.println("View Cart");
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Product ID: " + key);
                for (int i = 0; i < admin.productlist.size(); i++) {
                    if (admin.productlist.get(i).productid.equals(key)) {
                        System.out.println("Product Name: " + admin.productlist.get(i).productname);
                        System.out.println("Product Price: " + admin.productlist.get(i).productprice);
                        System.out.println("Product Quantity: " + value);
                        System.out.println("Total Price: " + admin.productlist.get(i).productprice * value);
                        System.out.println("========================================================");
                    }
                }
            }
        }
        public void emptycart () {
            System.out.println("Empty Cart");
            cart.clear();
        }
        public void checkoutcart (int f) {
            System.out.println("Checkout Cart");
            double total = 0;
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                for (int i = 0; i < admin.productlist.size(); i++) {
                    if (admin.productlist.get(i).productid.equals(key)) {
//                        if (customerlist.get(f).CustomerType.equals("ELITE")) {
//                            for (int z = 0; z < admin.discountslist.size(); z++) {
//                                if (admin.discountslist.get(z).discountproductid.equals(key)) {
//                                    total = total + ((admin.productlist.get(i).productprice * (admin.discountslist.get(z).discountelite / 100)) * value);
//                                }
//                            }
//                        } else if (customerlist.get(f).CustomerType.equals("PRIME")) {
//                            for (int z = 0; z < admin.discountslist.size(); z++) {
//                                if (admin.discountslist.get(z).discountproductid.equals(key)) {
//                                    total = total + ((admin.productlist.get(i).productprice * (admin.discountslist.get(z).discountprime / 100)) * value);
//                                }
//                            }
//                        } else if (customerlist.get(f).CustomerType.equals("NORMAL")) {
//                            for (int z = 0; z < admin.discountslist.size(); z++) {
//                                if (admin.discountslist.get(z).discountproductid.equals(key)) {
//                                    total = total + ((admin.productlist.get(i).productprice * (admin.discountslist.get(z).discountnormal / 100)) * value);
//                                }
//                            }
//                        } else {
                            total = total + (admin.productlist.get(i).productprice * value);
                       // }
                    }
                }
            }

            System.out.println("Your Items in Cart are:");
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Product ID: " + key);
                for (int i = 0; i < admin.productlist.size(); i++) {
                    if (admin.productlist.get(i).productid.equals(key)) {
                        System.out.println("Product Name: " + admin.productlist.get(i).productname);
                        System.out.println("Product Price: " + admin.productlist.get(i).productprice);
                        System.out.println("Product Quantity: " + value);
                        System.out.println("========================================================");
                    }
                }
            }
            //print the deals
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                    if (admin.giveawaydealslist.get(i).giveawayid.equals(key)) {
                        System.out.println("Deal ID: " + admin.giveawaydealslist.get(i).giveawayid);
                        System.out.println("Deal Product 1: " + admin.giveawaydealslist.get(i).giveawayprdid1);
                        System.out.println("Deal Product 2: " + admin.giveawaydealslist.get(i).giveawayprdid2);
                        System.out.println("Deal Price: " + admin.giveawaydealslist.get(i).giveawayprice);
                        System.out.println("========================================================");
                    }
                }
            }
            System.out.println("Total Price before discount: " + total);
            Random rd = null;
            if (customerlist.get(f).CustomerType.equals("ELITE")) {
                System.out.println("You are an Elite Customer");
                System.out.println("You get min 10% discount or a Higher coupon");
                //to do checking for coupons and discount which is greater and then apply that
                double dis = 10;
                //get hihgest coupen value from coupon
                //double dis = 0;
                for (Map.Entry<Integer, Integer> entry : coupons.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value > dis) {
                        dis = value;
                    }
                }
                total = total - (total * (dis/100));
                System.out.println("Total Price after applying discount/coupon: " + total);
                System.out.println("Adding the deals to the total price if you have any added");
                for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                        if (admin.giveawaydealslist.get(i).giveawayid.equals(key)) {
                            total = total + (admin.giveawaydealslist.get(i).giveawayprice * value);
                        }
                    }
                }
                System.out.println("Total Price after adding the deals: " + total);
                double DileveryCharge = 100;
                System.out.println("Delivery Charge: " + DileveryCharge);
                total = total + DileveryCharge;
                System.out.println("Total Price after delivery charge: " + total);
                System.out.println("Your delivery will be done in 2 days");
                System.out.println("Make Payment ??");
                System.out.println("1. Yes");
                System.out.println("2. No");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice == 1) {
                    if (customerlist.get(f).CustomerAccountBalance >= total) {
                        //remove the quantity from stock
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.productlist.size(); j++) {
                                if (admin.productlist.get(j).productid.equals(key)) {
                                    // check quantity then only proceed
                                    if (admin.productlist.get(j).productquantity > value) {
                                        admin.productlist.get(j).productquantity = admin.productlist.get(j).productquantity - value;
                                    }
                                    else {
                                        System.out.println("Sorry we don't have enough quantity of the product you have selected");
                                        System.out.println("Please try again later or checking available quantity");
                                    }
                                }
                            }
                        }
                        //remove the quantity from stock of giveawaydeals
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.giveawaydealslist.size(); j++) {
                                if (admin.giveawaydealslist.get(j).giveawayid.equals(key)) {
                                    // check quantity then only proceed
                                    if (admin.giveawaydealslist.get(j).giveawayquantity > value) {
                                        admin.giveawaydealslist.get(j).giveawayquantity = admin.giveawaydealslist.get(j).giveawayquantity - value;
                                    }
                                    else {
                                        System.out.println("Sorry we don't have enough quantity of the product you have selected");
                                        System.out.println("Please try again later or checking available quantity");
                                    }
                                }
                            }
                        }
                        customerlist.get(f).CustomerAccountBalance = customerlist.get(f).CustomerAccountBalance - total;
                        System.out.println("Payment Successful");
                        System.out.println("Your Order will be delivered in 2 days");
                        System.out.println("Thank you for shopping with us");
                        cart.clear();
                        rd = new Random();
                        boolean h = rd.nextBoolean();
                        if (h) {
                            System.out.println("You have won a free gift");
                            int rand = rd.nextInt(admin.productlist.size());
                            if (admin.productlist.get(rand).productquantity > 0) {
                                System.out.println("Product ID: " + admin.productlist.get(rand).productid);
                                System.out.println("Product Name: " + admin.productlist.get(rand).productname);
                                System.out.println("Product Quantity: " + 1);
                                admin.productlist.get(rand).productquantity = admin.productlist.get(rand).productquantity - 1;
                            }
                        }
                        if (total > 5000) {
                            int randomnum = rd.nextInt(2) + 3;
                            for (int k = 1; randomnum > k + 1; k++) {
                                int random_int = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                                //Integer random1 = rd.nextInt(5, 15)+1;
                                System.out.println("Congratulations !!! You have got coupon of " + random_int + " % off");
                                coupons.put(k, random_int);
                            }
                            System.out.println("You can use this coupon in next purchase");
                        }
                    } else {
                        System.out.println("Not enough balance in account");
                    }
                } else {
                    System.out.println("Payment Cancelled");
                }

            } else if (customerlist.get(f).CustomerType.equals("PRIME")) {
                System.out.println("You are a Prime Customer");
                System.out.println("You will get 5% discount");
                //to do checking for coupons and discount which is greater and then apply that
                double DileveryCharge = 100 + (0.02 * total);
                double dis=5;
                //double diss =0;
                //get hihgest coupen value from coupon
                for (Map.Entry<Integer, Integer> entry : coupons.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value > dis) {
                        dis = value;
                    }
                }

                total = total - (total * (dis/100));
                System.out.println("Total Price after discount: " + total);
                System.out.println("Adding the deals to the total price if you have any added in cart");
                for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                        if (admin.giveawaydealslist.get(i).giveawayid.equals(key)) {
                            total = total + (admin.giveawaydealslist.get(i).giveawayprice * value);
                        }
                    }
                }
                System.out.println("Total Price after adding the deals: " + total);
                 //to print the calculations also
                System.out.println("Delivery Charge: " + DileveryCharge);
                total = total + DileveryCharge;
                System.out.println("Total Price after delivery charge: " + total);
                int randomday = (int)Math.floor(Math.random()*(6-3+1)+3);
                //int randomday = rd.nextInt(4) + 3;
                System.out.println("Your delivery will be done in " + randomday + " days");
                System.out.println("Make Payment ??");
                System.out.println("1. Yes");
                System.out.println("2. No");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice == 1) {
                    if (customerlist.get(f).CustomerAccountBalance >= total) {
                        //remove the quantity from stock
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.productlist.size(); j++) {
                                if (admin.productlist.get(j).productid.equals(key)) {
                                    // check quantity then only proceed
                                    if (admin.productlist.get(j).productquantity > value) {
                                        admin.productlist.get(j).productquantity = admin.productlist.get(j).productquantity - value;
                                    }
                                    else {
                                        System.out.println("Sorry we don't have enough quantity of the product you have selected");
                                        System.out.println("Please try again later or checking available quantity");
                                    }
                                }
                            }
                        }
                        //remove the quantity from stock of giveawaydeals
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.giveawaydealslist.size(); j++) {
                                if (admin.giveawaydealslist.get(j).giveawayid.equals(key)) {
                                    // check quantity then only proceed
                                    if (admin.giveawaydealslist.get(j).giveawayquantity > value) {
                                        admin.giveawaydealslist.get(j).giveawayquantity = admin.giveawaydealslist.get(j).giveawayquantity - value;
                                    }
                                    else {
                                        System.out.println("Sorry we don't have enough quantity of the product you have selected");
                                        System.out.println("Please try again later or checking available quantity");
                                    }
                                }
                            }
                        }
                        customerlist.get(f).CustomerAccountBalance = customerlist.get(f).CustomerAccountBalance - total;
                        System.out.println("Payment Successful");
                        System.out.println("Your Order will be delivered in " + randomday + " days");
                        System.out.println("Thank you for shopping with us");
                        cart.clear();
                        if (total> 5000) {
                            int randnum = (int)Math.floor(Math.random()*(2-1+1)+1);
                            //int randomnum = rd.nextInt(2) + 3;
                            for (int k = 0; randnum > k; k++) {
                                int random1 = (int)Math.floor(Math.random()*(15-5+1)+5);
                                //Integer random1 = rd.nextInt(5, 15)+1;
                                System.out.println("Congratulations !!! You have got coupon of " + random1 + " % off");
                                coupons.put(k, random1);
                            }
                            System.out.println("You can use this coupon in next purchase");
                        }
                    } else {
                        System.out.println("Not enough balance in account");
                    }
                } else {
                    System.out.println("Payment Cancelled");
                }
            } else {
                System.out.println("You are a Normal Customer");
                double DileveryCharge = 100 + (0.05 * total); //to print the calculations also
                System.out.println("Adding the deals to the total price if you have any added in cart");
                for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    for (int i = 0; i < admin.giveawaydealslist.size(); i++) {
                        if (admin.giveawaydealslist.get(i).giveawayid.equals(key)) {
                            total = total + (admin.giveawaydealslist.get(i).giveawayprice * value);
                        }
                    }
                }
                System.out.println("Total Price after adding the deals: " + total);
                //to do checking for coupons and discount which is greater and then apply that
                //System.out.println("Total Price: " + total);
                System.out.println("Delivery Charge: " + DileveryCharge);
                total = total + DileveryCharge;
                System.out.println("Total Price after delivery charge: " + total);
                int randoday = (int)Math.floor(Math.random()*(10-7+1)+7);
                //int randomday = rd.nextInt(4) + 7;
                System.out.println("Your delivery will be done in " + randoday + " days");
                System.out.println("Make Payment ??");
                System.out.println("1. Yes");
                System.out.println("2. No");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                if (choice == 1) {
                    if (customerlist.get(f).CustomerAccountBalance >= total) {
                        //remove the quantity from stock
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.productlist.size(); j++) {
                                if (admin.productlist.get(j).productid.equals(key)) { // check quantity then only proceed
                                    admin.productlist.get(j).productquantity = admin.productlist.get(j).productquantity - value;
                                }
                            }
                        }
                        //remove the quantity from stock of giveawaydeals
                        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            for (int j = 0; j < admin.giveawaydealslist.size(); j++) {
                                if (admin.giveawaydealslist.get(j).giveawayid.equals(key)) { // check quantity then only proceed
                                    admin.giveawaydealslist.get(j).giveawayquantity = admin.giveawaydealslist.get(j).giveawayquantity - value;
                                }
                            }
                        }
                        customerlist.get(f).CustomerAccountBalance = customerlist.get(f).CustomerAccountBalance - total;
                        System.out.println("Payment Successful");
                        System.out.println("Your Order will be delivered in " + randoday + " days");
                        System.out.println("Thank you for shopping with us");
                        cart.clear();
                    } else {
                        System.out.println("Not enough balance in account");
                    }
                } else {
                    System.out.println("Payment Cancelled");
                }
            }
        }
        public void upgradestatus ( int i){
            System.out.println("Current Status is " + customerlist.get(i).CustomerType);
            if (customerlist.get(i).CustomerType.equals("PRIME")){
                System.out.println("Enter to what status you want to upgrade");
                System.out.println("Options are: ELITE");
                System.out.println("ELITE membership costs is 100 for Prime members");
                Scanner sc = new Scanner(System.in);
                String status = sc.nextLine();
                if (status.equals("ELITE")) {
                    if (customerlist.get(i).CustomerAccountBalance >= 100) {
                        customerlist.get(i).CustomerAccountBalance = customerlist.get(i).CustomerAccountBalance - 100;
                        customerlist.get(i).CustomerType = "ELITE";
                        System.out.println("Status upgraded to ELITE");
                    } else {
                        System.out.println("Not enough balance in account");
                    }
                } else {
                    System.out.println("Invalid Status");
                }
            }
            System.out.println("Enter to what status you want to upgrade");
            System.out.println("Options are: ELITE, PRIME");
            System.out.println("ELITE membership costs is 300");
            System.out.println("PRIME membership costs is 200");
            Scanner sc = new Scanner(System.in);
            String status = sc.nextLine();
            if (status.equals("ELITE")) {
                if (customerlist.get(i).CustomerAccountBalance >= 300) {
                    customerlist.get(i).CustomerAccountBalance = customerlist.get(i).CustomerAccountBalance - 300;
                    customerlist.get(i).CustomerType = "ELITE";
                    System.out.println("Status Upgraded to ELITE");
                } else {
                    System.out.println("Not enough balance in account");
                }
            } else if (status.equals("PRIME")) {
                if (customerlist.get(i).CustomerAccountBalance >= 200) {
                    customerlist.get(i).CustomerAccountBalance = customerlist.get(i).CustomerAccountBalance - 200;
                    customerlist.get(i).CustomerType = "PRIME";
                    System.out.println("Status Upgraded to PRIME");
                } else {
                    System.out.println("Not enough balance in account");
                }
            } else {
                System.out.println("Invalid Status");
            }
        }
        public void addamount ( int i){
            System.out.println("Enter Amount you want to add");
            Scanner sc = new Scanner(System.in);
            int amount = sc.nextInt();
            customerlist.get(i).CustomerAccountBalance += amount;
            System.out.println("Add Amount");
        }
    }
