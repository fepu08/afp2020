package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private int id;

    @Column
    private UUID watchID;

    @Column
    private UUID transactionID;

    @OneToMany(mappedBy = "bill")
    private List<BillItemEntity> items;

    @Column
    private int finalPrice;

    @Column
    private LocalDateTime date;
}
