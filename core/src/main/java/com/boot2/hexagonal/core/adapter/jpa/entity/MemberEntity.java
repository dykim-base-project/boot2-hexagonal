package com.boot2.hexagonal.core.adapter.jpa.entity;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberStatus;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "member")
public class MemberEntity {

  @Comment("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("이메일 주소")
  @Column(unique = true, nullable = false, length = EmailAddress.MAX_LENGTH)
  private String emailAddress;

  @Comment("이메일 검증 여부")
  private boolean emailValidated;

  @Comment("비밀번호")
  private String password;

  @Comment("이름")
  private String name;

  @Comment("상태")
  @Enumerated(EnumType.STRING)
  private MemberStatus status;

  @Comment("생성 일시")
  @Column(nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime createdAt;

  @Comment("수정 일시")
  @Column(nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime modifiedAt;
}
