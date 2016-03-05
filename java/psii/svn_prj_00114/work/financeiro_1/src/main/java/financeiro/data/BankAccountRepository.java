package financeiro.data;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import financeiro.data.resources.MainEMResolver;
import financeiro.domain.model.BankAccount;

@ApplicationScoped
@Repository
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface BankAccountRepository extends
		EntityRepository<BankAccount, Long>, EntityManagerDelegate<BankAccount> {

}
