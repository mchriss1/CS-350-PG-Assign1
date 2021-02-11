/**Name: Martez Christian
 * Course: CS 350-001
 * Programming Assignment 1
 * Date: 2/7/2021
 * Server.java
 *
 * This creates the buffer and the producer and consumer threads.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

public class Server
{
	public static void main(String args[]) {
		BoundedBuffer server = new BoundedBuffer();
		
      		// now create the producer and consumer threads
			Producer John = new Producer("John", server);
      		Producer Liz = new Producer("Liz", server);
			
			Consumer Mary = new Consumer("Mary", server);
      		Consumer Bert = new Consumer("Bert", server);
			

      		John.start();
			Liz.start();

      		Mary.start();
			Bert.start();
	}//main
}//class
