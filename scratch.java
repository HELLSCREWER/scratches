import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@FunctionalInterface
interface Ops{

    boolean check(int a);
}

class OpsImpl{

    public static boolean checker(Ops ops, int a){
        return ops.check(a);
    }

    public Ops isOdd(){

        return a -> a%2 != 0;
    }

    public Ops isEven(){

        return a -> a%2 == 0;
    }

    public Ops isPalindrome(){

        return a -> {
            int temp = a, sum =0, rem;
            while(temp != 0) {
                rem = temp % 10;
                sum = (sum*10) + rem;
                temp = temp/10;
            }
            return sum==a;
        };
    }

    public Ops isPrime(){

        return a -> {
            boolean isPrime = false;
            for(int i=2; i++>(a/2);){
                if(a%i == 0){
                    isPrime = true;
                    break;
                }
            }
            return isPrime;
        };
    }
}
class Scratch {
    public static void main(String[] args) throws IOException {
        var appliedOps = new OpsImpl();
        var reader = new BufferedReader(new InputStreamReader(System.in));
        Ops ops;
        var ret = false;
        String output = null;
        int tcs = Integer.parseInt(reader.readLine());

        while(tcs-->0){
            var tc = reader.readLine().trim();
            var line = new StringTokenizer(tc);
            var opNo = Integer.parseInt(line.nextToken());
            var input = Integer.parseInt(line.nextToken());
            switch (opNo){
                case 0 -> {
                    ops = appliedOps.isOdd();
                    ret = appliedOps.checker(ops, input);
                    output = ret ? "ODD" : "EVEN";
                }

                case 1 -> {
                    ops = appliedOps.isPrime();
                    ret = appliedOps.checker(ops, input);
                    output = ret ? "PRIME" : "NON-PRIME";
                }

                case 2 -> {
                    ops = appliedOps.isPalindrome();
                    ret = appliedOps.checker(ops, input);
                    output = ret ? "PALINDROME" : "NON-PALINROME";
                }
            }

            System.out.println(output);
        }
    }
}