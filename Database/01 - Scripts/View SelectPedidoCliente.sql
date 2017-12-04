CREATE VIEW SELECT_PEDIDO_CLIENTE
(
    ID_COMPRA,
    PROTOCOLO,
    CLIENTE_ID,
    STATUS,
    DT_CADASTRO
)
AS
SELECT
    c.ID AS ID_COMPRA,
    c.PROTOCOLO,
    ct.id,
    s.STATUS,
    sc.DT_CADASTRO
FROM carrinho c
INNER JOIN carrinhoitem ci ON ci.CARRINHO_ID = c.ID
INNER JOIN statusCarrinhoDetalhe sc on sc.CARRINHO_ID = c.ID
INNER JOIN statusCarrinho s on s.STATUS_ID = sc.STATUS_ID
INNER JOIN cliente ct ON ct.ID = c.CLIENTE_ID
