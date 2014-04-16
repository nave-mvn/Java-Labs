/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication7;

/**
 *
 * @author user
 */

/**
 * This program intentionally uses an inefficient method to calculate all of
 * the prime numbers less than or equal to a supplied long (integer).
 *
 * @author crumpton
 */

public class PrimeFinder implements Runnable
{
    protected long limit;
    protected long currentlyChecking;

    /**
     * Constructor for PrimeFinder, makes sure that the limit is a positive
     * number
     *
     * @param limit PrimeFinder will find all prime numbers less than or equal to limit
     */
    public PrimeFinder(long limit)
    {
        if (limit > 0)
            this.limit = limit;
        else
        {
            System.err.println("PrimeFinder's limit must be a positive value!");
            System.exit(1);
        }
    }

    /**
     * @return the long that is currently being checked to see if it is prime
     */
    public long getCurrentlyChecking()
    {
        return currentlyChecking;
    }

    /**
     * This method uses <a href="http://en.wikipedia.org/wiki/Prime_number#Trial_division">
     * trial division</a> to determine if the supplied number is prime.
     *
     * @param number, a long
     * @return true if the supplied number is prime, otherwise false
     */
    public boolean isPrime(long number)
    {
        long sqrt = (long) Math.ceil(Math.sqrt(number));

        for (long i=2; i<=sqrt; i++)
        {
            if ((number%i) == 0)
                if (number != i)
                    return false;
        }

        return true;
    }

    /**
     * Prints out the prime numbers less than or equal to the
     * limit set in the PrimeFinder constructor.
     */
    public void run()
    {
        //for (currentlyChecking=2; currentlyChecking<=limit; currentlyChecking++)
        //{
           if (isPrime(limit))
                System.out.println(limit + " ");
        //}
        //System.out.println();
    }

    /**
     * Creates an instance of PrimeFinder and starts it.
     */
    public static void main(String[] args)
    {
        for (int i=2;i<=100;i++){
        PrimeFinder pf = new PrimeFinder(i);
        Thread t = new Thread(pf);
        t.start();//
        }
    }

}