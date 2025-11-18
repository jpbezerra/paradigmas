insert :: Int -> [Int] -> [Int]
insert x [] = [x]
insert x (a:as)
    | x <= a = x : a : as
    | otherwise = a : insert x as
    
ehPrimo :: Int -> Bool
ehPrimo n
    | n < 2     = False
    | otherwise = testaPrimo n (n-1)
        where   testaPrimo n 1 = True
                testaPrimo n aux
                    | n `mod` aux == 0 = False
                    | otherwise        = testaPrimo n (aux-1)

sumPrimeSquares1 :: Int -> Int -> Int
sumPrimeSquares1 a b = sum (map (^2) (filter ehPrimo [a..b]))

sumPrimeSquares1Lambda :: Int -> Int -> Int
sumPrimeSquares1Lambda a b = sum (map (\x -> x * x) (filter ehPrimo [a..b]))

sumPrimeSquares2 :: Int -> Int -> Int
sumPrimeSquares2 a b = sum [x * x | x <- [a..b], ehPrimo x]

main :: IO ()
main = do
    print (insert 3 [1,2,4,5])
    print (ehPrimo 11)
    print (sumPrimeSquares1 1 10)
    print (sumPrimeSquares1Lambda 1 10)
    print (sumPrimeSquares2 1 10)