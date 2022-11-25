package com.noturaun.shorty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "url")
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "shortened")
    private String shortened;

    @Column(name = "created_at")
    @JsonProperty(value = "created_at")
    private Date createdAt;

    @Column(name = "expires_at")
    @JsonProperty(value = "expires_at")
    private Date expiresAt;

}
