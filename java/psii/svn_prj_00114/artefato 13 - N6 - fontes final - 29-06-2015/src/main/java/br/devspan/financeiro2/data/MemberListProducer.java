package br.devspan.financeiro2.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.devspan.financeiro2.model.Member;
import br.devspan.financeiro2.service.MemberRepository;

@RequestScoped
public class MemberListProducer {

    @Inject
    private MemberRepository memberRepository;

    private List<Member> members;

    @Produces
    @Named
    public List<Member> getMembers() {
        return members;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Member member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
        members = memberRepository.findAllOrderedByName();
    }
}
