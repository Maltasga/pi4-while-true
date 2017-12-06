delimiter //
CREATE PROCEDURE select_produto_por_categoria(IN id INT)
BEGIN
    SELECT * FROM Produto WHERE ID_CATEGORIA = id;
END//

delimiter ;