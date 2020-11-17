package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

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

    @Column
    private String slideName;

    @OneToMany(mappedBy = "slide", orphanRemoval = true)
    private Collection<UsageEntity> usage;
}
