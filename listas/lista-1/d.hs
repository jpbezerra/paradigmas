splitBy :: Char -> String -> [String]
splitBy _ "" = []
splitBy c s  =
    let (first, rest) = span (/= c) s
        remaining = drop 1 rest
    in first : splitBy c remaining
    
stringToDouble :: String -> Double
stringToDouble "" = 0
stringToDouble s  = read s :: Double

logMes :: String -> String -> Double
logMes mes db = 
    let stringSplit = splitBy ';' db
        valoresMes = [
                     stringToDouble (stringSplit !! (i+2))
                     | (x,i) <- zip stringSplit [0..],
                     i `mod` 3 == 0, 
                     drop (length x - 3) x == mes
                     ]
    in sum valoresMes

main = do
    a <- getLine
    b <- getLine
    let result = logMes a b
    print result