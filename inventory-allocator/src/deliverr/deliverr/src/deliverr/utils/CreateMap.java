package deliverr.utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateMap implements CreateMapI{
    String inputString;
    String order,inventory;
    Map<String,Integer> orderMap = new LinkedHashMap();
    Map<String,Map<String,Integer>> inventoryMap = new LinkedHashMap<>();
    public CreateMap(String inputStringin){
        inputString=inputStringin;
        if(inputStringin.isEmpty()) {
            System.out.println("Invalid: Empty input String..");
            System.exit(0);
        }
        String[] inputArr=inputStringin.split("\\[");
        order=inputArr[0];
        inventory=inputArr[1];
    }
    @Override
    public void initialize(){
        orderMap=convertToMap(order);
        inventoryMap(inventory);
    }
    @Override
    public Map<String,Integer> getOrderMap(){
        return orderMap;
    }
    @Override
    public  Map<String,Map<String,Integer>> getInventoryMap(){return inventoryMap;}
    @Override
    public String getOrder(){ return  order;}
    @Override
    public String getInventory(){ return inventory;}

    private Map<String,Integer> convertToMap(String input){
        Map<String,Integer> orderMap= new LinkedHashMap();
        if(input.contains("{"))
            input=input.replace("{","");
        if(input.contains("}"))
            input=input.replace("}","");
        if(input.contains(" "))
            input=input.replace(" ","");
        String[] keyValue=input.split(",");

        for (String str : keyValue) {
            int index = str.indexOf(":");
            orderMap.put(str.substring(0, index), Integer.parseInt(str.substring(index + 1)));
        }
        return orderMap;
    }


    private void inventoryMap(String inventoryInput){
        Map<String,Map<String,Integer>> inventoryMap=new LinkedHashMap<>();
        inventoryInput=inventoryInput.replace("]","");
        String[] inventories=inventoryInput.split("\\},");
        for (String s : inventories) {
            int nameIndex = s.indexOf(":");
            int commaIndex = s.indexOf(",");
            int invIndex = s.indexOf("y:");
            String name = s.substring(nameIndex + 2, commaIndex);
            String inv = s.substring(invIndex + 3);
            Map<String, Integer> invMap = convertToMap(inv);
            inventoryMap.put(name, invMap);
        }
        this.inventoryMap=inventoryMap;
    }
}
