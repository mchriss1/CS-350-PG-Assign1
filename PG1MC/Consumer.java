/**Martez Christian
 * Consumer.java
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Consumer extends Thread
{
   static int getValue(int n) 
   { 
       int value; 
 
       /* Single line that calculates sum */
       for (value = 0; n > 0; value += n % 10,  n /= 10); 
 
       return value; 
   } 


   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }

   public void run()
   {
   Date message;

     while (true)
      {
         int sleeptime = (int) (3 + (8 * Math.random()));
         	//sleeptime is the number of seconds the consumer thread is going to sleep

         System.out.println("Consumer sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");

         message = (Date)buffer.remove();

         System.out.println("Consumer consumed."+ (getValue(n)) + " " + message);
      }
   }

   private  BoundedBuffer buffer;

}


