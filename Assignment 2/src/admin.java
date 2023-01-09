import java.util.ArrayList;
import java.util.Scanner;

public class admin {
    public static ArrayList<giveawaydeals> getGiveawaydealslist() {
        return giveawaydealslist;
    }

    public static ArrayList<Category> getCategorylist() {
        return categorylist;
    }

    public static ArrayList<discounts> getDiscountslist() {
        return discountslist;
    }

    public static ArrayList<product> getProductlist() {
        return productlist;
    }

    static ArrayList<giveawaydeals> giveawaydealslist = new ArrayList<giveawaydeals>();
    static ArrayList<Category> categorylist = new ArrayList<>();
    static ArrayList<discounts> discountslist = new ArrayList<discounts>();
    static ArrayList<product> productlist = new ArrayList<>();
    static String[] username = new String[]{"Beff Jezos", "Gill Bates"};
    static String[] password = new String[]{"1234", "5678"};
    //aduser ad= new aduser();
    public void adminmain() {
//        System.out.println("Dear Admin");
//        System.out.println("Please Enter your Username and Password");
//        System.out.println("Username: ");
//        Scanner sc = new Scanner(System.in);
//        String user = sc.nextLine();
//        System.out.println("Password: ");
//        String pass = sc.nextLine();
////        for (String element : username) {
////            if (element.equals(user)) {
////                for (String elements : password) {
////                    if (elements.equals(pass)) {
////                        continue;
////                    } else {
////                        System.out.println("Please put the right details");
////                        return;
////                    }
////                }
////            }
////        }
        boolean check = aduser.checkpassanduser();
        int choice = 0;
        if (check){
//            for (int i = 0; i < username.length; i++) {
//                if (username[i].equals(user) && password[i].equals(pass)) {
                    do{
                    System.out.println("Welcome");
                    System.out.println("1. Add Category");
                    System.out.println("2. Delete Category");
                    System.out.println("3. Add Product");
                    System.out.println("4. Delete Product");
                    System.out.println("5. Set Discount on Product");
                    System.out.println("6. Add Giveaway deal");
                    System.out.println("7. Back");
                    System.out.println("Enter your choice");
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            addcategory();
                            break;
                        case 2:
                            deletecategory();
                            System.out.println("Delete Category");
                            break;
                        case 3:
                            addprod();
                            break;
                        case 4:
                            deleteprod();
                            System.out.println("Delete Product");
                            break;
                        case 5:
                            adddiscountdeal();
                            //printcategoryandproduct();
                            break;
                        //System.out.println("Set Discount on Product");
                        case 6:
                            addgiveawaydeal();
                            break;
                        default:
                            //System.out.println("Invalid choice");
                    }

                }
                    while (choice != 7);

            }
        }
    //}
    public void addcategory() {
        System.out.println("Add Category");
        System.out.println("Enter the category ID");
        Scanner sc = new Scanner(System.in);
        String catid = sc.nextLine();
        //check if category id already exists
        for (int i = 0; i < categorylist.size(); i++) {
            if (categorylist.get(i).getCategoryid().equals(catid)) {
                System.out.println("Dear Admin Category ID already exists!! Please enter a Unique Category ID");
                return;
            }
        }
        System.out.println("Enter the category name");
        String catname = sc.nextLine();
        Category c = new Category(catid, catname);
        System.out.println("Category added successfully");
        categorylist.add(c);
        System.out.println("Add a Product");
        System.out.println("Enter the product Name");
        //Scanner sc = new Scanner(System.in);
        String prodname = sc.nextLine();
        System.out.println("Enter the product ID");
        String prodid = sc.nextLine();
        //check if product id already exists
        for (int i = 0; i < productlist.size(); i++) {
            if (productlist.get(i).productid.equals(prodid)) {
                System.out.println("Product ID already exists");
                return;
            }
        }
        System.out.println("Enter Product Info");
        String prodinfo = sc.nextLine();
        System.out.println("Enter the product price");
        double prodprice = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the product quantity");
        Integer prodquantity = Integer.valueOf(sc.nextLine());
        product p = new product(prodname, prodid, prodprice, prodinfo, catid, catname, prodquantity);
        System.out.println("Product added successfully");
        productlist.add(p);
    }

    public void addprod() {
        System.out.println(("Enter the category ID"));
        Scanner sc = new Scanner(System.in);
        String catid = sc.nextLine();
        for (int i = 0; i < categorylist.size(); i++) {
            if (categorylist.get(i).categoryid.equals(catid)) {
                System.out.println("Enter the product Name");
                String prodname = sc.nextLine();
                System.out.println("Enter the product ID");
                String prodid = sc.nextLine();
                for (int j = 0; j < productlist.size(); j++) {
                    if (productlist.get(j).productid.equals(prodid)) {
                        System.out.println("Product ID already exists");
                        return;
                    }
                }
                System.out.println("Enter Product Info");
                String prodinfo = sc.nextLine();
                System.out.println("Enter the product price");
                double prodprice = Double.parseDouble(sc.nextLine());
                String productcategoryid = categorylist.get(i).categoryid;
                String productcategoryname = categorylist.get(i).categoryname;
                System.out.println("Enter the product quantity");
                Integer prodquantity = Integer.valueOf(sc.nextLine());
                product p = new product(prodname, prodid, prodprice, prodinfo, productcategoryid, productcategoryname, prodquantity);
                System.out.println("Product added successfully");
                productlist.add(p);
            }
        }
    }

    public void deletecategory() {
        System.out.println("Delete Category");
        System.out.println("Enter the category ID");
        Scanner sc = new Scanner(System.in);
        String catid = sc.nextLine();
        for (int i = 0; i < categorylist.size(); i++) {
            if (categorylist.get(i).categoryid.equals(catid)) {
                categorylist.remove(i);
                System.out.println("Category deleted successfully");
                //delete all products in that category
                for (int j = 0; j < productlist.size(); j++) {
                    if (productlist.get(j).productcategoryid.equals(catid)) {
                        productlist.remove(j);
                    }
                }
            }
        }
    }

    public void deleteprod() {
        System.out.println("Delete Product");
        System.out.println("Enter the product ID");
        Scanner sc = new Scanner(System.in);
        String prodid = sc.nextLine();
        for (int i = 0; i < productlist.size(); i++) {
            if (productlist.get(i).productid.equals(prodid)) {
                productlist.remove(i);
                System.out.println("Product deleted successfully");
            }
        }
    }

    public void addgiveawaydeal() {
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
        System.out.println("Enter Deal Id:");
        Scanner sc = new Scanner(System.in);
        String dealid = sc.nextLine();
        System.out.println("Enter the First product ID");
        String prodid1 = sc.nextLine();
        System.out.println("Enter the Second product ID");
        String prodid2 = sc.nextLine();
        System.out.println(" Enter the Combined price of the two products(Should be less than their combines price)");
        float combinedprice = Float.parseFloat(sc.nextLine());
        System.out.println("Enter quantity of deals");
        int quantity = Integer.parseInt(sc.nextLine());
        //check if the combined price is less than the sum of the two products
        for (int i = 0; i < productlist.size(); i++) {
            if (productlist.get(i).productid.equals(prodid1)) {
                for (int j = 0; j < productlist.size(); j++) {
                    if (productlist.get(j).productid.equals(prodid2)) {
                        if (combinedprice < (productlist.get(i).productprice + productlist.get(j).productprice)) {
                            productlist.get(i).productquantity = productlist.get(i).productquantity - quantity;
                            productlist.get(j).productquantity = productlist.get(j).productquantity - quantity;
                            //System.out.println("Combined price is less than the sum of the two products");
                            //System.out.println("Deal added successfully");
                            giveawaydeals g = new giveawaydeals(dealid, prodid1, prodid2, combinedprice, quantity);
                            giveawaydealslist.add(g);
                            System.out.println("Deal added successfully");
                            return;
                        }
                    }
                }
            }
        }
    }

    public void adddiscountdeal() {
        System.out.println("Dear Admin give Product ID you want to add discount for");
        System.out.println("Enter the product ID:");
        Scanner sc = new Scanner(System.in);
        String prodid = sc.nextLine();
        //get the product name from the product id
        String prodname = null;
        for (int i = 0; i < productlist.size(); i++) {
            prodname = null;
            if (productlist.get(i).productid.equals(prodid)) {
                prodname = productlist.get(i).productname;
            }
        }
        System.out.println("Enter the discount percentage");
        System.out.println("For Elite customers:");
        int discountelite = Integer.parseInt(sc.nextLine());
        System.out.println("For Prime customers:");
        int discountprime = Integer.parseInt(sc.nextLine());
        System.out.println("For Normal customers:");
        int discountnormal = Integer.parseInt(sc.nextLine());
        discounts d = new discounts(prodid, prodname, discountelite, discountprime, discountnormal);
        discountslist.add(d);
    }

    public void printcategoryandproduct(){
            for (int i = 0; i < categorylist.size(); i++) {
                System.out.println("Category ID: " + categorylist.get(i).categoryid);
                System.out.println("Category Name: " + categorylist.get(i).categoryname);
                for (int j = 0; j < productlist.size(); j++) {
                    if (productlist.get(j).productcategoryid.equals(categorylist.get(i).categoryid)) {
                        System.out.println("Product Name: " + productlist.get(j).productname);
                        System.out.println("Product ID: " + productlist.get(j).productid);
                        System.out.println("Product Info: " + productlist.get(j).productinfo);
                        System.out.println("Product Price: " + productlist.get(j).productprice);
                        System.out.println("========================================================");
                    }
                }
            }
        }
}
