package com.boot2.hexagonal.core.adapters.jpa.entities;

import com.boot2.hexagonal.api.data.enums.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(
    name = "authentication_history",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "uk__created_at__authentication_id",
          columnNames = {"created_at", "authentication_id"})
    })
@org.hibernate.annotations.Table(appliesTo = "authentication_history", comment = "인증 이력")
public class AuthenticationHistoryEntity {

  @Comment("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("인증 id")
  @Column(name = "authentication_id", nullable = false, length = AuthenticationId.MAX_LENGTH)
  private String authenticationId;

  @Comment("인증 타입")
  @Column(nullable = false, length = 20)
  private AuthenticationTypeKind type;

  @Comment("인증 여부")
  private boolean authenticated;

  @Comment("작업자 id")
  @Column(nullable = false, length = WorkerId.MAX_LENGTH)
  private String workerId;

  @Comment("생성 일시")
  @Column(name = "created_at", nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime createdAt;
}
