package br.com.ahe.sd.trabalho.corba.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ahe.sd.trabalho.corba.AcaoDAOPOA;
import br.com.ahe.sd.trabalho.core.SimpleEntityManager;
import br.com.ahe.sd.trabalho.model.Acao;
import br.com.ahe.sd.trabalho.model.Empresa;
import br.com.ahe.sd.trabalho.model.MovimentacaoAcao;
import br.com.ahe.sd.trabalho.model.dao.IGenericDAO;
import br.com.ahe.sd.trabalho.webservice.MovimentacaoXML;
import br.com.ahe.sd.trabalho.webservice.WebserviceUtils;

/**
 * Created by aheggert on 29/06/14.
 */
public class AcaoDAOImpl extends AcaoDAOPOA implements IGenericDAO<Acao , Long> {

    private SimpleEntityManager simpleEntityManager;
    private MovimentacaoAcao[] movimentacoes;

    @Override
    public br.com.ahe.sd.trabalho.corba.Acao criaAcao(String codigoEmpresa) {
        Acao acaoModel = new Acao();
        EmpresaDAOImpl empDAO = new EmpresaDAOImpl();
        List<Empresa> dadosEmp = empDAO.findAll();
        Empresa emp = null;
        for (Empresa empresa : dadosEmp) {
            if(empresa.getSiglaEmpresa().equals(codigoEmpresa)) {
                emp = empresa;
                break;
            }
        }
        acaoModel.setEmpresa(emp.getId());
        acaoModel.setQuantidadeNegocios(BigDecimal.ONE);
        acaoModel = create(acaoModel);

        br.com.ahe.sd.trabalho.corba.Acao acao = new br.com.ahe.sd.trabalho.corba.Acao();
        acao.idAcao = acaoModel.getId().intValue();
        acao.qtdNegocios = acaoModel.getQuantidadeNegocios().intValue();
        acao.codigoEmpresa = acaoModel.getEmpresa().intValue();
        return acao;
    }

    @Override
    public br.com.ahe.sd.trabalho.corba.Acao buscaAcap(String codigoEmpresa) {
        EmpresaDAOImpl empDAO = new EmpresaDAOImpl();
        List<Empresa> dadosEmp = empDAO.findAll();
        Empresa emp = null;
        for (Empresa empresa : dadosEmp) {
            if(empresa.getSiglaEmpresa().equals(codigoEmpresa)) {
                emp = empresa;
                break;
            }
        }
        List<Acao> dadosAcao = findAll();
        Acao ac = null;
        for (Acao acao : dadosAcao) {
            if(acao.getEmpresa().equals(emp.getId())) {
                ac = acao;
                break;
            }
        }
        return new br.com.ahe.sd.trabalho.corba.Acao(ac.getId().intValue() , ac.getQuantidadeNegocios().intValue() , ac.getEmpresa().intValue());
    }

    @Override
    public void criaMovimentacaoAcao(br.com.ahe.sd.trabalho.corba.Acao acao, String tipo) {
        Acao acaoModel = findById(Long.valueOf(acao.idAcao));
        acaoModel.setQuantidadeNegocios(acaoModel.getQuantidadeNegocios().add(BigDecimal.ONE));
        Empresa emp = new EmpresaDAOImpl().findById(acaoModel.getEmpresa());
        MovimentacaoXML mv = WebserviceUtils.get().movimentoAcao(emp.getSiglaEmpresa());

        if(getMovimentacaoFromAcao(acaoModel)){
            MovimentacaoAcao mvAcao = new MovimentacaoAcao();
            mvAcao.setDataMoviemnto(new Date());
            mvAcao.setPercentualOsilacao(new BigDecimal(mv.getOscilacao()));
            mvAcao.setValorAtual(new BigDecimal(mv.getAtual()));
            mvAcao.setValorMaxima(new BigDecimal(mv.getMaximo()));
            mvAcao.setValorMinima(new BigDecimal(mv.getMinimo()));
            mvAcao.setAcao(acaoModel.getId());
            updateMvAcao(mvAcao);
        }
    }

    private void updateMvAcao(MovimentacaoAcao ac) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.saveOrUpdate(ac);
            tx.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public Acao findById(Long aLong) {
        Acao finded = (Acao) getSimpleEntityManager().getSession().load(getTypeOfT(), aLong);
        return finded;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Acao> findAll() {
        Query q = getSimpleEntityManager().getSession().createQuery("SELECT t FROM " + getTypeOfT().getSimpleName() + " t");
        return q.list();
    }

    @Override
    public Acao create(Acao entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.save(entity);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
        List<Acao> dados = findAll();
        for (Acao ac : dados) {
            Empresa acEmp = new EmpresaDAOImpl().findById(entity.getEmpresa());
            Empresa entityEmp = new EmpresaDAOImpl().findById(entity.getEmpresa());
            if(acEmp.getSiglaEmpresa().equals(entityEmp.getSiglaEmpresa())) {
                entity = ac;
                break;
            }
        }
        return entity;
    }

    @Override
    public Acao update(Acao entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.update(entity);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
        return entity;
    }

    @Override
    public void flush(Acao entity) {

    }

    @Override
    public Class<Acao> getTypeOfT() {
        return Acao.class;
    }

    @Override
    public SimpleEntityManager getSimpleEntityManager() {
        return this.simpleEntityManager;
    }

    private boolean getMovimentacaoFromAcao(Acao acao) {
        List<MovimentacaoAcao> dados = getMovimentacoes(acao);
        if(dados == null || dados.isEmpty()) {
            return true;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dtHj = dateFormat.format(new Date());

        for (MovimentacaoAcao mv : dados) {
            if(dateFormat.format(mv.getDataMoviemnto()).compareTo(dtHj) == 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings( "unchecked" )
    public List<MovimentacaoAcao> getMovimentacoes(Acao acao) {
        Query q = getSimpleEntityManager().getSession().createQuery("Select c FROM MovimentacaoAcao c WHERE c.acao = :acao");
        q.setParameter("acao" , acao.getId());
        return q.list();
    }

	public MovimentacaoAcao[] getMovimentacoes() {
	    return this.movimentacoes;
    }

	public void setMovimentacoes( MovimentacaoAcao[] movimentacoes ) {
	    this.movimentacoes = movimentacoes;
    }
}
