-- QUESTÃO 1

winner :: [Int] -> Int
winner votos = fst (maximo (contagem votos []) (0, 0))

maximo :: [(Int, Int)] -> (Int, Int) -> (Int, Int)
maximo [] num = num
maximo (a:as) num
    | snd a > snd num = maximo as a
    | otherwise       = maximo as num

contagem :: [Int] -> [(Int, Int)] -> [(Int, Int)]
contagem [] lista     = lista
contagem (a:as) lista = contagem as (remover a lista 0)

remover :: Int -> [(Int, Int)] -> Int -> [(Int, Int)]
remover num [] x = [(num, 1)]
remover num (a:as) x
    | num == fst a  = [(fst a, snd a+1)] ++ as
    | otherwise = [a] ++ remover num as x

-- QUESTÃO 2

unicos :: [Int] -> [Int]
unicos lista = parseUnicos lista []
    where
        parseUnicos :: [Int] -> [Int] -> [Int]
        parseUnicos [] lista = []
        parseUnicos (a:as) lista
            | existe a lista == True = parseUnicos as lista
            | otherwise              = [a] ++ parseUnicos as (lista ++ [a])

existe :: Int -> [Int] -> Bool
existe a [] = False
existe a (x:xs)
    | a == x    = True
    | otherwise = existe a xs

-- QUESTÃO 3

data ExpB = OR ExpB ExpB | AND ExpB ExpB | Not ExpB | Var Char
    deriving Show

vars :: ExpB -> [Char]
vars expression = parseExp expression []
    where
        parseExp :: ExpB -> [Char] -> [Char]
        parseExp (Var x) lista
            | contido lista x == False = lista ++ [x]
            | otherwise                = lista
        parseExp (Not exp) lista       = parseExp exp lista
        parseExp (AND a b) lista       = parseExp a (parse Exp b lista)
        parseExp (OR a b) lista        = parseExp a (parseExp b lista)

contido :: [Char] -> Char -> Bool
contido [] a    = False
contido (x:xs) a
    | a == x    = True
    | otherwise = contido xs a

-- QUESTÃO 4

eval :: [(Char, Bool)] -> ExpB -> Bool
eval values (Var x) = getValue x values
eval values (Not x)
    | eval values x == True = False
    | otherwise             = True
eval values (AND a b)
    | eval values a == True && eval values b == True   = True
    | otherwise                                        = False
eval values (OR a b)
    | eval values a == False && eval values b == False = False
    | otherwise                                        = True
    
getValue :: Char -> [(Char, Bool)] -> Bool
getValue a [] = False
getValue a (x:xs)
    | a == (fst x) = snd x
    | otherwise    = getValue a xs