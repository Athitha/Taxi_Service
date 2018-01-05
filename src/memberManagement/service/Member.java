package memberManagement.service;

import memberManagement.models.MemberDetails;
import memberManagement.models.MemberType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by AAnantharamu on 8/14/16.
 */

@Component
public abstract class Member {

    private Long memberId;

    private MemberType memberType;

    public abstract Boolean addOrUpdateMember(MemberDetails memberDetails);
    public abstract void deleteMember(MemberDetails memberDetails);
    public abstract MemberDetails findMember(Long memberID);
    public abstract List<Member> getMemberDetails();

}
