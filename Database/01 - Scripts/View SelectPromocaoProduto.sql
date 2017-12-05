CREATE VIEW SELECT_PROMOCAO_PRODUTO
(
    PRODUTO_ID
    , PRODUTO_NOME
    , PROMO_ID
    , DT_INICIO
    , DT_FIM
    , PERC_DESCONTO
)
AS 
(
    SELECT
        prod.ID AS 'PRODUTO_ID',
        prod.NOME as 'PRODUTO_NOME',
        promo.ID AS 'PROMO_ID',
        promo.DT_INICIO,
        promo.DT_FIM,
        promo.PERC_DESCONTO
    FROM produto prod
    LEFT JOIN promocao promo on promo.PRODUTO_ID = prod.ID
    ORDER BY promo.ID DESC
);