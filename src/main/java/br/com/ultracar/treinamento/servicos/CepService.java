package br.com.ultracar.treinamento.servicos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.ultracar.treinamento.entidades.Bairro;
import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.entidades.Estado;
import br.com.ultracar.treinamento.entidades.dto.EnderecoDTO;
import br.com.ultracar.treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	

//	public Cep findCepByEndereco(String codigoPostal) {
//		Cep cep = this.repositorio.findCepByEndereco(codigoPostal);
//		return cep != null ? cep : findCepByApi(codigoPostal);
//	}

	public Cep findCepByEndereco(String codigoPostal) {
		Cep cep = this.repositorio.findCepByEndereco(codigoPostal);
			return cep != null ? cep : findCepByApi(codigoPostal);
	}
	

	public Cep findCepByApi(String codigoPostal) {

		Cep cepApi = new Cep();
		RestTemplate restTemplate = new RestTemplate();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", codigoPostal);

		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		
	
		if (!Objects.isNull(enderecoDTO)) {
			Estado estado = estadoService.findByUf(enderecoDTO.getUf());
			Cidade cidade = cidadeService.findByNomeExato(enderecoDTO.getLocalidade());
			Set<Bairro> bairros = new HashSet<Bairro>();
			
			cepApi = saveCep(enderecoDTO, codigoPostal);
		}
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		//this.repositorio.findCepByEndereco(codigoPostal)

		return cepApi;

	}
	
	private Cep saveCep(EnderecoDTO enderecoDTO, String codigoPostal) {
		Cep cepSaveApi = new Cep();
		
		return cepSaveApi;
	}

	public Page<Cep> findAllCep(Cep cep, Pageable pageable) {
		return this.repositorio.findAllCep(cep, pageable);
	}

}
