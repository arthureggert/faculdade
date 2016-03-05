package br.com.ahe.desenvweb.src.br.edu.furb.agendamento.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hsqldb.Server;

import br.edu.furb.agendamento.authentication.PasswordUtil;
import br.edu.furb.agendamento.data.persistent.HibernateUtil;
import br.edu.furb.agendamento.data.persistent.Operacao;
import br.edu.furb.agendamento.data.persistent.Permissao;
import br.edu.furb.agendamento.data.persistent.Recurso;
import br.edu.furb.agendamento.data.persistent.Usuario;

/**
 * Controlar o acesso aos itens armazenados
 * 
 * @author Claor Bauer, Jo�o Maas
 * 
 */
public class DataStorage {

    private static DataStorage instance;
    public Server dbserver;

    private static Connection conn;

    private DataStorage() {
        // 1 SessionFactory para todas as threads, pois a concorr�encia �
        // pequena e o banco � .TXT
        // todo o acesso ao session deve ser sincronizado e usar o design
        // pattern SESSION PER REQUEST

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

    }

    public static synchronized DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    private SessionFactory factory;

    private Session session;

    public void openSession() {
        if (factory != null) {
            throw new RuntimeException("Just one session is allowed in this Java VM.");
        }
        try {
            HibernateUtil.checkDatabaseFiles();
            conn = DriverManager.getConnection("jdbc:hsqldb:file:" + HibernateUtil.getDatabaseDirectory() + "db", "sa", "");
        } catch (SQLException e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }

    private void shutdown() {
        try {
            conn.createStatement().execute("SHUTDOWN;");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void closeSession() {
        session.close();
        factory.close();
        factory = null;
        shutdown();
    }

    public Usuario createUsuario(Usuario entity) {
        Transaction trans = session.beginTransaction();
        try {
            String pass = PasswordUtil.byteArrayToHexString(PasswordUtil.stringToHash(entity.getPassword()));
            entity.setPassword(pass);
            Long id = (Long) session.save(entity);
            trans.commit();
            return (Usuario) session.load(Usuario.class, id);
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void destroyUsuario(long id) {
        Transaction trans = session.beginTransaction();
        try {
            Usuario usuario = (Usuario) session.load(Usuario.class, (long) id);
            //Destroy todas as permissoes
            Query q1 = session.createQuery("from Permissao p where p.usuario.id = :usuario_Id");
            q1.setParameter("usuario_Id", (long) usuario.getId());
            ArrayList<Permissao> permissoes = new ArrayList<Permissao>();
            // Altera��es feitas para que ao deletar o Wid ele realmente seja
            // deletado
            permissoes.addAll(q1.list());
            for (Permissao permissao : permissoes) {
                destroyPermissao(permissao.getId());
            }
            session.delete(usuario);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public Usuario getUsuario(String login) {
        Query q = session.createQuery("from Usuario e where e.login = :login");
        q.setParameter("login", login);
        Usuario entity = (Usuario) q.uniqueResult();
        return entity;
    }

    public List<Usuario> getAllUsuario() {
        Query q = session.createQuery("from Usuario e order by e.id asc");
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        list.addAll(q.list());
        return list;
    }

    public Recurso createRecurso(String nome, String tipo) {
        Transaction trans = session.beginTransaction();
        try {
            Recurso recurso = new Recurso();
            recurso.setNome(nome);
            recurso.setTipo(tipo);
            Long id = (Long) session.save(recurso);
            trans.commit();
            return (Recurso) session.load(Recurso.class, id);
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void destroyRecurso(long id) {
        Transaction trans = session.beginTransaction();
        try {
            Recurso recurso = (Recurso) session.load(Recurso.class, (long) id);
            Query q = session.createQuery("from Permissao p where p.recurso.id = :recurso_Id");
            q.setParameter("recurso_Id", (long) recurso.getId());
            ArrayList<Permissao> list = new ArrayList<Permissao>();
            // Altera��es feitas para que ao deletar o Wid ele realmente seja
            // deletado
            list.addAll(q.list());
            for (Permissao permissao : list) {
                destroyPermissao(permissao.getId());
            }
            session.delete(recurso);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public Recurso getRecurso(String nome) {
        Query q = session.createQuery("from Recurso r where r.nome = :nome");
        q.setParameter("nome", nome);
        Recurso recurso = (Recurso) q.uniqueResult();
        return recurso;
    }

    public List<Recurso> getAllRecurso() {
        Query q = session.createQuery("from Recurso r order by r.id asc");
        ArrayList<Recurso> list = new ArrayList<Recurso>();
        list.addAll(q.list());
        return list;
    }

    public Permissao createPermissao(String usuario, String recurso, Long operacao) {
        Transaction trans = session.beginTransaction();
        try {
            Permissao permissao = new Permissao();
            permissao.setUsuario(getUsuario(usuario));
            permissao.setOperacao(getOperacao(operacao));
            permissao.setRecurso(getRecurso(recurso));
            Long id = (Long) session.save(permissao);
            trans.commit();
            return (Permissao) session.load(Permissao.class, id);
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void destroyPermissao(long id) {
        Transaction trans = session.beginTransaction();
        try {
            Permissao permissao = (Permissao) session.load(Permissao.class, (long) id);
            session.delete(permissao);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public Permissao getPermissao(Long id) {
        return (Permissao) session.load(Permissao.class, id);
    }

    public List<Permissao> getAllPermissao() {
        Query q = session.createQuery("from Permissao p order by p.id asc");
        ArrayList<Permissao> list = new ArrayList<Permissao>();
        list.addAll(q.list());
        return list;
    }

    public List<Permissao> getAllPermissoesByUsuario(String usuario) {
        Query q = session.createQuery("from Permissao p where p.usuario.login = :usuario_login order by p.id asc");
        q.setParameter("usuario_login", usuario);
        ArrayList<Permissao> list = new ArrayList<Permissao>();
        list.addAll(q.list());
        return list;
    }

    public Operacao createOperacao(String nome) {
        Transaction trans = session.beginTransaction();
        try {
            Operacao operacao = new Operacao();
            operacao.setNome(nome);
            Long id = (Long) session.save(operacao);
            trans.commit();
            return (Operacao) session.load(Operacao.class, id);
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void destroyOperacao(long id) {
        Transaction trans = session.beginTransaction();
        try {
            Operacao operacao = (Operacao) session.load(Operacao.class, (long) id);
            Query q = session.createQuery("from Permissao p where p.operacao.id = :operacao_Id");
            q.setParameter("operacao_Id", (long) operacao.getId());
            ArrayList<Permissao> list = new ArrayList<Permissao>();
            list.addAll(q.list());
            for (Permissao permissao : list) {
                destroyPermissao(permissao.getId());
            }
            session.delete(operacao);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public Operacao getOperacao(Long id) {
        return (Operacao) session.load(Operacao.class, id);
    }

    public List<Operacao> getAllOperacao() {
        Query q = session.createQuery("from Operacao o order by o.id asc");
        ArrayList<Operacao> list = new ArrayList<Operacao>();
        list.addAll(q.list());
        return list;
    }
}
