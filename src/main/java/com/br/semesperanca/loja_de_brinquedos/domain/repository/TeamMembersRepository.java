package com.br.semesperanca.loja_de_brinquedos.domain.repository;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {
}
