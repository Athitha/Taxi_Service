package paymentManagement.Model;

import memberManagement.service.Member;

import javax.persistence.*;

/**
 * Created by sheebanshaikh on 8/14/16.
 */

@Entity
public class MemberPayment {

    @Id
    @GeneratedValue
    private Long memberPaymentId;

    @OneToOne
    private Member member;

    @OneToOne
    private CardDetails cardDetails;

    @Column
    private Double amount;

    public MemberPayment(Member member, CardDetails cardDetails, Double amount) {
        this.member = member;
        this.cardDetails = cardDetails;
        this.amount = amount;
    }

    public Long getMemberPaymentId() {
        return memberPaymentId;
    }

    public void setMemberPaymentId(Long memberPaymentId) {
        this.memberPaymentId = memberPaymentId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
