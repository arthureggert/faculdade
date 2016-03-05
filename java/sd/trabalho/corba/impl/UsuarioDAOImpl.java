package br.com.ahe.sd.trabalho.corba.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ahe.sd.trabalho.corba.UsuarioDAOPOA;
import br.com.ahe.sd.trabalho.core.SimpleEntityManager;
import br.com.ahe.sd.trabalho.model.Carteira;
import br.com.ahe.sd.trabalho.model.ETipoMovimentacaoCarteria;
import br.com.ahe.sd.trabalho.model.MovimentacaoCarteira;
import br.com.ahe.sd.trabalho.model.Usuario;
import br.com.ahe.sd.trabalho.model.dao.IGenericDAO;

/**
 * Created by aheggert on 28/06/14.
 */
public class UsuarioDAOImpl extends UsuarioDAOPOA implements IGenericDAO<Usuario , Long> {

    private SimpleEntityManager simpleEntityManager;

    @Override
    public br.com.ahe.sd.trabalho.corba.Usuario validaUsuario(String nomeUsuario, String senhaUsuario) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o WHERE o.nome = :nome AND o.senha = :senha");
        query.setParameter("nome" , nomeUsuario);
        query.setParameter("senha" , senhaUsuario);
        Usuario tmp = (Usuario) query.list().get(0);
        if(tmp == null) {
            throw new IllegalArgumentException("ERRO");
        }
        Integer idCarteira = tmp.getCarteira() != null ? tmp.getCarteira().getId().intValue() : 0;

        br.com.ahe.sd.trabalho.corba.Usuario retorno = new br.com.ahe.sd.trabalho.corba.Usuario(tmp.getNome().substring(0,1).toUpperCase() + tmp.getNome().substring(1), tmp.getSenha(), idCarteira);
        return retorno;
    }

    @Override
    public double buscaSaldoDisponivel(String nomeUsuario) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o WHERE o.nome = :nome");
        query.setParameter("nome" , nomeUsuario);
        Usuario tmp = (Usuario) query.uniqueResult();
        return tmp.getCarteira() != null ? getSaldoDiponivel(tmp.getCarteira()) : 0d;
    }

    private double getSaldoDiponivel(Carteira carteira) {
       return carteira.getValorReal().doubleValue() - getValorMovimentacoes(carteira);
    }

    @Override
    public double buscaSaldoGeral(String nomeUsuario) {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o WHERE o.nome = :nome");
        query.setParameter("nome" , nomeUsuario);
        Usuario tmp = (Usuario) query.uniqueResult();
        return tmp.getCarteira() != null ?  getSaldoGeral(tmp.getCarteira()): 0d;
    }

    public double getSaldoGeral(Carteira carteira) {
        return carteira.getValorReal().doubleValue() - getValorMovimentacoes(carteira) + getValorMovimentacoesVenda(carteira);
    }

    private double getValorMovimentacoes(Carteira carteira) {
        Query q = getSimpleEntityManager().getSession().createQuery("Select c From MovimentacaoCarteira c WHERE c.carteira = :id ");
        q.setParameter("id",carteira.getId());
        @SuppressWarnings( "unchecked" )
        List<MovimentacaoCarteira> movimentacoes = q.list();
        double valorMov = 0;
        for (MovimentacaoCarteira movimentacaoCarteira : movimentacoes) {
            if(movimentacaoCarteira.getTipoMovimentacaoCarteria() == ETipoMovimentacaoCarteria.COMPRA) {
                valorMov += movimentacaoCarteira.getValorTotal();
            }
        }
        return valorMov;
    }

    @SuppressWarnings( "unchecked" )
    private double getValorMovimentacoesVenda(Carteira carteira) {
        Query q = getSimpleEntityManager().getSession().createQuery("Select c From MovimentacaoCarteira c WHERE c.carteira = :id ");
        q.setParameter("id",carteira.getId());
        List<MovimentacaoCarteira> movimentacoes = q.list();
        double valorMov = 0;
        for (MovimentacaoCarteira movimentacaoCarteira : movimentacoes) {
            if(movimentacaoCarteira.getTipoMovimentacaoCarteria() == ETipoMovimentacaoCarteria.VENDA) {
                valorMov += movimentacaoCarteira.getValorTotal();
            }
        }
        return valorMov;
    }

    @Override
    public Usuario findById(Long aLong) {
        return (Usuario) getSimpleEntityManager().getSession().load(getTypeOfT() , aLong);
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Usuario> findAll() {
        Query query = getSimpleEntityManager().getSession().createQuery("SELECT o FROM Usuario o");
        return query.list();
    }

    @Override
    public Usuario create(Usuario entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            entity = (Usuario) sess.save(entity);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        }
        return entity;
    }

    @Override
    public Usuario update(Usuario entity) {
        Transaction tx = null;
        try {
            Session sess = getSimpleEntityManager().getSession();
            tx = sess.beginTransaction();
            sess.update(entity);
            tx.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            tx.rollback();
        }
        return entity;
    }

    @Override
    public void flush(Usuario entity) {
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
    public Class<Usuario> getTypeOfT() {
        return Usuario.class;
    }

    @Override
    public SimpleEntityManager getSimpleEntityManager() {
        return this.simpleEntityManager;
    }
}
