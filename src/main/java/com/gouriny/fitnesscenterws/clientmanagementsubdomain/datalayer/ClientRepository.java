package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findClientByClientIdentifier_ClientId(String clientId);
}
