double :: [Int] -> [Int]
double [] = []
double (x:xs) = (2*x) : double xs

member :: [Int] -> Int -> Bool
member [] _ = False
member (y:ys) x = (y == x) || member ys x

digits :: String -> String
digits [] = []
digits (x:xs)
  | isDigit x = x : digits xs
  | otherwise = digits xs
  where isDigit c = c >= '0' && c <= '9'

sumPairs :: [Int] -> [Int] -> [Int]
sumPairs [] _ = []
sumPairs _ [] = []
sumPairs (x:xs) (y:ys) = (x+y) : sumPairs xs ys

quickSort :: [Int] -> [Int]
quickSort [] = []
quickSort (x:xs) =
  let smallerSorted = quickSort [y | y <- xs, y <= x]
      biggerSorted = quickSort [y | y <- xs, y > x]
  in smallerSorted ++ [x] ++ biggerSorted

fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

fibNthEven :: Int -> [Int]
fibNthEven n = take n [x | i <- [0..], let x = fib i, even x]

somaDigitos :: Int -> Int
somaDigitos 0 = 0
somaDigitos n = (n `mod` 10) + somaDigitos (n `div` 10)

inserir :: Int -> [Int] -> [Int]
inserir x [] = [x]
inserir x (y:ys)
    | somaDigitos x <= somaDigitos y = x : y : ys
    | otherwise = y : inserir x ys

ordenar :: [Int] -> [Int]
ordenar [] = []
ordenar (x:xs) = inserir x (ordenar xs)

main :: IO ()
main = do
  putStrLn (show (double [1, 2, 3]))
  putStrLn (show (member [1, 2, 3] 2))
  putStrLn (show (digits "a1b2c3"))
  putStrLn (show (sumPairs [1, 2, 3] [4, 5, 6]))
  putStrLn (show (quickSort [3, 1, 4, 1, 5, 9, 2, 6]))
  putStrLn (show (fibNthEven 10))
  putStrLn (show (ordenar [5,12,70,8,25,3,150]))