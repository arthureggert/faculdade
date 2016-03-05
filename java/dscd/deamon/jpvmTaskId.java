/* jpvmTaskId.java
 *
 * Implements the unique jpvm task identifier class.
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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public
class jpvmTaskId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String		taskHost;
	private int		taskConnectPort;

	public jpvmTaskId() {
		this.taskHost 	= null;
		this.taskConnectPort = 0;
	};

	public jpvmTaskId(int my_port) {
		this.taskHost 	= null;
		this.taskConnectPort = 0;
		try {
			InetAddress taskAddr = InetAddress.getLocalHost();
			this.taskHost = taskAddr.getHostName();
			this.taskConnectPort = my_port;
		}
		catch (UnknownHostException uhe) {
			jpvmDebug.error("jpvmTaskId, unknown host exception");
		}
	}

	public jpvmTaskId(String host, int port) {
		this.taskHost 	= new String(host);
		this.taskConnectPort = port;
	}

	public String getHost() {
		return this.taskHost;
	}

	public int getPort() {
		return this.taskConnectPort;
	}

	public String toString() {
		return ((this.taskHost!=null ? this.taskHost : "(null)") +
			", port #"+this.taskConnectPort);
	}

	public boolean equals(jpvmTaskId tid) {
		if(tid == null)
			return false;
		if(this.taskConnectPort != tid.taskConnectPort)
			return false;
		if(tid.taskHost==null)
			return false;
		boolean ret = tid.taskHost.equalsIgnoreCase(this.taskHost);
		return ret;
	}

	public void send(DataOutputStream strm) throws jpvmException {
	    int i;
	    try {
		int len = 0;
		if(this.taskHost!=null) {
			len = this.taskHost.length();
			strm.writeInt(len);
			char hname[] = new char[len];
			this.taskHost.getChars(0,len,hname,0);
			for(i=0;i<len;i++) {
				strm.writeChar(hname[i]);
			}
		}
		else {
			strm.writeInt(len);
		}
		strm.writeInt(this.taskConnectPort);
	    }
	    catch (IOException ioe) {
		jpvmDebug.note("jpvmTaskId, send - i/o exception");
		throw new jpvmException("jpvmTaskId, send - i/o exception");
	    }
	}

	public void recv(DataInputStream strm) throws jpvmException {
	    int i;
	    try {
		int len = strm.readInt();
		if(len>0) {
			char hname[] = new char[len];
			for(i=0;i<len;i++) {
				hname[i] = strm.readChar();
			}
			this.taskHost = new String(hname);
		}
		else {
			this.taskHost = null;
		}
		this.taskConnectPort = strm.readInt();
	    }
	    catch (IOException ioe) {
		jpvmDebug.note("jpvmTaskId, recv - i/o exception");
		throw new jpvmException("jpvmTaskId, recv - i/o exception");
	    }
	}
};
