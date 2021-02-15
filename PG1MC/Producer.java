/**Name: Martez Christian
 * Course: CS 350-001
 * Programming Assignment 1
 * Date: 2/7/2021
 * Producer.java
 *
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread
{
   public Producer(String n, BoundedBuffer b) {
      buffer = b;
      name = n;
   }
 

   public void run()
   {
   int message;
   //int value;
   Random r = new Random();
   int low = 4;
   int high = 7;
  


      while (true)
      {
            int sleeptime = r.nextInt(high-low) + low;                       
         	//sleeptime is the number of seconds the producer thread is going to sleep. 
            //in this case the sleep range is from 4 to 7

         System.out.println("Producer " + name + " sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // produce an item & enter it into the buffer
      
         message = (int) (6000 + (50000 * Math.random() + 1));
         System.out.println("Producer " + name + " produced " + message);

         buffer.enter(message);
      }
   }

   private  BoundedBuffer buffer;
   private String name;
}
