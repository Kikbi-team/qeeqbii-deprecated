package ch.epfl.sweng.qeeqbii;

/**
 * Created by guillaume on 01/11/17.
 * A repertory of all recently scan products.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RecentlyScannedProducts {

    private static Map<String, Product> mProductMap = new HashMap<>();
    private static LinkedList<String> mBarcodeList = new LinkedList<>();

    // Returns whether a product has been recently scanned or not.
    static Boolean contains(String barcode)
    {
        return mProductMap.containsKey(barcode);
    }

    static LinkedList<String> GetBarcodeList()
    {
        return mBarcodeList;
    }

    static Product GetProduct(String barcode)
    {
        if (contains(barcode))
        {
            return mProductMap.get(barcode);
        }
        else
        {
            return new Product();
        }
    }

    static void add(String barcode, Product product)
    {
        mProductMap.put(barcode,product);
        mBarcodeList.addLast(barcode);
    }
}