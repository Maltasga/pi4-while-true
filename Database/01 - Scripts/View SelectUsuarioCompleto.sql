CREATE VIEW SELECT_USUARIO_COMPLETO
(
    ID,
    NOME,
    EMAIL,
    LOGIN,
    SENHA,
    ATIVO,
    DT_CADASTRO,
    ID_PERFIL,
    NM_PERFIL
)
AS
(
    SELECT
        U.ID,
        U.NOME,
        U.EMAIL,
        U.LOGIN,
        U.SENHA,
        U.ATIVO,
        U.DT_CADASTRO,
        P.ID AS 'ID_PERFIL',
        P.NOME AS 'NM_PERFIL'
    FROM Usuario U
        JOIN Perfil P on P.ID = U.ID_PERFIL
);