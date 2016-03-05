package br.com.ahe.ldp.exemplos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HeapSpace {  
	  
    public static void main(String[] args) {  
        boolean loop = true;   
        Map<Integer,BigDecimal> lista = new HashMap<Integer,BigDecimal>();  
        System.out.println(Runtime.getRuntime().freeMemory());
        Integer i = new Integer(0);
        while (loop){  
            try{  
            	BigDecimal tmp = new BigDecimal(i++);
            	System.out.println(tmp);
                lista.put(i, tmp);
            }catch(OutOfMemoryError err){  
            	err.printStackTrace();
                System.out.println(Runtime.getRuntime().freeMemory());  
            }  
        }         
    }  
}  