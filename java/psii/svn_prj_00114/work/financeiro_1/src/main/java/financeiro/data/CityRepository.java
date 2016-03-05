package financeiro.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import financeiro.data.resources.MainEMResolver;
import financeiro.domain.model.City;

@ApplicationScoped
@Repository
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface CityRepository extends EntityRepository<City, Long>, EntityManagerDelegate<City> {

    public List<City> findByName(String name);

}
