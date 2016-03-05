package br.com.ahe.poo.dois.prova.Imovel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public abstract class ImovelDAO {
    private File arquivo;

    public ImovelDAO(File arquivo) {
        this.arquivo = arquivo;
    }

    public abstract void gravar(ArrayList<Imovel> list) throws IOException;

    public abstract ArrayList<Imovel> ler() throws IOException, ClassNotFoundException;

    public File getArquivo() {
        return this.arquivo;
    }

    public void setArq(File arq) {
        this.arquivo = arq;
    }

}
