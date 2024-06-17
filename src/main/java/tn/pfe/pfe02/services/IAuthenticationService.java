package tn.pfe.pfe02.services;


import tn.pfe.pfe02.dto.request.SignInRequest;
import tn.pfe.pfe02.dto.request.SignUpRequest;
import tn.pfe.pfe02.dto.response.JwtAuthenticationResponse;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
