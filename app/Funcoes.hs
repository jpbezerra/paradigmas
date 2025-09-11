module Funcoes where

{- recebe um n e retorna o numero de vendas do dia n, 
sendo que o numero de vendas do dia n é n mod 7 -}
vendas :: Int -> Int
vendas n = n `mod` 7

{- recebe um numero s e um n e retorna quantos dias
entre 0 e n tiveram exatamente s vendas -}
equalVendas :: Int -> Int -> Int

-- caso base: n = 0
equalVendas s 0
    | vendas 0 == s = 1 -- se o dia 0 teve s vendas, conta 1
    | otherwise     = 0 -- se o dia 0 nao teve s vendas, conta 0

-- caso recursivo: n > 0
equalVendas s n
    | vendas n == s = 1 + equalVendas s (n - 1) -- se o dia n teve s vendas, conta 1 + recursao
    | otherwise     = equalVendas s (n - 1) -- se o dia n nao teve s vendas, conta 0 + recursao

{- recebe um n e retorna True se n é primo, False caso contrário -}
isPrime :: Int -> Bool
isPrime 1 = False
isPrime n = testaPrimo (n-1) n
    where   testaPrimo 1 n = True
            testaPrimo aux n 
                | n `mod` aux == 0 = False
                | otherwise        = testaPrimo (aux-1) n

{- recebe dois numeros a e b e retorna True se eles são primos entre si, False caso contrário -}
primosEntreSi :: Int -> Int -> Bool
primosEntreSi a b = meuGcd a b == 1
    where   meuGcd :: Int -> Int -> Int
            meuGcd x 0 = x
            meuGcd x y = meuGcd y (x `mod` y)

{- recebe um n e retorna o fatorial de n -}            
fat :: Int -> Int
fat 0 = 1
fat 1 = 1
fat n = n * fat(n-1)

{- recebe quatro numeros e retorna True se todos sao iguais, False caso contrario -}
allEqual :: Int -> Int -> Int -> Int -> Bool
allEqual a b c d = (a == b) && (a == c) && (a == d) && (b == c) && (b == d) && (c == d)

{- recebe tres numeros e retorna quantos sao iguais entre si -}
equalCount :: Int -> Int -> Int -> Int
equalCount a b c
    | a == b = count + 1
    | a == c = count + 1
    | b == c = count + 1
    | otherwise = count
    where count = 0

-- exemplos de uso:
main :: IO ()
main = do
    putStrLn (show (vendas 10)) -- deve retornar 3
    putStrLn (show (equalVendas 3 10)) -- deve retornar 2
    putStrLn (show (isPrime 7)) -- deve retornar True
    putStrLn (show (primosEntreSi 10 15)) -- deve retornar False
    putStrLn (show (fat 5)) -- deve retornar 120
    putStrLn (show (allEqual 1 1 1 1)) -- deve retornar True
    putStrLn (show (equalCount 1 2 3)) -- deve retornar 0