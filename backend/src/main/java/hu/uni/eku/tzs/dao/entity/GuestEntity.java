package hu.uni.eku.tzs.dao.entity;

import hu.uni.eku.tzs.model.Transaction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private LocalDateTime arrivalDateTime;

    @Column
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(referencedColumnName = "id")
    private WatchEntity watch;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private TransactionEntity transaction;
}
