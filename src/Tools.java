import java.util.*;
import java.util.stream.Collectors;

public class Tools {

    public void ShowArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void ShowArray(char[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    /**
     * use steam methods to convert List to Array
     * @param list
     * @return
     */
    public int[] convertListToArray(List<Integer> list) {
        // 1. get steam of List
        // 2. use mapToInt to get InputSteam
        // 3. use toArray to get int[]
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * use steam methods to convert Array to List
     * @param nums
     * @return
     */
    public List<Integer> convertArrayToList(int[] nums) {
        // 1. use Arrays.steam() to get the Intstream of this array
        // 2. use boxed() to convert Intsteam into Stream<Integer>
        // 3. collect elements and convert it into List<Integer>
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

}
