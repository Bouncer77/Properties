package pro.kosenkov.properties.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weapon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private long startDate;

    @Column(name = "end_date")
    private long endDate;

}
