package prgmmrs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DesertIslandTravel {
    public static void main(String[] args) {
        String[] maps = {"X5XX5X", "111111", "XXXXXX", "111111"};

        int[][] check = new int[maps.length][maps[0].length()];
        Map<Integer, Integer> map = new HashMap<>();
        int numOfIsles = 0;

        char[][] arr = new char[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i++) {
            arr[i] = maps[i].toCharArray();
        }

        for(int i = 0; i< arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++) {
                if(arr[i][j] == 'X') {
                    check[i][j] = -1;
                } else if (arr[i][j] != 'X' && check[i][j] == 0){
                    int no = ++numOfIsles;
                    myMethod(i,j,map,arr,check,numOfIsles);
                }
            }
        }

        int[] answer = {-1};
        if (map.size()!=0) {
            int [] temp = new int[map.size()];
            for(int i = 0; i<map.size(); i++) {
                temp[i] = map.get(i+1);
            }
            Arrays.sort(temp);
            answer = temp;
        }
        System.out.println(Arrays.toString(answer));
    }

    public static void myMethod(int i, int j, Map<Integer,Integer> map, char[][] arr, int[][] check, int no) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //상, 좌, 하, 우
        if (check[i][j] == 0) {
            check[i][j] = no;
            map.put(no, map.getOrDefault(no, 0) + Character.getNumericValue(arr[i][j]));
        }
        System.out.println("i : "+i+", j : "+j+", 섬 번호 : "+no+", 맵 값 : "+map.get(no));
        System.out.println(Arrays.deepToString(check));
        for(int k = 0; k<4; k++) {
            if (0 <= i + dir[k][0] && i + dir[k][0] < arr.length && 0 <= j + dir[k][1] && j + dir[k][1] < arr[0].length
                    && arr[i + dir[k][0]][j + dir[k][1]] != 'X' && check[i + dir[k][0]][j + dir[k][1]] == 0) {
                check[i + dir[k][0]][j + dir[k][1]] = no;
                map.put(no, map.get(no) + Character.getNumericValue(arr[i + dir[k][0]][j + dir[k][1]]));
                System.out.println("메서드에서 for문 들어옴, for문은 몇번째? :"+k+" i : "+(i+dir[k][0])+", j : "+(j+dir[k][1])+", 섬 번호 : "+no+", 맵 값 : "+map.get(no));
                System.out.println(Arrays.deepToString(check));
                myMethod(i + dir[k][0],j + dir[k][1],map,arr,check,no);
            }
        }
    }



}

//                    int no = ++numOfIsles;
//                    check[i][j] = no;
//                    map.put(no, map.getOrDefault(no,0)+Character.getNumericValue(arr[i][j]));
//                    for(int k = 0; k<4; k++) {
//                        if (0<=i+dir[k][0] && i+dir[k][0]<arr.length && 0<=j+dir[k][1] && j+dir[k][1]<arr.length &&
//                        arr[i+dir[k][0]][j+dir[k][1]]!='X' && check[i+dir[k][0]][j+dir[k][1]]==0) {
//                            check[i+dir[k][0]][j+dir[k][1]] = no;
//                            map.put(no, map.get(no)+Character.getNumericValue(arr[i+dir[k][0]][j+dir[k][1]]));
//                        }
//                    }