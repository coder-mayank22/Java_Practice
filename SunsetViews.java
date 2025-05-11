import java.util.*;

public class SunsetViews{
    private static List<Integer> findViews(int[] buildings, String direction){
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0, len = buildings.length;
        if(direction.equalsIgnoreCase("EAST")){
            for(int i = len - 1; i>=0; i--){
                if(buildings[i] > maxHeight) {
                    result.add(i);
                    maxHeight = buildings[i];
                }
            }
            Collections.reverse(result);
        }

        else if(direction.equalsIgnoreCase("WEST")){
            for(int i = 0; i < len; i++){
                if(buildings[i] > maxHeight) {
                    result.add(i);
                    maxHeight = buildings[i];
                }
            }
        }

        else{
            System.out.println("Wrong Direction");
            return result;
        }

        return  result;
    }

    public static void main(String[] args) {
        SunsetViews ob = new SunsetViews();
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter size of the array : ");
        size = sc.nextInt();
        int[] buildings = new int[size];
        for(int i=0; i<size; i++){
            System.out.print("Enter element "+ (i+1) + " : ");
            buildings[i] = sc.nextInt();
        }
        String direction;
        System.out.print("Enter direction : ");
        direction = sc.next();
        sc.nextLine();

        List<Integer> res = findViews(buildings, direction);
        System.out.println(res);
    }
}


