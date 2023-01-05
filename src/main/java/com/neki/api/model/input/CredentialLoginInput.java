package com.neki.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
public class CredentialLoginInput {

  @ApiModelProperty(example = "usuarioLogin")
  private String login;

  @ApiModelProperty(example = "123456")
  private String password;

  @UpdateTimestamp
  @ApiModelProperty(example = "2023-01-04")
  private Date lastLoginDate;
}
