package com.boot2.hexagonal.core.adapters.jpa.entities;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.enums.EmailSendTypeKind;
import java.time.ZonedDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "email_send_history")
@org.hibernate.annotations.Table(appliesTo = "email_send_history", comment = "이메일 발신 이력")
public class EmailSendHistoryEntity {

  @Comment("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("전송 타입")
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = EmailSendTypeKind.LENGTH)
  private EmailSendTypeKind sendType;

  @Comment("발신자")
  @Column(nullable = false, length = EmailAddress.MAX_LENGTH)
  private String sender;

  @Comment("수신자")
  @Column(nullable = false, length = EmailAddress.MAX_LENGTH)
  private String recipient;

  @Comment("제목")
  @Column(nullable = false, length = 100)
  private String subject;

  @Comment("내용")
  @Column(nullable = false)
  private String body;

  @Comment("발신 일시")
  @Column(nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime sentAt;
}
