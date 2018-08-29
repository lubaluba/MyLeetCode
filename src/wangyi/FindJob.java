package wangyi;

import java.util.*;

public class FindJob{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0;i < n;i ++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr,((o1, o2) -> o1[0] - o2[0]));
        for (int i = 1;i < n;i ++){
            arr[i][1] = Math.max(arr[i][1],arr[i - 1][1]);
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0;i < n;i ++){
            map.put(arr[i][0],arr[i][1]);
        }
        for (int i = 0;i < m;i ++){
            int ability = sc.nextInt();
            Integer index = map.floorKey(ability);
            if (index != null){
                System.out.println(map.get(index));
            }else {
                System.out.println(0);
            }
        }
        sc.close();
    }
}