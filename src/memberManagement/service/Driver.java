package memberManagement.service;

import memberManagement.models.MemberDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sheebanshaikh on 8/9/16.
 */

@Component
public class Driver extends Member {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean addOrUpdateMember(MemberDetails memberDetails) {
        if(!memberDetails.getMemberId().equals(null)) {
            entityManager.merge(memberDetails);
            return true;
        } else {
            entityManager.merge(memberDetails);
            return false;
        }
    }


    @Override
    public void deleteMember(MemberDetails memberDetails) {
        if(!memberDetails.getMemberId().equals(null)){
            memberDetails = entityManager.find(MemberDetails.class,memberDetails.getMemberId());
            entityManager.remove(memberDetails);
        }
    }

    @Override
    public MemberDetails findMember(Long memberID) {
        MemberDetails memberDetails = entityManager.find(MemberDetails.class,memberID);
        return memberDetails;
    }


    @Override
    public List<Member> getMemberDetails() {
        return null;
    }
}
