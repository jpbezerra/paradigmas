splitBy :: Char -> String -> [String]
splitBy _ "" = []
splitBy c s  =
    let (first, rest) = span (/= c) s
        remaining = drop 1 rest
    in first : splitBy c remaining
    
stringToDouble :: String -> Double
stringToDouble "" = 0
stringToDouble s  = read s :: Double

minMaxCartao :: String -> (Double, Double)
minMaxCartao "" = (0,0)
minMaxCartao s  = 
    let stringSplit = splitBy ';' s
        valores = [stringToDouble x | (x,i) <- zip stringSplit [0..], i `mod` 3 == 2, x /= ""]
    in (minimum valores, maximum valores)
  
main = do
    a <- getLine
    let result = minMaxCartao a
    print result