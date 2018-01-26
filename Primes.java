/**
 * Two examples of methods for determining whether an int is prime. 
 * You will be asked questions about this code on the loops test.
 * 
 * @author Jon Cooper
 * @version November 18, 2013
 */
public class Primes 
{
    /**
     * Determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime1(int n)
    {
        if (n == 2)        return true;
        else if (n % 2==0 || n < 2) return false;
        
        for (int i=2; i<n; i++)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    /**
     * A more efficient way to determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime2(int n)
    {
        if (n == 2)        return true;
        else if (n % 2==0 || n < 2) return false;
        
        double limit = Math.sqrt(n);
        
        for (int i=3; i<=limit; i+=2)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
        
    
    public static void main(String[] args)
    {
        // test isPrime1
        /*System.out.println( isPrime1(2) );
        System.out.println( isPrime1(9) );
        System.out.println( isPrime1(17) );*/
        
        // test isPrime2
        /*System.out.println( isPrime2(2) );
        System.out.println( isPrime2(9) );
        System.out.println( isPrime2(17) );
        System.out.println();*/
        
        //Answers  to 5-9:
        
        //5
        System.out.println("5: ");
        primeList(50);
        System.out.println();
        System.out.println();
        
        //6
        System.out.println("6: ");
        theseThreePrimes();
        System.out.println();
        
        //7
        System.out.println("7: ");
        System.out.println(howMany());
        System.out.println();
        
        //8
        System.out.println("8: ");
        sumBelowMillion();
        System.out.println();
        
        //9
        System.out.println("9: ");
        firstThousand();
        System.out.println();
        
        
        // Study the isPrime1 and isPrime2 methods to answer the following:
        
        // 0. Study the method isPrime1. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.
        
        /**
         * The set of numbers that would be tested as divisors for 19 is 1 through 18
         * For 91 it would be 1 through 90
         * For 643 it would be 1 through 642
         */

        
        // 1. Study the method isPrime2. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.
        
        /**
         * The set of numbers that would be tested as divisors is (2, 3)
         * For 91 it would be (2, 3, 5, 7, 9)
         * For 643 it would be (2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25)
         */        
        
        // 2. The number 15,485,863 is the 1 millionth prime number. Suppose it is 
        //    tested in both isPrime1 and isPrime2 for primality. About how much
        //    faster will isPrime2 finish testing. Show how you determined your answer.
        
        /**
         * isPrime2 will finish testing approximately 7869 times faster than isPrime1
         * 
         * I determined my answer by dividing 15,486,861 (the amount of operations performed in isPrime1)
         * by 1968 (the approximate amount of operations performed in isPrime 2) determined by taking the square root of the
         * number of operations and divided it by 2
         */
        
        // 3. In isPrime2, why is the limit calculated before the loop rather than
        //    writing the loop as for (int i=3; i<=Math.sqrt(n); i=i+2)?
        
        /**
         * Putting the limit calculation in the loop would cause it to be
         * repeated for every time the loop is executed.
         */
        
        // 4. The number 1 is not prime, however both prime function say that it is.
        //    Negative numbers cannot be prime either. Fix each function so that all
        //    ints less than 2 return false.

        /**
         * See the functions.
         */
    }   
    
    // Write blocks of code that use isPrime2 to solve the following problems:
        
        // 5. Generate a list of the first 50 prime numbers.
        
     private static void primeList(int listLength)
    {
        int primeCount = 0;
        int testNum = 2;
        
        while(primeCount<listLength)
        {
            if(isPrime2(testNum))
            {
                System.out.print(testNum);
                System.out.print(" ");
                primeCount++;
            }            
            testNum++;
        }
        
    }
    
        // 6. What is the 100th prime? the 1000th? The 12847th?
        
    private static void theseThreePrimes()
    {
        System.out.print(primeFinder(100));
        System.out.print(" ");
        System.out.print(primeFinder(1000));
        System.out.print(" ");
        System.out.print(primeFinder(12847));
        System.out.println(" ");
    }
    
    private static int primeFinder(int primeNo)
    {
        int primeCount = 0;
        int testNum = 2;
        int currentPrime=0;
        
        while(primeCount<primeNo)
        {
            if(isPrime2(testNum))
            {
                primeCount++;
                currentPrime=testNum;
            }
            testNum++;
        }   
        
        return currentPrime;
    }  
    
        // 7. In the set of integers from 2-1000000, how many are prime?
        
    private static int howMany ()
    {
        int primeCount = 0;
        int testNum = 2;
        
        while(testNum<=1000000)
        {
            if(isPrime2(testNum))
            {
                primeCount++;
            }            
            testNum++;
        }    
        
        return primeCount;
    }
        
        // 8. What is the sum of the all prime numbers below 1000000?
    
    private static void sumBelowMillion()
    {
        System.out.println(primeSum(1000000));
    }
    
    private static long primeSum(int primeNum)
    {
        long sum = 0;
        
        for(int i= 0;i<primeNum;i++)
        {
            if(isPrime2(i))
            {
                sum += i;
            }
        }
        
        return sum;
    }
        
        // 9. What is the sum of the first 1000 prime numbers?

    private static void firstThousand()
    {
        System.out.println(primeSum(primeFinder(1000)+1));
    }
}
    

