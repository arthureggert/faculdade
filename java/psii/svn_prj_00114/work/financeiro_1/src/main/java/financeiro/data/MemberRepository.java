package financeiro.data;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.apache.deltaspike.data.api.*;
import financeiro.data.resources.MainEMResolver;
import financeiro.domain.model.Member;

@ApplicationScoped
@Repository
@EntityManagerConfig(entityManagerResolver = MainEMResolver.class)
public interface MemberRepository extends EntityRepository<Member, Long>, EntityManagerDelegate<Member> {

    public List<Member> findByEmail(String email);

    public List<Member> findByLastNameLike(String lastName);

    @Query("select e from Member e where e.firstName like :part or e.lastName like :part")
    public List<Member> findByPartOfName(@QueryParam("part") String partOfName);

}
