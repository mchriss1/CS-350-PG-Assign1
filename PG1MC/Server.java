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

      		Producer Liz = new Producer(server);
			Producer John = new Producer(server);

      		Consumer Bert = new Consumer(server);
			Consumer Mary = new Consumer(server);

      		Liz.start();
			John.start();

      		Bert.start();
			Mary.start();
	}//main
}//class
