package com.jh.car.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jh.car.model.Cliente;
import com.jh.car.model.Usuario;
import com.jh.car.repository.ClienteRepository;
import com.jh.car.security.UsuarioRepository;
import com.jh.car.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private UsuarioRepository usurepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	

	public List<Cliente> findAll() {

		return repo.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente client) throws Exception {

		// ******************** Consumindo uma API Externa CEP
		// *******************************

		// Metodo para adquirir url da API
		URL url = new URL("https://viacep.com.br/ws/" + client.getCep() + "/json/");

		// Abrindo conexão
		URLConnection connection = url.openConnection();
		// Realizando o metodo de obter de dados
		InputStream is = connection.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		String cep = "";
		StringBuilder jsoncep = new StringBuilder();

		// Lendo as linhas da API EXTERNA e passando para a variável
		while ((cep = br.readLine()) != null) {

			jsoncep.append(cep);

		}

		// Estou convertendo os dados de String para Json para serem utilizados.
		Cliente cliaux = new Gson().fromJson(jsoncep.toString(), Cliente.class);

		// Estou trazendo os dados convertidos para o método.
		client.setCep(cliaux.getCep());
		client.setLogradouro(cliaux.getLogradouro());
		client.setComplemento(cliaux.getComplemento());
		client.setBairro(cliaux.getBairro());
		client.setLocalidade(cliaux.getLocalidade());
		client.setUf(cliaux.getUf());

		// ******************** Consumindo uma API Externa CEP
		// *****************************
		client.setId(null);
		repo.save(client);

		
		// ****** Ao criar o cliente, irá inserir os dados de login e senha na tabela de usuarios ********
		
		Usuario usu = new Usuario();
		usu.setId(null);
		usu.setLogin(client.getLogin());
		String senhacripto = passwordEncoder.encode(client.getSenha());
		usu.setSenha(senhacripto);
		usurepo.save(usu);
		
		return client;
	}

	// metodo para atualizar os dados do cliente
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public void delete(Long id) {
		findById(id);
		repo.deleteById(id);
	}

}
