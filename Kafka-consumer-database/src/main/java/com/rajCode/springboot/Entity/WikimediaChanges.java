package com.rajCode.springboot.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WikimediaChanges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob // due to huge data
    @Column(columnDefinition = "LONGTEXT")
    private String wiki_events;
}
