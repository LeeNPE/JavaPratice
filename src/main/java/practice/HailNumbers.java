package practice;

public class HailNumbers {
    public static void main(String[] args) {
        HailNumFunction hailFunc = new HailNumFunction();
        for(int i = 1 ; i  < 10000 ; i ++) {
            int numberOfruns = hailFunc.numberOfRuns(i);
            if(numberOfruns >= 100)
            System.out.println("number : " + i + " is run " +numberOfruns + " times");
        }
    }
}

class HailNumFunction{
    int next(int n) {
        return (n % 2 == 0) ? n/2 : 3*n + 1 ;
    }

    int numberOfRuns(int n) {
        int answer = 0;
        while (n != 1) {
            n = next(n);
            answer++;
        }
        return answer;
    }
}