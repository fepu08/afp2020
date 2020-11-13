package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="bill_Items")
public class BillItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int slideID;

    @Column
    private int slidePrice;

    @Column
    private int counter;

    @Column
    private int slideFinalPrice;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private BillEntity bill;
}
