/* jpvmConnectionServer.java
 *
 * The jpvmConnectionServer class implements the thread of control 
 * in each jpvm program that establishes connections with other
 * jpvm tasks that want to send data.
 *
 * Adam J Ferrari
 * Sat 05-25-1996
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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public
class jpvmConnectionServer extends Thread {
	private ServerSocket		connectionSock;
	private int			connectionPort;
	private jpvmConnectionSet	connectionSet;
	private jpvmMessageQueue	queue;

	public jpvmConnectionServer(jpvmConnectionSet c, jpvmMessageQueue q) {
		this.connectionSet  = c;
		this.connectionSock = null;
		this.connectionPort = 0;
		this.queue = q;
		try {
			this.connectionSock = new ServerSocket(0);
			this.connectionPort = this.connectionSock.getLocalPort();
		}
		catch (IOException ioe) {
			jpvmDebug.error("jpvmConnectionServer, i/o exception");
		}
	}

	public int getConnectionPort() {
		return this.connectionPort;
	}

	public void run() {
	    while(true) {
	      try {
		jpvmDebug.note("jpvmConnectionServer, blocking on port " +
			this.connectionSock.getLocalPort());
		Socket newConnSock = this.connectionSock.accept();
		jpvmDebug.note("jpvmConnectionServer, new connection.");
		jpvmRecvConnection nw = new jpvmRecvConnection(newConnSock);
		this.connectionSet.insertRecvConnection(nw);

		// Start a thread to recv on this pipe
		jpvmRecvThread rt=new jpvmRecvThread(nw,this.queue);
		rt.start();
	      }
	      catch (IOException ioe) {
			jpvmDebug.error("jpvmConnectionServer, run - " + 
				"i/o exception");
	      }
	    }
	}
};
