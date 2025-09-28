isReplica :: String -> Int -> Char -> Bool
isReplica [] n c = n == 0
isReplica (s:ss) n c
    | s == c && n > 0 = isReplica ss (n-1) c
    | otherwise       = False

main = do
    a <- getLine
    b <- getLine
    c <- getChar
    let result = isReplica a (read b) c
    print result