CREATE VIEW SELECT_PRODUTO_COMPLETO
(
    ID,
    NOME,
    DESCRICAO,
    VALOR,
    ATIVO,
    DT_CADASTRO,
    ID_MARCA,
    NM_MARCA,
    ID_COLECAO,
    NM_COLECAO,
    PERC_DESCONTO
)
AS SELECT
    P.ID,
    P.NOME,
    P.DESCRICAO,
    P.VALOR,
    P.ATIVO,
    P.DT_CADASTRO,
    M.ID AS ID_MARCA,
    M.NOME AS NM_MARCA,
    C.ID AS ID_COLECAO,
    C.NOME AS NM_COLECAO,
    PROMO.PERC_DESCONTO
FROM PRODUTO P
    JOIN MARCA M ON M.ID = P.ID_MARCA
    JOIN COLECAO C ON C.ID = P.ID_COLECAO
    LEFT JOIN PROMOCAO PROMO ON PROMO.PRODUTO_ID = P.ID 
            AND (PROMO.DT_INICIO <= NOW() AND (PROMO.DT_FIM IS NULL OR PROMO.DT_FIM >= NOW()))