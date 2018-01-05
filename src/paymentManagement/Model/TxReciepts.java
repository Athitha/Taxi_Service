package paymentManagement.Model;

import memberManagement.service.Member;

import javax.persistence.*;

/**
 * Created by AAnantharamu on 8/14/16.
 */

@Entity
public class TxReciepts {

    @Id
    @GeneratedValue
    private Long txRecieptId;

    @Column
    private Double amount;

    @OneToOne
    private Member member;

    public TxReciepts(Double amount, Member member) {
        this.amount = amount;
        this.member = member;
    }

    public Long getTxRccieptId() {
        return txRecieptId;
    }

    public Double getAmount() {
        return amount;
    }

    public Member getMember() {
        return member;
    }
}
