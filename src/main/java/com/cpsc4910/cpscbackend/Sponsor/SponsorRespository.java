package com.cpsc4910.cpscbackend.Sponsor;

import org.springframework.data.repository.CrudRepository;

public interface SponsorRespository extends CrudRepository<Sponsor, Long> {
    public Sponsor findByEmail(String email);
}
