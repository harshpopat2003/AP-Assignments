public class giveawaydeals extends product {
    String giveawayid;
    String giveawayprdid1;
    String giveawayprdid2;
    Float giveawayprice;
    Integer giveawayquantity;

    public giveawaydeals(String giveawayid, String giveawayprdid1, String giveawayprdid2, Float giveawayprice, Integer giveawayquantity) {
        super();
        this.giveawayid = giveawayid;
        this.giveawayprdid1 = giveawayprdid1;
        this.giveawayprdid2 = giveawayprdid2;
        this.giveawayprice = giveawayprice;
        this.giveawayquantity = giveawayquantity;
    }
}
