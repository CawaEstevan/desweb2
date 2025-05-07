package com.example.projeto.controller;

import javax.naming.Binding;

import com.example.projeto.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaWebController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
    
    //Mapeia get/pessoas -> redireciona para/pessoas/listar
    @GetMapping
    public String index(){
        return "redirect:/pessoas/listar";
    }

    //1. Pagina de cadastro
    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas/form";
    }

    public String cadastrarPessoa(@Valid @ModelAttribute("pessoa") Pessoa pessoa,BindinResult result,RedirectAttributes ra){
        if(result.hasErros()){
            //repopula o objeto no formulario em caso de erro
            return "pessoas/form";
        }
        pessoaService.salvarPessoa(pessoa);
        ra.addFlashAttribute("sucess","Pessoa cadastrada com sucesso!");
        return "redirect:/pessoas/listar";
    }
}    