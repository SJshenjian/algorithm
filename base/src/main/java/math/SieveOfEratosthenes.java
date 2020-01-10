package math;

/**
 * 素数筛选:埃拉托斯特尼筛法
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/10/13
 */
public class SieveOfEratosthenes {

    public boolean[] sieve(int max) {
        boolean[] flags = new boolean[max + 1];
        Arrays.fill(flags, true);
        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    private int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    private void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SieveOfEratosthenes().sieve(50));
    }
}
