package br.com.ahe.ldp.produtor.exem1;
import java.awt.GridLayout;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Armazem extends JPanel {

	private static final long serialVersionUID = -3670115197334907474L;

	private int armazem[];

	private pnlArmazemLocal locais[];

	private int comeco;

	private int fim;

	private int tamanho;

	private int qtdProdutores;

	private Semaphore exclusivo;

	private Semaphore naoCheio;

	private Semaphore naoVazio;

	private ProdutorConsumidorControl controle;

	public Armazem(ProdutorConsumidorControl pccontrol, int tam,
			int qtdProdutores) {
		this.exclusivo = new Semaphore(1);
		this.naoCheio = new Semaphore(tam);
		this.naoVazio = new Semaphore(0);

		this.controle = pccontrol;

		this.qtdProdutores = qtdProdutores;
		this.armazem = new int[tam];
		this.tamanho = tam;
		this.comeco = this.fim = 0;

		this.setLayout(new GridLayout(tam + 1, 1));
		JLabel lbNome = new JLabel("Armazem");
		this.add(lbNome);
		this.locais = new pnlArmazemLocal[tam];
		for (int i = 0; i < tam; i++) {
			this.locais[i] = new pnlArmazemLocal();
			this.add(this.locais[i]);
		}

	}

	public void coloca(int produto) throws InterruptedException {
		// trata
		// InterruptedExceptionsdasd
		this.naoCheio.acquire();
		this.exclusivo.acquire();
		this.armazem[this.fim] = produto;
		this.locais[this.fim].setTxtTexto("" + this.armazem[this.fim]);
		this.fim++;
		if (this.fim == this.tamanho)
			this.fim = 0;
		this.exclusivo.release();
		this.naoVazio.release();
	}

	public int retira(int tipo) throws InterruptedException {
		// InterruptedExceptions

		if (this.naoVazio.tryAcquire(250 * this.qtdProdutores, TimeUnit.MILLISECONDS)) {
			this.exclusivo.acquire();
			int produtoTemporario = this.armazem[this.comeco];
			this.locais[this.fim].setTxtTexto("" + 0);
			this.comeco++;
			if (this.comeco == this.tamanho)
				this.comeco = 0;
			this.exclusivo.release();
			this.naoCheio.release();

			return produtoTemporario;
		}

		
		if(tipo == 0){// prod/cons
			if (this.controle.getQtdProdutoresAtivos() > 0) {
				return 0;
			}
		}else{
			if (this.controle.getQtdProdConsAtivos() > 0) {
				return 0;
			}
		}
		
		
		return -1;
	}

}