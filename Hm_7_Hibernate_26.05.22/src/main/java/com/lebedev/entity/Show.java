package com.lebedev.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NamedEntityGraph(
        name = "show-entity-graph",
        attributeNodes = {@NamedAttributeNode(value = "movie", subgraph = "movie-subgraph")},
        subgraphs = {@NamedSubgraph(name = "movie-subgraph",
                                    attributeNodes = {@NamedAttributeNode("genres")})}
)
@Entity
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "show_generator")
    @SequenceGenerator(name = "show_generator",
            sequenceName = "show_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "time_start")
    private LocalDateTime timeStart;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Show show = (Show) o;
        return id != null && Objects.equals(id, show.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
