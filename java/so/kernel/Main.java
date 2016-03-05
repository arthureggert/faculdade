package br.com.ahe.so.kernel;

public class Main {

    public static void main(String[] args) {
        MyKernel k = new MyKernel();
        new FileSytemSimulator( k ).setVisible( true );
    }

}
