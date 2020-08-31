package deliverr.utils;

import java.util.Map;

public interface CreateMapI {
    void initialize();
    Map<String,Integer> getOrderMap();
    Map<String,Map<String,Integer>> getInventoryMap();
    String getOrder();
    String getInventory();
}
