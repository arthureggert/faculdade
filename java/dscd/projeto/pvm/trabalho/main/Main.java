package br.com.ahe.dscd.projeto.pvm.trabalho.main;

import java.util.ArrayList;

import br.com.ahe.dscd.deamon.jpvmBuffer;
import br.com.ahe.dscd.deamon.jpvmEnvironment;
import br.com.ahe.dscd.deamon.jpvmException;
import br.com.ahe.dscd.deamon.jpvmMessage;
import br.com.ahe.dscd.deamon.jpvmTaskId;
import br.com.ahe.dscd.projeto.pvm.trabalho.quimica.ReacaoQuimicaCompletaFactory;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;

public class Main {

	static int numWorkers = 4 ;

	public static void main(String[] args) {

		ReacaoQuimicaCompletaFactory factory = new ReacaoQuimicaCompletaFactory();
		ArrayList<ReacaoQuimica> reacoes = new ArrayList<>(factory.criaReacoes());
		ArrayList<String> resultados = new ArrayList<>();

		try {
			jpvmEnvironment jpvm = new jpvmEnvironment();
//			jpvmTaskId myid = jpvm.pvm_mytid();
//			jpvmTaskId masterTaskId = jpvm.pvm_parent();
			jpvmTaskId taskIDs[] = new jpvmTaskId[numWorkers];
			jpvm.pvm_spawn("main.CriaReacaoQuimica2", numWorkers, taskIDs);

			for (int i = 0 ; i < numWorkers ; i++) {
				jpvmBuffer buf = new jpvmBuffer();
				buf.pack(reacoes.get(i).toString());
				jpvm.pvm_send(buf, taskIDs[i], 0);
			}

			for(int i = 0 ; i < numWorkers ; i++) {
				jpvmMessage message = jpvm.pvm_recv();
				if(message.messageTag == 0){
					resultados.add(message.buffer.upkstr());
				}
			}
		
			jpvm.pvm_spawn("main.NomeiaSal", numWorkers, taskIDs);

			for (int i = 0 ; i < numWorkers ; i++) {
				jpvmBuffer buf = new jpvmBuffer();
				buf.pack(resultados.get(i));
				jpvm.pvm_send(buf, taskIDs[i], i);
			}

			resultados = new ArrayList<String>();
			
			for(int i = 0 ; i < numWorkers ; i++) {
				jpvmMessage message = jpvm.pvm_recv();
				if(message.messageTag == 0){
					resultados.add(message.buffer.upkstr());
				}
			}
			
			jpvm.pvm_spawn("main.CriaPastaArquivos", numWorkers, taskIDs);
			
			for (int i = 0 ; i < numWorkers ; i++) {
				jpvmBuffer buf = new jpvmBuffer();
				buf.pack(resultados.get(i));
				jpvm.pvm_send(buf, taskIDs[i], i);
			}

			resultados = new ArrayList<String>();
			
			for(int i = 0 ; i < numWorkers ; i++) {
				jpvmMessage message = jpvm.pvm_recv();
				if(message.messageTag == 0){
					System.out.println("Pasta Criada Com Sucesso");
				}
			
			} 

			jpvm.pvm_exit();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (jpvmException e) {
			e.printStackTrace();
		}
	}

}
