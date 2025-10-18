data Expr = Lit Int       |
            Add Expr Expr |
            Sub Expr Expr

eval :: Expr -> Int
eval (Lit n)     = n
eval (Add e1 e2) = (eval e1) + (eval e2)
eval (Sub e1 e2) = (eval e1) - (eval e2)

data List t = Nil | Cons t (List t)
              deriving (Show)

data Tree t = NilT |
              Node t (Tree t) (Tree t)
              deriving (Eq, Show)

showExpr :: Expr -> String
showExpr (Lit n)     = show n
showExpr (Add e1 e2) = "(" ++ (showExpr e1) ++ " + " ++ (showExpr e2) ++ ")"
showExpr (Sub e1 e2) = "(" ++ (showExpr e1) ++ " - " ++ (showExpr e2) ++ ")"

toList :: List t -> [t]
toList Nil         = []
toList (Cons x xs) = x : (toList xs)

fromList :: [t] -> List t
fromList []     = Nil
fromList (x:xs) = Cons x (fromList xs)

depth :: Tree t -> Int
depth NilT         = 0
depth (Node _ l r) = 1 + max (depth l) (depth r)

collapse :: Tree t -> [t]
collapse NilT         = []
collapse (Node x l r) = (collapse l) ++ (collapse r) ++ [x]

mapTree :: (t -> u) -> Tree t -> Tree u
mapTree _ NilT         = NilT
mapTree f (Node x l r) = Node (f x) (mapTree f l) (mapTree f r)

main :: IO ()
main = do
    let expr = Add (Lit 3) (Sub (Lit 5) (Lit 2))
    putStrLn $ "Expressão: " ++ showExpr expr
    putStrLn $ "Avaliação: " ++ show (eval expr)

    let lst = Cons 1 (Cons 2 (Cons 3 Nil))
    putStrLn $ "Lista personalizada para lista padrão: " ++ show (toList lst)
    putStrLn $ "Lista padrão para lista personalizada: " ++ show (fromList [1,2,3] :: List Int)

    let tree = Node 1 (Node 2 NilT (Node 3 NilT NilT)) (Node 4 NilT NilT)
    putStrLn $ "Profundidade da árvore: " ++ show (depth tree)
    putStrLn $ "Colapsar árvore em lista: " ++ show (collapse tree)
    putStrLn $ "Mapear função (+1) na árvore: " ++ show (mapTree (+1) tree)