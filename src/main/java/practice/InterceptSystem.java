package practice;

public class InterceptSystem {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] targets;
        targets = new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(s.solution(targets));
    }
}
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        int[] vaildBomb = targets[0];
        while(vaildBomb != null) {
            answer ++;
            System.out.println("");
            vaildBomb = searchVaildBomb(targets);
        }
        return answer;
    }


    void shootBombs(int[][] targets, int[] vaildBomb) {

        int[] shootRange = vaildBomb;
        for(int[] temp : targets) {
            boolean leftRange = temp[0] >= shootRange[0];
            boolean rightRange = temp[1] <= shootRange[1];

            if(leftRange || rightRange) {
                shootRange[0] = (leftRange) ? temp[0] : shootRange[0];
                shootRange[1] = (rightRange) ? temp[1] : shootRange[1];

                temp[0] = -1;
            }
        }
        vaildBomb[0] = -1;
    }

    int[] searchVaildBomb (int[][] targets) {
        for(int[] temp : targets) {
            if(temp[0] != -1) {
                return temp;
            }
        }
        return null;
    }
}