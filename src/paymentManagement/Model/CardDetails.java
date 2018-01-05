package paymentManagement.Model;

import memberManagement.service.Member;

import javax.persistence.*;

/**
 * Created by sheebanshaikh on 8/13/16.
 */


@Entity
public class CardDetails {

    @Id
    @GeneratedValue
    private Long cardDetailsId;

    @Column
    private Integer cardNumber;

    @Column
    private PaymentType paymentType;

    @OneToOne
    private Member member;

    @Column
    private String expirationDate;

    public CardDetails(Integer cardNumber, PaymentType paymentType, Member member, String expirationDate) {
        this.cardNumber = cardNumber;
        this.paymentType = paymentType;
        this.member = member;
        this.expirationDate = expirationDate;
    }

    public CardDetails() {
    }

    public Long getCardDetailsId() {
        return cardDetailsId;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Member getMember() {
        return member;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
