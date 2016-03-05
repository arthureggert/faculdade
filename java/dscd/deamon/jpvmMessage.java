/* jpvmMessage
 *
 * A class representing a message in the jpvm system. Messages
 * can be either sent or received to or from other jpvm tasks.
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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public
class jpvmMessage {
	public int 		messageTag;
	public jpvmTaskId	sourceTid;
	public jpvmTaskId	destTid;
	public jpvmBuffer	buffer;

	public jpvmMessage() {
		this.messageTag = -1;
		this.sourceTid = null;
		this.destTid = null;
		this.buffer = null;
	}

	public jpvmMessage(jpvmBuffer buf, jpvmTaskId dest, jpvmTaskId src,
	    int tag) {
		this.messageTag = tag;
		this.sourceTid = src;
		this.destTid = dest;
		this.buffer = buf;
	}

	public jpvmMessage(jpvmRecvConnection conn) throws jpvmException {
		this.messageTag = -1;
		this.sourceTid = null;
		this.destTid = null;
		this.buffer = null;
		recv(conn);
	}

	public void send(jpvmSendConnection conn) throws jpvmException {
		DataOutputStream strm = conn.strm;
		try {
			strm.writeInt(this.messageTag);
			this.sourceTid.send(strm);
			this.destTid.send(strm);
			this.buffer.send(conn);
			strm.flush();
		}
		catch (IOException ioe) {
			jpvmDebug.note("jpvmMessage, send - i/o exception");
			throw new jpvmException("jpvmMessage, send - " +
				"i/o exception");
		}
	}

	public void recv(jpvmRecvConnection conn) throws jpvmException {
		DataInputStream strm = conn.strm;
		try {
			this.messageTag = strm.readInt();
			this.sourceTid = new jpvmTaskId();
			this.sourceTid.recv(strm);
			this.destTid = new jpvmTaskId();
			this.destTid.recv(strm);
			this.buffer = new jpvmBuffer();
			this.buffer.recv(conn);
		}
		catch (IOException ioe) {
			jpvmDebug.note("jpvmMessage, recv - i/o exception");
			throw new jpvmException("jpvmMessage, recv - " +
				"i/o exception");
		}
	}
};
