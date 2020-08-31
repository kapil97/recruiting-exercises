package deliverr.driver;
import deliverr.utils.CreateMap;
import deliverr.utils.CreateMapI;

public class Driver {
    public static void main(String[] args){
        final int REQUIRED_NUMBER_OF_ARGS = 2;
        if ((args.length != REQUIRED_NUMBER_OF_ARGS) ||
                (args[0].equals("${orderedMap}")) ||
                (args[1].equals("${inventoryList}"))
                ) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
            System.exit(0);
        }
        String input= args[0];
        CreateMapI createMap=new CreateMap(input);
        createMap.initialize();
        System.out.println("main+"+createMap.getOrderMap());
        System.out.println("main+"+createMap.getInventoryMap());
    }
}
