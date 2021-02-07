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

public class Producer extends Thread
{
   public Producer(BoundedBuffer b) {
      buffer = b;
   }

   public void run()
   {
   Date message;
   int value;

      while (true)
      {
         int sleeptime = (int) (4 + (7 * Math.random()));
         	//sleeptime is the number of seconds the producer thread is going to sleep. 
            //in this case the sleep range is from 4 to 7

         System.out.println("Producer sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // produce an item & enter it into the buffer
         message = new Date();
         
         value = (int) (6000 + (50000 * Math.random()));
         System.out.println("Producer produced " + value + " " + message);

         buffer.enter(message);
      }
   }

   private  BoundedBuffer buffer;

}
