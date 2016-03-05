package br.com.ahe.poo.dois.prova.automovel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AutomovelDAOSerializado extends AutomovelDAO {

    public AutomovelDAOSerializado(File arquivo) {
        super(arquivo);
    }

    public void gravar(ArrayList<Automovel> listaDeAutomoveis) throws IOException {
        ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(new FileOutputStream(getArquivo()));
            for (Automovel imo : listaDeAutomoveis) {
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

    public ArrayList<Automovel> ler() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        ArrayList<Automovel> listaDeAutomoveis  = new ArrayList<Automovel>();
        try {
            in = new ObjectInputStream(new FileInputStream(getArquivo()));
            Automovel imo = (Automovel) in.readObject();
            while (imo != null) {
            	listaDeAutomoveis.add(imo);
                imo = (Automovel) in.readObject();
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return listaDeAutomoveis;
    }
}
    