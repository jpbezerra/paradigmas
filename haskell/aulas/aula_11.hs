type Chave = [(Char,Char)]

letras :: [Char]
letras = ['A'..'Z']

cria_chave :: Int -> Chave
cria_chave n = zip letras newLetras
    where
        newLetras = (drop n letras) ++ (take (26-n) letras)

crypt :: Chave -> String -> String
crypt keys []     = ""
crypt keys (a:as) = findKey keys a ++ crypt keys as
    where
        findKey :: Chave -> Char -> [Char]
        findKey keys ' '           = " "
        findKey (a:as) character
            | (fst a) == character = [snd a]
            | otherwise            = findKey as character

data ChaveTree = Node Char Char ChaveTree ChaveTree | Leaf
                deriving (Show, Eq)

chave_parcial :: ChaveTree
chave_parcial = Node 'I' 'L' (Node 'A' 'D' Leaf Leaf)
                (Node 'L' 'O' Leaf Leaf)

cryptT :: ChaveTree -> String -> String
cryptT keys [] = ""
cryptT keys (a:as) = findKey keys a ++ cryptT keys as
    where
        findKey :: ChaveTree -> Char -> [Char]
        findKey keys ' '       = " "
        findKey Leaf character = [character]
        findKey (Node old new leftTree rightTree) character
            | old == character = [new]
            | character < old  = findKey leftTree character
            | character > old  = findKey rightTree character
            | otherwise        = [character]

ctree_to_chave :: ChaveTree -> Chave
ctree_to_chave Leaf = []
ctree_to_chave (Node old new leftTree rightTree) = ctree_to_chave leftTree ++ [(old, new)] ++ ctree_to_chave rightTree

main :: IO ()
main = do
    print (cria_chave 3)
    putStrLn (crypt (cria_chave 3) "A LIGEIRA RAPOSA")
    putStrLn (cryptT chave_parcial "A LIGEIRA RAPOSA")
    print (ctree_to_chave chave_parcial)