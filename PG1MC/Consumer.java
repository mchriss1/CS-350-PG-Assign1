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
   
   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }

   public void run()
   {
   Date message;
   int value;

     while (true)
      {
         int sleeptime = ThreadLocalRandom.current().nextInt(3, 8 + 1); //(int) (3 + (8 * Math.random())) + 1;
         	//sleeptime is the number of seconds the consumer thread is going to sleep

         System.out.println("Consumer sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");
        value = (int) (6000 + (50000 * Math.random()));
        // Object item = buffer.remove();
         message = (Date)buffer.remove();
            
         System.out.println("Consumer consumed " + value + " " + message);
      }
   }

   private  BoundedBuffer buffer;

}


