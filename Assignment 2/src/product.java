public class product {
    String productid;
    String productname;
    double productprice;
    String productinfo;
    String productcategoryid;
    String productcategoryname;
    Integer productquantity;
    public product() {}

    public product(String productname, String productid, double productprice, String productinfo, String productcategoryid, String productcategoryname, Integer productquantity) {
        this.productname = productname;
        this.productid = productid;
        this.productprice = productprice;
        this.productinfo = productinfo;
        this.productcategoryid = productcategoryid;
        this.productcategoryname = productcategoryname;
        this.productquantity = productquantity;
    }
}
