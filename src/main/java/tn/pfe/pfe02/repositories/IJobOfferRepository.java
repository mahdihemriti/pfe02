package tn.pfe.pfe02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.pfe02.entities.JobOffer;
import tn.pfe.pfe02.entities.User;
@Repository
public interface IJobOfferRepository extends JpaRepository<JobOffer,Integer> {
}
