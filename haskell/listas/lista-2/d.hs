data Tree t = Node t (Tree t) (Tree t) 
              | Nilt
              deriving (Read)
              
alturaArvore :: Tree t -> Int
alturaArvore Nilt = 0
alturaArvore (Node n l r) = 1 + max (alturaArvore l) (alturaArvore r)

main = do
       a <- getLine
       let result = alturaArvore (read a::Tree Int)
       print result       