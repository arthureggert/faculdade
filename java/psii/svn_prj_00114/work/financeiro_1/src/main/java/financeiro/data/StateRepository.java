package financeiro.data;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import financeiro.data.resources.MainEMResolver;
import financeiro.domain.model.State;

@ApplicationScoped
@Repository
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface StateRepository extends EntityRepository<State, Long>,
		EntityManagerDelegate<State> {

}
