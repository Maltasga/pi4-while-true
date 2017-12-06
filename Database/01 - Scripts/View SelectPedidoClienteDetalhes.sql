CREATE VIEW SELECT_PEDIDO_CLIENTE_DETALHES
(
    PRODUTO_ID,
    NOME_PRODUTO,
    VL_UNITARIO,
    DESCRICAO,
    QUANTIDADE,
    TAMANHO,
    CARRINHO_ID,
    DT_COMPRA,
    PROTOCOLO,
    NOME_CLIENTE
)
AS 
(
SELECT
    p.ID AS PRODUTO_ID,
    p.NOME AS NOME_PRODUTO,
    p.VALOR AS VL_UNITARIO,
    p.DESCRICAO,
    ci.QUANTIDADE,
    ci.TAMANHO,
    c.ID AS CARRINHO_ID,
    c.DT_TRANSACAO AS DT_COMPRA,
    c.PROTOCOLO,
    ct.NOME AS NOME_CLIENTE
FROM carrinho c
INNER JOIN carrinhoitem ci ON ci.CARRINHO_ID = c.ID
INNER JOIN cliente ct ON ct.ID = c.CLIENTE_ID
INNER JOIN produto p on p.ID = ci.PRODUTO_ID
);