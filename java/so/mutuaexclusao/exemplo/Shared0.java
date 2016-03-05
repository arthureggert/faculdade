package br.com.ahe.so.mutuaexclusao.exemplo;
/** Apenas colocando o synchronized eu consigo fazer MutuaExclusao com Java */

class Shared0 {
    protected int x = 0,  y = 0;

    public  int dif() {
        return this.x - this.y;
    }
    public  void bump() throws InterruptedException {
        this.x++;
        int j=0;
        for (int i=0; i < 1000000; i++){
        	j = j + 1;
        }

        Thread.sleep(9);
        this.y++;
    }
}
