package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="usages")
public class UsageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int guestId;

    @Column
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", nullable = false)
    private TransactionEntity transaction;

    @ManyToOne
    @JoinColumn(name = "slide_id", referencedColumnName = "id")
    private SlideEntity slide;
}
