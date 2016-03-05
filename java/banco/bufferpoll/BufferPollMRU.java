package br.com.ahe.banco.bufferpoll;


public class BufferPollMRU extends BufferPoll{

	private static final long serialVersionUID = 1L;

	@Override
	protected BufferPollItem selecionaPaginaParaRemocao() {
		BufferPollItem paginaRemocao = getRaiz();
		BufferPollItem tmp = getRaiz();
		while(paginaRemocao != null)  {
			if ( tmp.getPagina().getUltimoAcesso().after( paginaRemocao.getPagina().getUltimoAcesso() ) ){
				paginaRemocao = tmp;
			}
			tmp = tmp.getProximo();
		}
		return paginaRemocao;
	}

}
