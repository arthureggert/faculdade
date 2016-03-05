package br.com.ahe.poo.dois.prova.Imovel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ImovelDAOSerializado extends ImovelDAO {

    public ImovelDAOSerializado(File arquivo) {
        super(arquivo);
    }

    public void gravar(ArrayList<Imovel> listaDeImoveis) throws IOException {
        ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(new FileOutputStream(getArquivo()));
            for (Imovel imo : listaDeImoveis) {
                out.writeObject(imo);
            }
            out.writeObject(null);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public ArrayList<Imovel> ler() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        ArrayList<Imovel> listaDeImoveis  = new ArrayList<Imovel>();
        try {
            in = new ObjectInputStream(new FileInputStream(getArquivo()));
            Imovel imo = (Imovel) in.readObject();
            while (imo != null) {
            	listaDeImoveis.add(imo);
                imo = (Imovel) in.readObject();
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return listaDeImoveis;
    }
}
    