/* jpvmRecvThread.java
 *
 * A jpvmRecvThread is a thread of control in a JPVM program
 * responsible for receiving messages on a single receive
 * connection and enqueing them on a massage queue.
 *
 * Adam J Ferrari
 * Tue 06-04-1996
 *
 * Copyright (C) 1996  Adam J Ferrari
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 675 Mass Ave, Cambridge,
 * MA 02139, USA.
 */

package br.com.ahe.dscd.deamon;

public
class jpvmRecvThread extends Thread {
	private jpvmRecvConnection	conn;
	private jpvmMessageQueue	queue;
	int my_num;
	static  int num = 0;
	

	public jpvmRecvThread(jpvmRecvConnection c, jpvmMessageQueue q) {
		this.conn  = c;
		this.queue = q;
		num++;
		this.my_num = num;
	}
	
	public void run() {
	    boolean alive = true;
	    while(alive) {
	      try {
		jpvmDebug.note("jpvmRecvThread ("+this.my_num+") - blocking "+
			"for a message.");
		jpvmMessage nw = new jpvmMessage(this.conn);
		jpvmDebug.note("jpvmRecvThread ("+this.my_num+") - got a "+
			"new message.");
		this.queue.enqueue(nw);
		Thread.yield();
	      }
	      catch (jpvmException jpe) {
			jpvmDebug.note("jpvmRecvThread, " + 
				"connection closed");
		  	alive = false;
	      }
	    }
	}
};
