/* jpvmConnectionSet.java
 *
 * A class to manage the storage of a set of send and receive
 * connections to other jpvm tasks.
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


class jpvmSendConnectionListNode {
	public jpvmSendConnection		conn;
	public jpvmSendConnectionListNode	next;
	public jpvmSendConnectionListNode() {
		this.conn = null;
		this.next = null;
	}
	public jpvmSendConnectionListNode(jpvmSendConnection c) {
		this.conn = c;
		this.next = null;
	}
};

class jpvmRecvConnectionListNode {
	public jpvmRecvConnection		conn;
	public jpvmRecvConnectionListNode	next;
	public jpvmRecvConnectionListNode() {
		this.conn = null;
		this.next = null;
	}
	public jpvmRecvConnectionListNode(jpvmRecvConnection c) {
		this.conn = c;
		this.next = null;
	}
};

public
class jpvmConnectionSet {
	private jpvmRecvConnectionListNode		recvList;
	private jpvmSendConnectionListNode		sendList;
	private jpvmRecvConnectionListNode		recvListIter;

	jpvmConnectionSet() {
		this.recvList = null;
		this.sendList = null;
	}

	public synchronized jpvmRecvConnection
	lookupRecvConnection(jpvmTaskId tid) {
		jpvmRecvConnectionListNode tmp = this.recvList;
		while(tmp != null) {
			if(tmp.conn.tid.equals(tid))
				return tmp.conn;
			tmp = tmp.next;
		}
		return null;
	}

	public synchronized void insertRecvConnection(jpvmRecvConnection c) {
		jpvmRecvConnectionListNode nw;
		nw = new jpvmRecvConnectionListNode(c);
		nw.next = this.recvList;
		this.recvList = nw;
	}

	public synchronized jpvmRecvConnection
	firstIterRecv() {
		this.recvListIter = this.recvList;
		if(this.recvListIter!=null)
			return this.recvListIter.conn;
		return null;
	}

	public synchronized jpvmRecvConnection
	nextIterRecv() {
		if(this.recvListIter != null)
			this.recvListIter = this.recvListIter.next;
		if(this.recvListIter != null)
			return this.recvListIter.conn;
		return null;
	}

	public synchronized jpvmSendConnection
	lookupSendConnection(jpvmTaskId tid) {
		jpvmSendConnectionListNode tmp = this.sendList;
		while(tmp != null) {
			if(tmp.conn.tid.equals(tid))
				return tmp.conn;
			tmp = tmp.next;
		}
		return null;
	}

	public synchronized void insertSendConnection(jpvmSendConnection c) {
		jpvmSendConnectionListNode nw;
		nw = new jpvmSendConnectionListNode(c);
		nw.next = this.sendList;
		this.sendList = nw;
	}

};
