package br.com.ahe.banco.bufferpoll;

import static br.com.ahe.banco.disco.Disco.DISCO;

import java.io.Serializable;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import br.com.ahe.banco.exception.PaginaEmUsoException;
import br.com.ahe.banco.exception.PaginaNaoEncontradaException;
import br.com.ahe.banco.pagina.Pagina;

@ToString
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BufferPoll implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int BUFFER_SIZE = 10;

	@Getter
	private BufferPollItem raiz;

	public Pagina carregaPagina(int id) throws PaginaNaoEncontradaException {
		Pagina paginaCarregada = null;
		try {
			paginaCarregada = pesquisa(id);
			if ( !Objects.isNull(paginaCarregada) ) {
				return paginaCarregada;
			}
		} catch (PaginaNaoEncontradaException pnfe) {
			paginaCarregada = DISCO.carregaPagina(id);
			adicionaPaginaAoPool(paginaCarregada);
		}
		return paginaCarregada;
	}

	public void salvaPaginaDisco(Pagina  pagina ) {
		if ( pagina.isEmUso() ) {
			throw new PaginaEmUsoException( pagina.getId() );
		}
		if ( pagina.isSujo() ) {
			DISCO.salvaPagina(pagina);
		}
	}

	public void changePage(int id ) throws PaginaNaoEncontradaException{
		Pagina pagina = pesquisa(id);
		if ( pagina.isEmUso() ) {
			throw new PaginaEmUsoException( pagina.getId() );
		}
		pagina.setSujo(true);
	}
	
	public String listaPaginas() {
		StringBuilder builder = new StringBuilder();
		BufferPollItem tmp = raiz;
		while ( tmp != null ) {
			builder.append(tmp.getPagina());
		}
		return builder.toString();
	}

	private void adicionaPaginaAoPool(Pagina pagina) {
		if ( tamanhoAtual() < BUFFER_SIZE ) {
			adiciona(pagina);
		} else {
			BufferPollItem paginaParaRemover = selecionaPaginaParaRemocao();
			salvaPaginaDisco(paginaParaRemover.getPagina());
			retira(paginaParaRemover);
			adiciona(pagina);
		}
	}

	protected abstract BufferPollItem selecionaPaginaParaRemocao();

	private Pagina pesquisa(int id) throws PaginaNaoEncontradaException {
		BufferPollItem tmp = raiz;
		while ( tmp != null ) {
			if ( tmp.getPagina().getId() == id ) {
				return tmp.getPagina();
			} else {
				tmp = tmp.getProximo();
			}
		}
		throw new PaginaNaoEncontradaException();
	}

	private int tamanhoAtual() {
		int tamanho = 0;
		BufferPollItem tmp = raiz;
		while ( tmp != null ) {
			tamanho++;
			tmp = tmp.getProximo();
		}
		return tamanho;
	}

	private void adiciona(Pagina pagina) {
		BufferPollItem tmp = new BufferPollItem(pagina , raiz);
		raiz = tmp;
	}

	private void retira(BufferPollItem paginaParaRemover) {
		BufferPollItem anterior = null;
		BufferPollItem tmpRaiz = raiz;
		while (tmpRaiz != null && Objects.equals(tmpRaiz, paginaParaRemover)){
			anterior = tmpRaiz;
			tmpRaiz = tmpRaiz.getProximo();
		}
		if (anterior == null){
			raiz = tmpRaiz.getProximo();		
		} else {
			anterior.setProximo(tmpRaiz.getProximo());
		}
	}





}
