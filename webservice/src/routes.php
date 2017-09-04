<?php
// Routes

$app->get('/[{name}]', function ($request, $response, $args) {
    // Sample log message
    $this->logger->info("Slim-Skeleton '/' route");

    // Render index view
    return $this->renderer->render($response, 'index.phtml', $args);
});

$app->get('/livro/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM livro') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

$app->post('/livro/new', function($request, $response){
	
	$db = $this->db;
	$sth = $db->prepare("INSERT INTO livro (titulo, autor, paginas_total, paginas_lida, paginas_faltando, status) VALUES (:titulo, :autor, :paginas_total, :paginas_lida, :paginas_faltando, :status)");

	$dados = $request->getParsedBody();

	$insertFuncionario["titulo"] = $dados["titulo"];
	$insertFuncionario["autor"] = $dados["autor"];
	$insertFuncionario["paginas_total"] = $dados["paginas_total"];
	$insertFuncionario["paginas_lida"] = $dados["paginas_lida"];
	$insertFuncionario["paginas_faltando"] = $dados["paginas_faltando"];
	$insertFuncionario["status"] = $dados["status"];
	
	$sth->execute($insertFuncionario);
	
	return $response->withJson($insertFuncionario); 
});

$app->post('/livro/update/', function($request, $response){
	
	$db = $this->db;
	$sth = $db->prepare("UPDATE livro 
						SET paginas_lida = :paginas_lida, paginas_faltando = :paginas_faltando, status = :status 
						WHERE n_livro = :n_livro;");

	$dados = $request->getParsedBody();

	$insertFuncionario["n_livro"] = $dados["n_livro"];
	$insertFuncionario["paginas_faltando"] = $dados["paginas_faltando"];
	$insertFuncionario["paginas_lida"] = $dados["paginas_lida"];
	$insertFuncionario["status"] = $dados["status"];s
	
	$sth->execute($insertFuncionario);
	
	return $response->withJson($insertFuncionario); 
});