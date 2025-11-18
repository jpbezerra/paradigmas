addEspacos :: Int -> String
addEspacos n | n /= 0 = " " ++ addEspacos (n-1)
             | otherwise = ""

paraDireita :: Int -> String -> String
paraDireita n s = addEspacos n ++ s

totalVendas :: Int -> Int
totalVendas 0 = vendas 0
totalVendas n = totalVendas (n-1) + vendas n

maxVendas :: Int -> Int
maxVendas 0 = vendas 0
maxVendas n = max (maxVendas (n-1)) (vendas n)

vendas :: Int -> Int
vendas 0 = 10
vendas 1 = 20
vendas 2 = 25
vendas 3 = 10
vendas 4 = 10
vendas 5 = 25
vendas n = 0

cabecalho :: String
cabecalho = "Semana" ++ addEspacos 2 ++ "Vendas" ++ "\n"

mediaVendas :: Int -> Float
mediaVendas 0 = fromIntegral (vendas 0)
mediaVendas n = fromIntegral (totalVendas n) / fromIntegral (n + 1)

imprimeTotal :: Int -> String
imprimeTotal n = "Total" ++ addEspacos 3 ++ show(totalVendas n) ++ "\n"

imprimeMedia :: Int -> String
imprimeMedia n = "Média" ++ addEspacos 3 ++ show(mediaVendas n) ++ "\n"

imprimeSemanas :: Int -> String
imprimeSemanas 0 = addEspacos 2 ++ "0" ++ addEspacos 7 ++ show(vendas 0) ++ "\n"
imprimeSemanas n = imprimeSemanas(n-1) ++ addEspacos 2 ++ show(n) ++ addEspacos 7 ++ show(vendas n) ++ "\n"

imprimeTabela :: Int -> IO ()
imprimeTabela n = putStr(
    cabecalho
    ++ imprimeSemanas n
    ++ imprimeTotal n
    ++ imprimeMedia n)

main :: IO ()
main = imprimeTabela 5