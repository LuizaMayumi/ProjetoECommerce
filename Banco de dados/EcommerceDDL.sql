
CREATE SCHEMA ecommerce;

CREATE TABLE ecommerce.cliente (cliente_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
						nome_completo TEXT NOT NULL,
						email TEXT NOT NULL,
						senha TEXT NOT NULL,
						telefone TEXT,
						data_cadastro DATE);
						
CREATE TABLE ecommerce.pagamento (pagamento_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
						status TEXT NOT NULL,
						forma_pagamento TEXT NOT NULL,
						data_pagamento TIMESTAMPTZ);

CREATE TABLE ecommerce.produto (produto_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
						nome_produto TEXT NOT NULL,
						descricao TEXT NOT NULL,
						preco NUMERIC(18,2) NOT NULL,
						estoque_disponivel INT NOT NULL,
						imagem_url TEXT);

CREATE TABLE ecommerce.pedido(pedido_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
					data_pedido TIMESTAMPTZ NOT NULL,
					valor_total NUMERIC(18,3) NOT NULL,
					status TEXT NOT NULL,
					pagamento_id INT NOT NULL,
					FOREIGN KEY (pagamento_id) REFERENCES ecommerce.pagamento(pagamento_id),
					cliente_id INT NOT NULL REFERENCES ecommerce.cliente(cliente_id));

CREATE TABLE ecommerce.item_pedido (item_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
							quantidade INT NOT NULL,
							pedido_id INT NOT NULL REFERENCES ecommerce.pedido(pedido_id),
							produto_id INT NOT NULL REFERENCES ecommerce.produto(produto_id));

DROP TABLE item_pedido;