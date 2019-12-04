package br.com.ultracar.treinamento.servicos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.entidades.dto.EnderecoDTO;
import br.com.ultracar.treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;

//	public Cep findCepByEndereco(String codigoPostal) {
//		Cep cep = this.repositorio.findCepByEndereco(codigoPostal);
//		return cep != null ? cep : findCepByApi(codigoPostal);
//	}

	public Cep findCepByEndereco(String codigoPostal) {
		Cep cep = this.repositorio.findCepByEndereco(codigoPostal);
			return cep != null ? cep : findCepByApi(codigoPostal);
	}
	

	public Cep findCepByApi(String codigoPostal) {

		RestTemplate restTemplate = new RestTemplate();
		Endereco endereco = new Endereco();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", codigoPostal);

		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		
		endereco.setLogradouro(enderecoDTO.getLogradouro());

		return this.repositorio.findCepByEndereco(codigoPostal);

//		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + codigoPostal + "&formato=xml");
//        Document document = getDocumento(url);
//        Element root = document.getRootElement();
//        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
//            Element element = (Element) i.next();
//            if (element.getQualifiedName().equals("estado"))
//                setEstado(element.getText());                
//            if (element.getQualifiedName().equals("cidade"))
//                setCidade(element.getText());                
//            if (element.getQualifiedName().equals("bairro"))
//                setBairro(element.getText());                
//            if (element.getQualifiedName().equals("tipo_logradouro"))
//                setTipo_logradouro(element.getText());                
//            if (element.getQualifiedName().equals("logradouro"))
//                setLogradouro(element.getText());                
//            if (element.getQualifiedName().equals("resultado"))
//                setResultado(Integer.parseInt(element.getText()));                
//            if (element.getQualifiedName().equals("resultado_txt"))
//                setResultado_txt(element.getText());                                
//        }		

		// return cep;

	}

	public Page<Cep> findAllCep(Cep cep, Pageable pageable) {
		return this.repositorio.findAllCep(cep, pageable);
	}

}
