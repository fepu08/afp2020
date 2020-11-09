package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="bills")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private UUID watchID;

    @Column
    private int finalPrice;

    @Column
    private LocalDateTime date;

    @OneToOne(mappedBy = "bill")
    private TransactionEntity transaction;
}
