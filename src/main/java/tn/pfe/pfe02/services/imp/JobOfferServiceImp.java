package tn.pfe.pfe02.services.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.entities.JobOffer;
import tn.pfe.pfe02.generic.IGenericServiceImp;
import tn.pfe.pfe02.services.IJobOfferService;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JobOfferServiceImp extends IGenericServiceImp<JobOffer,Integer> implements IJobOfferService {
}
