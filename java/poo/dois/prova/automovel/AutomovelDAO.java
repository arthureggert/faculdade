package br.com.ahe.poo.dois.prova.automovel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public abstract class AutomovelDAO {
    private File arquivo;

    public AutomovelDAO(File arquivo) {
        this.arquivo = arquivo;
    }

    public abstract void gravar(ArrayList<Automovel> list) throws IOException;

    public abstract ArrayList<Automovel> ler() throws IOException, ClassNotFoundException;

    public File getArquivo() {
        return this.arquivo;
    }

    public void setArq(File arq) {
        this.arquivo = arq;
    }

}
