package br.com.ahe.sd.trabalho.corba.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ahe.sd.trabalho.corba.Acao;
import br.com.ahe.sd.trabalho.corba.CarteiraDAOPOA;
import br.com.ahe.sd.trabalho.core.SimpleEntityManager;
import br.com.ahe.sd.trabalho.model.Carteira;
import br.com.ahe.sd.trabalho.model.ETipoMovimentacaoCarteria;
import br.com.ahe.sd.trabalho.model.MovimentacaoCarteira;
import br.com.ahe.sd.trabalho.model.Usuario;
import br.com.ahe.sd.trabalho.model.dao.IGenericDAO;

/**
 * Created by aheggert on 29/06/14.
 */
public class CarteiraDAOImpl extends CarteiraDAOPOA implements IGenericDAO<Carteira , Long> {

    private SimpleEntityManager entityManager = new SimpleEntityManager();

    @Override
    public br.com.ahe.sd.trabalho.corba.Carteira criaCarteira(String nomeUsuario) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o WHERE o.nome = :nome");
        query.setParameter("nome" , nomeUsuario);
        Usuario tmp = (Usuario) query.uniqueResult();
        Carteira cart = new Carteira();
        cart.setMovimentacoes(new ArrayList<>());
        cart.setValorReal(new BigDecimal("1000"));
        tmp.setCarteira(cart);
        cart = create(cart);
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        usuarioDAO.update(tmp);
        return new br.com.ahe.sd.trabalho.corba.Carteira(cart.getId().intValue() , cart.getSaldoDiponivel());
    }

    @Override
    public br.com.ahe.sd.trabalho.corba.Carteira buscaCarteira(String nomeUsuario) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o WHERE o.nome = :nome");
        query.setParameter("nome" , nomeUsuario);
        Usuario tmp = (Usuario) query.uniqueResult();
        if (tmp.getCarteira() == null ) {
            return new br.com.ahe.sd.trabalho.corba.Carteira();
        } else {
            Carteira cart = tmp.getCarteira();
            return new br.com.ahe.sd.trabalho.corba.Carteira(cart.getId().intValue() , cart.getSaldoDiponivel());
        }
    }

    @Override
    public void criaMovimentacaoCarteira(Acao acao, br.com.ahe.sd.trabalho.corba.Carteira carteira, double valor, double qtd, String tipo) {
        Carteira cart = findById(Long.valueOf(carteira.idAcao));
        BigDecimal vlrTot = BigDecimal.valueOf(qtd * valor);
        cart.setValorReal(cart.getValorReal().subtract(vlrTot));
        MovimentacaoCarteira mvCrt = new MovimentacaoCarteira();
        AcaoDAOImpl acaoDAO = new AcaoDAOImpl();
        br.com.ahe.sd.trabalho.model.Acao acaoModel = acaoDAO.findById(Long.valueOf(acao.idAcao));
        mvCrt.setAcao(acaoModel.getId());
        mvCrt.setCarteira(cart.getId());
        mvCrt.setDataMovimentacao(new Date());
        mvCrt.setQuantidade(BigDecimal.valueOf(qtd));
        mvCrt.setValor(BigDecimal.valueOf(valor));
        mvCrt.setTipoMovimentacaoCarteria(ETipoMovimentacaoCarteria.getFromString(tipo));
        cart.getMovimentacoes().add(mvCrt);
        update(cart);
        create(mvCrt);
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public boolean isAcaoComprada(Acao acao, br.com.ahe.sd.trabalho.corba.Carteira carteira, int qtd) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM MovimentacaoCarteira o WHERE o.carteira = :cart AND o.acao = :acao AND o.tipoMovimentacaoCarteria = :tipo");
        query.setParameter("acao" , Long.valueOf(acao.idAcao));
        query.setParameter("cart" , Long.valueOf(carteira.idAcao));
        query.setParameter("tipo" , ETipoMovimentacaoCarteria.COMPRA);
        List<MovimentacaoCarteira> dado = query.list();
        int compra = 0;
        for (MovimentacaoCarteira mv : dado) {
            compra +=mv.getQuantidade().intValue();
        }
        query.setParameter("acao" , Long.valueOf(acao.idAcao));
        query.setParameter("cart" , Long.valueOf(carteira.idAcao));
        query.setParameter("tipo" , ETipoMovimentacaoCarteria.VENDA);
        dado = query.list();
        int venda = 0;
        for (MovimentacaoCarteira mv : dado) {
            venda +=mv.getQuantidade().intValue();
        }
        System.out.println(compra);
        System.out.println(venda);
        if(compra > (venda + qtd)) {
            return true;
        }
        return false;
    }


    @Override
    public Carteira findById(Long aLong) {
        return (Carteira) getSimpleEntityManager().getSession().load(getTypeOfT() , aLong);
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Carteira> findAll() {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Carteira o");
        return query.list();
    }

    @Override
    public Carteira create(Carteira entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.save(entity);
            tx.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            tx.rollback();
        }
        return entity;
    }

    @Override
    public Carteira update(Carteira entity) {
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
    public void flush(Carteira entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.flush();
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
    }

    @Override
    public Class<Carteira> getTypeOfT() {
        return Carteira.class;
    }

    @Override
    public SimpleEntityManager getSimpleEntityManager() {
        return this.entityManager;
    }

    public void create(MovimentacaoCarteira entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.saveOrUpdate(entity);
            tx.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            tx.rollback();
        }
    }
}
