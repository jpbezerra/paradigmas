transformarChar :: Char -> Int
transformarChar '0' = 0
transformarChar '1' = 1
transformarChar _   = 0

btoi :: String -> Int
btoi ""     = 0
btoi (a:as) = ((transformarChar a) * (2 ^ (length  as))) + btoi as

main = do
    s <- getLine
    let result = btoi s
    print result