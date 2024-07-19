package tn.pfe.pfe02.services.imp;

import jakarta.annotation.PostConstruct;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.repositories.IUserRepository;

import java.util.List;

@Service
public class UserSynchronizationService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IdentityService identityService;


   /* @PostConstruct
    public void synchronizeUsers() {
        List<User> users = userRepository.findAll();
        for (User appUser : users) {
            // Vérifiez d'abord si l'utilisateur existe déjà dans Camunda
            org.camunda.bpm.engine.identity.User camundaUser = identityService.createUserQuery().userId(appUser.getEmail()).singleResult();
            if (camundaUser == null) {
                // Créer un nouvel utilisateur dans Camunda
                camundaUser = identityService.newUser(appUser.getEmail());
            }
                camundaUser.setFirstName(appUser.getFirstName());
                camundaUser.setLastName(appUser.getLastName());
                camundaUser.setEmail(appUser.getEmail());
                camundaUser.setPassword(appUser.getPassword());
                identityService.saveUser(camundaUser);

            // Créer et assigner le rôle (groupe) à l'utilisateur
            String roleName = appUser.getRole().name();
            Group group = identityService.createGroupQuery().groupId(roleName).singleResult();
            if (group == null) {
                group = identityService.newGroup(roleName);
                group.setName(roleName);
                group.setType("WORKFLOW");
                identityService.saveGroup(group);
            }
            //identityService.createMembership(camundaUser.getId(), group.getId());
        }
    }*/
}
