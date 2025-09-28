isCrescent :: (Int -> Int) -> Int -> Bool
isCrescent f 0 = True
isCrescent f n = f n > f (n-1) && isCrescent f (n-1)

quadrados :: [Int] -> [Int]
quadrados xs = map (^2) xs

somaQuadrados :: [Int] -> Int
somaQuadrados xs = foldr (\x acc -> x^2 + acc) 0 xs

positivos :: [Int] -> [Int]
positivos xs = filter (>0) xs

map' :: (a -> b) -> [a] -> [b]
map' f = foldr (\x acc -> f x : acc) []

filter' :: (a -> Bool) -> [a] -> [a]
filter' p = foldr (\x acc -> if p x then x : acc else acc) []

maiores :: [[Int]] -> [Int]
maiores xss = map maximum xss

takeWhile' :: (a -> Bool) -> [a] -> [a]
takeWhile' _ [] = []
takeWhile' p (x:xs)
    | p x       = x : takeWhile' p xs
    | otherwise = []

dropWhile' :: (a -> Bool) -> [a] -> [a]
dropWhile' _ [] = []
dropWhile' p (x:xs)
    | p x       = dropWhile' p xs
    | otherwise = x : xs

flip :: (t -> u -> v) -> (u -> t -> v)
flip f = \x y -> f y x

main :: IO ()
main = do
    print (isCrescent (\x -> x + 1) 10)
    print (isCrescent (\x -> x * x) 10)
    print (isCrescent (\x -> -x) 10)
    print (quadrados [1..10])
    print (somaQuadrados [1..10])
    print (positivos [-5, 3, 0, -2, 8])
    print (map' (*2) [1..5])
    print (filter' (>3) [1..5])
    print (maiores [[1..5], [2..6], [3..7]])
    print (takeWhile' (<5) [1..10])
    print (dropWhile' (<5) [1..10])
    print (flip (^) 2 3)
    print (flip (++) " world!" "Hello")