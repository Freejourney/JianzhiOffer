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

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        List<String> sarr = new ArrayList<>();
//        while (sc.hasNext()) {
//            Collections.addAll(sarr, sc.nextLine().split(" "));
//            String[] out = new String[sarr.size()];
//            sarr.toArray(out);
//            Arrays.sort(out);
//            for (String s : out)
//                System.out.print(s+" ");
//            System.out.println();
//
//            sarr.clear();
//        }

//        Scanner sc = new Scanner(System.in);

//        while(sc.hasNextLine()) {
//            String line = sc.nextLine();
//            String[] sarr = line.split(",");
//            Arrays.sort(sarr);
//
//            for(int i = 0; i < sarr.length-1; i++)
//                System.out.print(sarr[i]+",");
//            System.out.println(sarr[sarr.length-1]);
//        }

        Scanner sc = new Scanner(System.in);

        double N = sc.nextDouble();
        int num = 0;
        // 口罩D
        if (N >= 1) {
            N--;
            num+=5;
        }
        // 口罩B
        if (N >= 2 ) {
            N-=2;
            num+=3;
        }
        // 口罩F
        if (N >= 2) {
            N-=2;
            num+=3;
        }
        // 口罩A
        if (N >= 2) {
            N-=2;
            num+=2;
        }
        // 口罩C 和 口罩E
        if (N < 5 && N >= 3) {
            N-=3;
            num+=1;
        } else if (N < 8 && N >= 5) {
            N-=5;
            num+=4;
        } else if (N >= 8) {
            N-=8;
            num+=5;
        }
        System.out.println(num);


//        test();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String[] snums = null;
        snums = sc.nextLine().split(",");


        int[] nums = new int[snums.length];
        for (int i = 0; i < snums.length; i++) {
            nums[i] = Integer.valueOf(snums[i]);
        }

        int s1 = nums[0] + nums[1] + nums[2] + nums[3];
        int s2 = nums[3] + nums[4] + nums[5] + nums[6];
        int s3 = nums[6] + nums[7] + nums[8] + nums[0];

        if (s1 == s2 && s1 == s3)
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
