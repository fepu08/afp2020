package hu.uni.eku.tzs.dao.entity;

import hu.uni.eku.tzs.model.Transaction;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="slide")
public class SlideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int price;

    @OneToMany(mappedBy = "slide")
    private Collection<UsageEntity> usage;
}
