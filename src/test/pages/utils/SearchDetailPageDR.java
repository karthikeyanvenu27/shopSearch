package utils;

import java.util.List;

public class SearchDetailPageDR {
    private static String productName;
    private static String productPrice;
    private static String productDesc;

    public static String getProductPrice() {
        return productPrice;
    }

    public static void setProductPrice(String productPrice) {
        SearchDetailPageDR.productPrice = productPrice;
    }

    public static String getProductDesc() {
        return productDesc;
    }

    public static void setProductDesc(String productDesc) {
        SearchDetailPageDR.productDesc = productDesc;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        SearchDetailPageDR.productName = productName;
    }

}
