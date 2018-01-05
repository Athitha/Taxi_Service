package memberManagement.models;

import memberManagement.service.Member;

import javax.persistence.*;

/**
 * Created by sheebanshaikh on 8/12/16.
 */

@Entity
public class MemberDetails {

    @Id
    @GeneratedValue
    private Long memberId;

    @Column
    private String name;

    @Column
    private MemberType memberType;

    @Column
    private String emailId;

    @Column
    private String password;

    @OneToOne
    private Member member;

    @Column
    private MembershipType membershipType;

    public MemberDetails(String name, String emailId, String password, MemberType memberType, MembershipType membershipType) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.memberType = memberType;
        this.membershipType = membershipType;
    }

    public MemberDetails(){

    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberType getMemberType() {
        return memberType;
    }
}
