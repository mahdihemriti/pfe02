package tn.pfe.pfe02.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtAuthenticationResponse {
    private String token;
    private long expiresIn;
}
