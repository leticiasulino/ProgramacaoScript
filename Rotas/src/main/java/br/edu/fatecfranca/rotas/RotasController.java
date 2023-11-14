package br.edu.fatecfranca.rotas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class RotasController {
		@GetMapping
		public String boasVindas() {
			return "Seja bem-vindo!!!!";
	}

		@GetMapping("/(nome)")
		public String boasVindasNome(String nome) {
			return "Seja bem-vindo" + nome;
			
		}

}
