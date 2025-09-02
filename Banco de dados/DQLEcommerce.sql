SELECT * FROM ecommerce.cliente;
SELECT * FROM ecommerce.item_pedido;
SELECT * FROM ecommerce.pagamento;
SELECT * FROM ecommerce.pedido;
SELECT * FROM ecommerce.produto;

-- 1
SELECT pedido_id, nome_completo 
	FROM ecommerce.pedido AS p
	JOIN ecommerce.cliente AS c
	ON p.cliente_id = c.cliente_id;

-- 2
SELECT nome_produto 
	FROM ecommerce.produto AS p
	JOIN ecommerce.item_pedido AS i
	ON i.produto_id = p.produto_id
	WHERE i.pedido_id = 1;

-- 3