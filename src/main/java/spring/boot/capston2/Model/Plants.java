package spring.boot.capston2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plants")
public class Plants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotEmpty(message = "description shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String description;

    @NotEmpty(message = "lightRequirements shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String lightRequirements;

    @NotEmpty(message = "waterRequirements shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String waterRequirements;

    @NotEmpty(message = "temperatureRequirements shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String temperatureRequirements;

    @NotEmpty(message = "soilTypeRequirements shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String soilTypeRequirements;

    @NotEmpty(message = "plantingSeason shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String plantingSeason;

    @NotEmpty(message = "growthTime shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String growthTime; // String ??

    @NotEmpty(message = "category shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String category;

    @NotNull(message = "price shouldn't be null")
    @Column(columnDefinition = "double not null")
    private Double price;

    @PositiveOrZero
    @Column(columnDefinition = "int not null")
    private Integer stock;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "farmers_id" , referencedColumnName = "id")
    private Farmers farmers;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "nurseries_id" , referencedColumnName = "id")
    private Nurseries nurseries;
}
