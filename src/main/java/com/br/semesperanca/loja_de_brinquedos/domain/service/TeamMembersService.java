package com.br.semesperanca.loja_de_brinquedos.domain.service;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.TeamMembers;
import com.br.semesperanca.loja_de_brinquedos.domain.repository.TeamMembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMembersService {

    private final TeamMembersRepository teamMembersRepository;

    public TeamMembersService(TeamMembersRepository teamMembersRepository) {
        this.teamMembersRepository = teamMembersRepository;
    }

    public TeamMembers saveTeamMembers(TeamMembers teamMembers) {
        return teamMembersRepository.save(teamMembers);
    }

    public List<TeamMembers> getAllTeamMembers() {
        return teamMembersRepository.findAll();
    }
}
