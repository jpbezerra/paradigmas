bSort :: [String] -> [String]
bSort [] = []
bSort (a:as) = 
    let smallSort = bSort [x | x <- as, x <=a]
        bigSort   = bSort [x | x <- as, x > a]
    in smallSort ++ [a] ++ bigSort

main = do
       a <- getLine
       let result = bSort (read a :: [String])
       print result