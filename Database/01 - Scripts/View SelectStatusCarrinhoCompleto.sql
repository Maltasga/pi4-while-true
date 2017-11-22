CREATE VIEW SELECT_STATUS_CARRINHO_COMPLETO
(
    ID,
    STATUS_ID,
    CARRINHO_ID,
    DT_CADASTRO,
    STATUS,
    NOME
)
AS SELECT 
SD.ID,
SD.STATUS_ID,
SD.CARRINHO_ID,
SD.DT_CADASTRO,
S.STATUS,
C.NOME
FROM StatusCarrinhoDetalhe SD
LEFT JOIN StatusCarrinho S ON S.STATUS_ID = SD.STATUS_ID
INNER JOIN Carrinho CR ON CR.ID = SD.CARRINHO_ID
INNER JOIN Cliente C ON C.ID = CR.CLIENTE_ID