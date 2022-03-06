package com.github.niyaz000.taas.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "services")
@Data
@Accessors(fluent = true)
@EntityListeners(AuditingEntityListener.class)
@TypeDef(
        name = "json", typeClass = JsonType.class
)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, updatable = false)
  private String name;

  @Column(name = "config")
  @Type(type = "json")
  private Config config;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @Data
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Config {
    private Long maximumNumberOfAccounts;
    private Long maximumNumberOfTagsPerEntity;
    private Long minimumTagLength;
    private Long maximumTagLength;
    private boolean allowWildCardSearch;
    private boolean tagsImmutable;
    private boolean allowTagMerge;
    private boolean allowTagSplit;
  }

}
