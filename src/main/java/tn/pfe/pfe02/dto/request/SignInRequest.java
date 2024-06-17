package tn.pfe.pfe02.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInRequest {
    private String email;
    private String password;
}
