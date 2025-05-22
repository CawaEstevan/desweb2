package com.example.pratica3.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.pratica3.model.Veiculo;
import com.example.pratica3.service.VeiculoService;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/veiculos")
public class VeiculoWebController {
    
    private final VeiculoService veiculoService;
    
    public VeiculoWebController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
    
    // Redireciona para listagem
    @GetMapping
    public String index() {
        return "redirect:/veiculos/listar";
    }
    
    // Página de cadastro
    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "veiculos/form";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(
            @Valid @ModelAttribute("veiculo") Veiculo veiculo,
            BindingResult result,
            RedirectAttributes ra) {
        
        if (result.hasErrors()) {
            return "veiculos/form";
        }
        
        veiculoService.salvarVeiculo(veiculo);
        ra.addFlashAttribute("success", "Veículo cadastrado com sucesso!");
        return "redirect:/veiculos/listar";
    }
    
    // Página de listagem
    @GetMapping("/listar")
    public String listarVeiculos(Model model) {
        model.addAttribute("lista", veiculoService.listarVeiculos());
        return "veiculos/lista";
    }
    
    // Detalhes e exclusão
    @GetMapping("/{id}")
    public String detalhesVeiculo(@PathVariable Long id, Model model) {
        Veiculo v = veiculoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Veículo não encontrado, id: " + id
                ));
        model.addAttribute("veiculo", v);
        return "veiculos/detalhe";
    }
    
    @PostMapping("/{id}/excluir")
    public String excluirVeiculo(@PathVariable Long id, RedirectAttributes ra) {
        veiculoService.deletarVeiculo(id);
        ra.addFlashAttribute("success", "Veículo excluído com sucesso!");
        return "redirect:/veiculos/listar";
    }
}