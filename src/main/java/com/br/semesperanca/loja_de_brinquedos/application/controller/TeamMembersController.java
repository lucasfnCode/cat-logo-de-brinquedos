package com.br.semesperanca.loja_de_brinquedos.application.controller;

import com.br.semesperanca.loja_de_brinquedos.domain.entity.TeamMembers;
import com.br.semesperanca.loja_de_brinquedos.domain.service.TeamMembersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teammembers")
public class TeamMembersController {

    private final TeamMembersService teamMembersService;

    public TeamMembersController(TeamMembersService teamMembersService) {
        this.teamMembersService = teamMembersService;
    }

    @PostMapping
    public TeamMembers saveTeamMembers(@RequestBody TeamMembers teamMembers) {
        return teamMembersService.saveTeamMembers(teamMembers);
    }

    @GetMapping
    public ResponseEntity<List<TeamMembers>> getAllTeamMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(teamMembersService.getAllTeamMembers());
    }
}
