/* jpvmBuffer.java
 *
 * Classes to implement a packable / unpackable buffer that can
 * be used to store the payload associated with a message.
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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class jpvmBufferElementContents implements Serializable {
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	public int 		dataType;
	public int 		arraySize;
	public byte 		byteArray[];
	public char 		charArray[];
	public int  		intArray[];
	public short		shortArray[];
	public long		longArray[];
	public float		floatArray[];
	public double		doubleArray[];
	public jpvmTaskId	taskArray[];

	private void init() {
		this.dataType 	= jpvmDataType.jpvmNull;
		this.arraySize 	= 0;
		this.byteArray 	= null;
		this.charArray 	= null;
		this.shortArray 	= null;
		this.intArray 	= null;
		this.longArray 	= null;
		this.floatArray 	= null;
		this.doubleArray 	= null;
		this.taskArray 	= null;
	}

        public jpvmBufferElementContents(jpvmTaskId d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmTid;
                if(stride==1) {
                        if(inPlace)
                                this.taskArray=d;
                        else {
                                this.taskArray = new jpvmTaskId[n];
                                System.arraycopy(d,0,this.taskArray,0,n);
                        }
                }
                else {
                        this.taskArray = new jpvmTaskId[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.taskArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(short d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmShort;
                if(stride==1) {
                        if(inPlace)
                                this.shortArray=d;
                        else {
                                this.shortArray = new short[n];
                                System.arraycopy(d,0,this.shortArray,0,n);
                        }
                }
                else {
                        this.shortArray = new short[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.shortArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(int d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmInteger;
                if(stride==1) {
                        if(inPlace)
                                this.intArray=d;
                        else {
                                this.intArray = new int[n];
                                System.arraycopy(d,0,this.intArray,0,n);
                        }
                }
                else {
                        this.intArray = new int[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.intArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(long d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmLong;
                if(stride==1) {
                        if(inPlace)
                                this.longArray=d;
                        else {
                                this.longArray = new long[n];
                                System.arraycopy(d,0,this.longArray,0,n);
                        }
                }
                else {
                        this.longArray = new long[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.longArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(char d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmChar;
                if(stride==1) {
                        if(inPlace)
                                this.charArray=d;
                        else {
                                this.charArray = new char[n];
                                System.arraycopy(d,0,this.charArray,0,n);
                        }
                }
                else {
                        this.charArray = new char[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.charArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(float d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmFloat;
                if(stride==1) {
                        if(inPlace)
                                this.floatArray=d;
                        else {
                                this.floatArray = new float[n];
                                System.arraycopy(d,0,this.floatArray,0,n);
                        }
                }
                else {
                        this.floatArray = new float[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.floatArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(double d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmDouble;
                if(stride==1) {
                        if(inPlace)
                                this.doubleArray=d;
                        else {
                                this.doubleArray = new double[n];
                                System.arraycopy(d,0,this.doubleArray,0,n);
                        }
                }
                else {
                        this.doubleArray = new double[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.doubleArray[i] = d[j];
                }
        }

        public jpvmBufferElementContents(byte d[],int n,int stride,
	    boolean inPlace) {
                init();
		this.dataType = jpvmDataType.jpvmByte;
                if(stride==1) {
                        if(inPlace)
                                this.byteArray=d;
                        else {
                                this.byteArray = new byte[n];
                                System.arraycopy(d,0,this.byteArray,0,n);
                        }
                }
                else {
                        this.byteArray = new byte[n];
                        int i,j;
                        for(i=0, j=0; i<n; i++,j+=stride)
                                this.byteArray[i] = d[j];
                }
        }

	public void unpack(int d[], int n, int stride) 
	    throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmInteger) {
		    throw new jpvmException("buffer type mismatch, upkint.");
		}
		if(stride==1) {
			System.arraycopy(this.intArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.intArray[i];
		}
	}

	public void unpack(short d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmShort) {
		    throw new jpvmException("buffer type mismatch, upkshort.");
		}
		if(stride==1) {
			System.arraycopy(this.shortArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.shortArray[i];
		}
	}

	public void unpack(byte d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmByte) {
		    throw new jpvmException("buffer type mismatch, upkbyte.");
		}
		if(stride==1) 
			System.arraycopy(this.byteArray,0,d,0,n);
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.byteArray[i];
		}
	}

	public void unpack(char d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmChar) {
		    throw new jpvmException("buffer type mismatch, upkchar.");
		}
		if(stride==1) {
			System.arraycopy(this.charArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.charArray[i];
		}
	}

	public void unpack(long d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmLong) {
		    throw new jpvmException("buffer type mismatch, upklong.");
		}
		if(stride==1) {
			System.arraycopy(this.longArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.longArray[i];
		}
	}

	public void unpack(double d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmDouble) {
		    throw new jpvmException("buffer type mismatch, upkdouble.");
		}
		if(stride==1) {
			System.arraycopy(this.doubleArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.doubleArray[i];
		}
	}

	public void unpack(float d[], int n, int stride) throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmFloat) {
		    throw new jpvmException("buffer type mismatch, upkfloat.");
		}
		if(stride==1) {
			System.arraycopy(this.floatArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.floatArray[i];
		}
	}

	public void unpack(jpvmTaskId d[], int n, int stride)
	    throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmTid) {
		    throw new jpvmException("buffer type mismatch, upktid.");
		}
		if(stride==1) {
			System.arraycopy(this.taskArray,0,d,0,n);
		}
		else {
			int i,j;
			for(i=0,j=0;i<n;i++,j+=stride)
				d[j] = this.taskArray[i];
		}
	}

	public String unpack() throws jpvmException {
		if(this.dataType != jpvmDataType.jpvmString) {
		    throw new jpvmException("buffer type mismatch, upkstring.");
		}
		return new String(this.charArray);
	}
};

class jpvmBufferElement {
	private boolean			  inPlace;
	public  jpvmBufferElementContents contents;
	public  jpvmBufferElement         next; // Linked structure

	public void init() {
		this.contents = null;
		this.next = null;
	}

	public jpvmBufferElement() {
		init();
		this.inPlace = false;
	}

	public jpvmBufferElement(boolean dataInPlace) {
		init();
		this.inPlace = dataInPlace;
	}

	public jpvmBufferElement(jpvmTaskId d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(jpvmTaskId d) {
		init();
		jpvmTaskId a[] = new jpvmTaskId[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(byte d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(byte d) {
		init();
		byte a[] = new byte[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(short d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(short d) {
		init();
		short a[] = new short[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(char d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(char d) {
		init();
		char a[] = new char[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}


	public jpvmBufferElement(long d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(long d) {
		init();
		long a[] = new long[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}
	
	
	public jpvmBufferElement(int d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(int d) {
		init();
		int a[] = new int[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(float d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(float d) {
		init();
		float a[] = new float[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(double d[],int n,int stride) {
		init();
		this.contents = new jpvmBufferElementContents(d,n,stride,this.inPlace);
	}

	public jpvmBufferElement(double d) {
		init();
		double a[] = new double[1];
		a[0] = d;
		this.contents = new jpvmBufferElementContents(a,1,1,true);
	}

	public jpvmBufferElement(String str) {
		init();
		int n = str.length();
		char a[] = new char[n];
		str.getChars(0,n,a,0);
		this.contents = new jpvmBufferElementContents(a,n,1,true);
		this.contents.dataType = jpvmDataType.jpvmString;
	}

	public void unpack(int d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(short d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(byte d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(char d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(long d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(double d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(float d[], int n, int stride) throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public void unpack(jpvmTaskId d[], int n, int stride)
	    throws jpvmException {
		this.contents.unpack(d,n,stride);
	}

	public String unpack() throws jpvmException {
		return this.contents.unpack();
	}

	@SuppressWarnings( "unused" )
    public void send(jpvmSendConnection conn) throws jpvmException {
		int i;
		try {
			ObjectOutputStream out;
			out = new ObjectOutputStream(conn.strm);
			out.writeObject(this.contents);
			//out.flush();
		}
		catch (IOException ioe) {
			System.err.println("I/O exception - "+ioe);
			jpvmDebug.note("jpvmBufferElement, " +
				"send - i/o exception");
			throw new jpvmException("jpvmBufferElement, " +
				"send - i/o exception");
		}
	}

	@SuppressWarnings( "unused" )
	public void recv(jpvmRecvConnection conn) throws jpvmException {
        int i;
		try {
			ObjectInputStream in;
			in = new ObjectInputStream(conn.strm);
			try {
			  this.contents = (jpvmBufferElementContents)in.readObject();
			}
			catch (ClassNotFoundException cnf) {
			  throw new jpvmException("jpvmBufferElement, " +
				"recv - can't find class "+
				"jpvmBufferElementContents");
			}
		}
		catch (IOException ioe) {
			jpvmDebug.note("jpvmBufferElement, " +
				"recv - i/o exception");
			throw new jpvmException("jpvmBufferElement, " +
				"recv - i/o exception");
		}
	}
};

public
class jpvmBuffer {
	private jpvmBufferElement list_head;
	private jpvmBufferElement list_tail;
	private jpvmBufferElement curr_elt;
	private int num_list_elts;

	private void addElt(jpvmBufferElement nw) {
		this.num_list_elts ++;
		if(this.list_head == null) {
			this.curr_elt = this.list_head = this.list_tail = nw;
			return;
		}
		this.list_tail.next = nw;
		this.list_tail = nw;
	}

	public jpvmBuffer() {
		this.list_head = null;
		this.list_tail = null;
		this.num_list_elts = 0;
	}

	public void rewind() {
		this.curr_elt = this.list_head;
	}

	public void pack(int d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(int d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(char d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(char d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(short d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(short d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(long d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(long d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(byte d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(byte d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(float d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(float d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(double d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(double d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(jpvmTaskId d[], int n, int stride) {
		jpvmBufferElement nw = new jpvmBufferElement(d,n,stride);
		addElt(nw);
	}

	public void pack(jpvmTaskId d) {
		jpvmBufferElement nw = new jpvmBufferElement(d);
		addElt(nw);
	}

	public void pack(String str) {
		jpvmBufferElement nw = new jpvmBufferElement(str);
		addElt(nw);
	}

	public void unpack(int d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkint.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}
	
	public int upkint() throws jpvmException {
		int d[] = new int[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(byte d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkbyte.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public byte upkbyte() throws jpvmException {
		byte d[] = new byte[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(char d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkchar.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public char upkchar() throws jpvmException {
		char d[] = new char[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(short d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkshort.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public short upkshort() throws jpvmException {
		short d[] = new short[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(long d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upklong.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public long upklong() throws jpvmException {
		long d[] = new long[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(float d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkfloat.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public float upkfloat() throws jpvmException {
		float d[] = new float[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(double d[], int n, int stride) throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkdouble.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public double upkdouble() throws jpvmException {
		double d[] = new double[1];
		unpack(d,1,1);
		return d[0];
	}

	public void unpack(jpvmTaskId d[], int n, int stride) 
	  throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upktid.");
		this.curr_elt.unpack(d,n,stride);
		this.curr_elt = this.curr_elt.next;
	}

	public jpvmTaskId upktid() throws jpvmException {
		jpvmTaskId d[] = new jpvmTaskId[1];
		unpack(d,1,1);
		return d[0];
	}

	public String upkstr() throws jpvmException {
		if(this.curr_elt == null)
			throw new jpvmException("buffer empty, upkstring.");
		String ret = this.curr_elt.unpack();
		this.curr_elt = this.curr_elt.next;
		return ret;
	}

	public void send(jpvmSendConnection conn) throws jpvmException {
		DataOutputStream strm = conn.strm;
		jpvmBufferElement tmp = this.list_head;
		try {
			strm.writeInt(this.num_list_elts);
			while(tmp != null) {
				tmp.send(conn);
				tmp = tmp.next;
			}
		}
		catch (IOException ioe) {
			jpvmDebug.note("jpvmBuffer, send - i/o exception");
			throw new jpvmException("jpvmBuffer, send - " +
				"i/o exception");
		}
	}

	public void recv(jpvmRecvConnection conn) throws jpvmException {
		int i, N;
		jpvmBufferElement tmp;
		
		DataInputStream strm = conn.strm;
		try {
			N = strm.readInt();
			jpvmDebug.note("jpvmBuffer, recv "+N+
				" buffer elements.");
			for(i=0;i<N;i++) {
				tmp = new jpvmBufferElement();
				tmp.recv(conn);
				addElt(tmp);
			}
		}
		catch (IOException ioe) {
			jpvmDebug.note("jpvmBuffer, recv - i/o exception");
			throw new jpvmException("jpvmBuffer, recv - " +
				"i/o exception");
		}
	}
};
