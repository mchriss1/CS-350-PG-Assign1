/**Name: Martez Christian
 * Course: CS 350-001
 * Programming Assignment 1
 * Date: 2/7/2021
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
import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread
{
   
   public Consumer(String n, BoundedBuffer b)
   {
      buffer = b;
      name = n;
   }
   
   private int sumOfDigits(int m) {
      int sum = 0;
      
      while(m != 0 ) {
         sum += m % 10;
         m /= 10;

      }
      return sum;
   }

   public void run()
   {
   int message;
   int variable;
   
     while (true)
      {
         int sleeptime = ThreadLocalRandom.current().nextInt(3, 8 + 1);
         	//sleeptime is the number of seconds the consumer thread is going to sleep

         System.out.println("Consumer " + name + " sleeping for " + sleeptime + " seconds");
         

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println("Consumer " + name + " wants to consume.");

   
         message = (int)buffer.remove();
         variable = sumOfDigits(message);
         System.out.println("Consumer " + name + " consumed " + message + ". Sum of its digits is : " + variable);
        // message = (int)buffer.remove();

       //  System.out.println("Consumer " + name + " consumed " + message);
      }
      
   }

   private  BoundedBuffer buffer;
   private String name;
}


