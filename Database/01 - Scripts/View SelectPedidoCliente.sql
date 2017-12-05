CREATE VIEW SELECT_PEDIDO_CLIENTE
(
    CARRINHO_ID,
    PROTOCOLO,
    DT_COMPRA,
    CLIENTE_ID,
    STATUS,
    DT_ATUALIZACAO_STATUS
)
AS
(
SELECT
    c.ID AS CARRINHO_ID,
    c.PROTOCOLO,
    c.DT_TRANSACAO AS DT_COMPRA,
    ct.ID AS CLIENTE_ID,
    s.STATUS,
    sc.DT_CADASTRO AS DT_ATUALIZACAO_STATUS
FROM carrinho c
INNER JOIN statusCarrinhoDetalhe sc on sc.CARRINHO_ID = c.ID
INNER JOIN statusCarrinho s on s.STATUS_ID = sc.STATUS_ID
INNER JOIN cliente ct ON ct.ID = c.CLIENTE_ID
);