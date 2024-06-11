package jp.co.creambakery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**-- クレカ情報の登録
*CREATE TABLE credit_card (
*	id INTEGER PRIMARY KEY,
*	owner INTEGER REFERENCES customer(id) NOT NULL,
*	name VARCHAR2(32 CHAR) NOT NULL,
*	holder_name VARCHAR2(64) NOT NULL,
*	no VARCHAR2(16) NOT NULL,
*	cvc VARCHAR2(3) NOT NULL
*);
*/

@Entity
@Table(name = "credit_card")
public class CreditCard 
{
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Customer owner;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private String no;

    @Column(nullable = false)
    private String cvc;


    public Integer getId() {
        return id;
    }

    public Customer getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNo() {
        return no;
    }

    public String getCvc() {
        return cvc;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

}
