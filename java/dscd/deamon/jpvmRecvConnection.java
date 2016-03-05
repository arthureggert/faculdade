/* jpvmRecvConnection.java
 *
 * The jpvmRecvConnection class implements objects that represent
 * connections to remote jpvm processes from which messages may be
 * received.
 *
 * Adam J Ferrari
 * Sun 05-26-1996
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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public
class jpvmRecvConnection {
	private InputStream	instrm;
	public DataInputStream	strm;
	public jpvmTaskId	tid;
	
	public jpvmRecvConnection() {
		this.instrm = null;
		this.strm = null;
		this.tid   = null;
	}

	public jpvmRecvConnection(Socket sock) {
		if(sock==null) return;
		try {
			this.instrm = sock.getInputStream();
			this.instrm = new BufferedInputStream(this.instrm);
			this.strm = new DataInputStream(this.instrm);
			this.tid = new jpvmTaskId();
			try {
				this.tid.recv(this.strm);
			}
			catch (jpvmException jpe) {
				this.strm  = null;
				this.tid   = null;
				jpvmDebug.error("jpvmRecvConnection, internal"+
					" error");
			}
			jpvmDebug.note("jpvmRecvConnection, connect to "
				+this.tid.toString()+" established");
		}
		catch (IOException ioe) {
			this.strm  = null;
			this.tid   = null;
			jpvmDebug.error("jpvmRecvConnection, i/o exception");
		}
		if(this.strm == null) return;
	}

	public boolean hasMessagesQueued() {
		boolean ret = false;
		if(this.instrm != null) {
			try {
			  if (this.instrm.available() > 0)
				ret = true;
			}
			catch (IOException ioe) {
				ret = false;
				jpvmDebug.error("jpvmRecvConnection, " +
					"hasMessagesQueued - i/o exception");
			}
		}
		return ret;
	}
};
