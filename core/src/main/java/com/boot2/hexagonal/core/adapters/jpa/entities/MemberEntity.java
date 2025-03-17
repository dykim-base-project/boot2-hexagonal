package com.boot2.hexagonal.core.adapters.jpa.entities;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.enums.MemberStatusKind;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import java.time.ZonedDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(
    name = "member",
    indexes = {@Index(name = "idx__sns_email_address", columnList = "sns_email_address")})
@org.hibernate.annotations.Table(appliesTo = "member", comment = "회원")
public class MemberEntity {

  @Comment("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("SNS 이메일 주소")
  @Column(
      name = "sns_email_address",
      nullable = false,
      updatable = false,
      length = EmailAddress.MAX_LENGTH)
  private String snsEmailAddress;

  @Comment("상태")
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = MemberStatusKind.LENGTH)
  private MemberStatusKind status;

  @Comment("생성 일시")
  @Column(nullable = false, updatable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime createdAt;

  @Comment("생성자 Id")
  @Column(nullable = false, updatable = false, length = WorkerId.MAX_LENGTH)
  private String creatorId;

  @Comment("수정 일시")
  @Column(nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime modifiedAt;

  @Comment("수정자 Id")
  @Column(nullable = false, length = WorkerId.MAX_LENGTH)
  private String modifierId;
}
